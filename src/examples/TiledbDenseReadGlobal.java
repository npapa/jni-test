package examples;

//import io.tiledb.api.Domain;

import io.tiledb.api.*;

public class TiledbDenseReadGlobal {

  static {
    System.loadLibrary("tiledb");
  }

  public static void main(String[] args) {
    // Create TileDB context
    SWIGTYPE_p_p_tiledb_ctx_t ctxpp = tiledb.new_tiledb_ctx_tpp();
    SWIGTYPE_p_p_tiledb_config_t configpp = tiledb.new_tiledb_config_tpp();
    SWIGTYPE_p_p_tiledb_error_t errorpp = tiledb.new_tiledb_error_tpp();
    tiledb.tiledb_config_create(configpp, errorpp);
    tiledb_config_t config = tiledb.tiledb_config_tpp_value(configpp);
    tiledb.tiledb_ctx_create(ctxpp, config);
    tiledb_ctx_t ctx = tiledb.tiledb_ctx_tpp_value(ctxpp);

    // Print non-empty domain
    uint64_tArray domain = new uint64_tArray(4);
    SWIGTYPE_p_int is_emptyp = tiledb.new_intp();
    tiledb.tiledb_array_get_non_empty_domain(ctx, "my_dense_array",
        PointerUtils.toVoid(domain), is_emptyp);
    System.out.println("Non-empty domain:" + tiledb.intp_value(is_emptyp));
    System.out.println("d1: (" + domain.getitem(0) + ", "
        + domain.getitem(1) + ")");
    System.out.println("d2: (" + domain.getitem(2) + ", "
        + domain.getitem(3) + ")");

    // // Print maximum buffer sizes for each attribute
    SWIGTYPE_p_p_char attributes = tiledb.new_charpArray(3);
    tiledb.charpArray_setitem(attributes, 0, "a1");
    tiledb.charpArray_setitem(attributes, 1, "a2");
    tiledb.charpArray_setitem(attributes, 2, "a3");
    uint64_tArray buffer_sizes = new uint64_tArray(4);
    long[] subarray_ = {1, 4, 1, 4};
    uint64_tArray subarray = Utils.newUint64Array(subarray_);
    tiledb.tiledb_array_compute_max_read_buffer_sizes(ctx,
        "my_dense_array", PointerUtils.toVoid(subarray), attributes, 3,
        buffer_sizes.cast());
    System.out.println("Maximum buffer sizes:");
    System.out.println("a1: " + buffer_sizes.getitem(0));
    System.out.println("a2: (" + buffer_sizes.getitem(1) + ", "
        + buffer_sizes.getitem(2) + ")");
    System.out.println("a3: " + buffer_sizes.getitem(3));

    // Prepare cell buffers
    int a1_size = buffer_sizes.getitem(0).intValue() / UtilsJNI.sizeOfInt32();
    int a2_size = buffer_sizes.getitem(1).intValue() / UtilsJNI.sizeOfUint64();
    int a2_var_size = buffer_sizes.getitem(2).intValue() / UtilsJNI.sizeOfInt8();
    int a3_size = buffer_sizes.getitem(3).intValue() / UtilsJNI.sizeOfFloat();

    int32_tArray buffer_a1 = new int32_tArray(a1_size);
    uint64_tArray buffer_a2 = new uint64_tArray(a2_size);
    int8_tArray buffer_var_a2 = new int8_tArray(a2_var_size);
    floatArray buffer_a3 = new floatArray(a3_size);


    SWIGTYPE_p_p_void buffers = tiledb.new_voidpArray(4);
    tiledb.voidpArray_setitem(buffers, 0, PointerUtils.toVoid(buffer_a1));
    tiledb.voidpArray_setitem(buffers, 1, PointerUtils.toVoid(buffer_a2));
    tiledb.voidpArray_setitem(buffers, 2,
        PointerUtils.toVoid(buffer_var_a2));
    tiledb.voidpArray_setitem(buffers, 3, PointerUtils.toVoid(buffer_a3));

    // Create query
    SWIGTYPE_p_p_tiledb_query_t querypp = tiledb.new_tiledb_query_tpp();
    tiledb.tiledb_query_create(ctx, querypp, "my_dense_array",
        tiledb_query_type_t.TILEDB_READ);
    tiledb_query_t query = tiledb.tiledb_query_tpp_value(querypp);
    tiledb.tiledb_query_set_buffers(ctx, query, attributes, 3, buffers,
        buffer_sizes.cast());
    tiledb.tiledb_query_set_layout(ctx, query,
        tiledb_layout_t.TILEDB_GLOBAL_ORDER);

    // Submit query
    tiledb.tiledb_query_submit(ctx, query);


    a1_size = buffer_sizes.getitem(0).intValue() / UtilsJNI.sizeOfInt32();
    a2_size = buffer_sizes.getitem(1).intValue() / UtilsJNI.sizeOfUint64();
    a2_var_size = buffer_sizes.getitem(2).intValue() / UtilsJNI.sizeOfInt8();
    a3_size = buffer_sizes.getitem(3).intValue() / UtilsJNI.sizeOfFloat();

    // Print cell values (assumes all attributes are read)
    int[] a1 = Utils.int32ArrayGet(buffer_a1,a1_size);
    long[] a2 = Utils.uint64ArrayGet(buffer_a2,a2_size);
    byte[] a2_var = Utils.int8ArrayGet(buffer_var_a2, a2_var_size);
    float[] a3 = Utils.floatArrayGet(buffer_a3,a3_size);

    int result_num = a1_size;
    System.out.println("Result num: " + result_num);
    System.out.println("a1, a2, a3[0], a3[1]");
    System.out.println("-----------------------------------------");
    for (int i = 0; i < result_num; ++i) {
      System.out.print(a1[i] + ", ");
      int var_size = (i != result_num - 1) ? (int)a2[i + 1] - (int)a2[i]
          : a2_var_size - (int)a2[i];
      System.out.print(Utils.substring(a2_var, (int)a2[i], var_size)
          + ", ");
      System.out.print(a3[2 * i] + " "
          + a3[2 * i + 1] + ", ");
      System.out.println();
    }

    // Clean up
    tiledb.tiledb_query_free(ctx, query);
    tiledb.tiledb_ctx_free(ctx);

  }
}
