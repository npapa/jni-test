package examples;

//import io.tiledb.api.Domain;

import io.tiledb.api.*;

public class TiledbDenseWriteOrderedSubarray {

  static {
    System.loadLibrary("tiledb");
  }

  public static void main(String[] args) {
    // Create TileDB context
    SWIGTYPE_p_p_tiledb_ctx_t ctxpp = tiledb.new_tiledb_ctx_tpp();
    tiledb.tiledb_ctx_create(ctxpp, null);
    tiledb_ctx_t ctx = tiledb.tiledb_ctx_tpp_value(ctxpp);

    // Prepare cell buffers - #1
    int[] buffer_a1 = {9, 12, 13, 11, 14, 15};
    intArray a1 = Utils.newIntArray(buffer_a1);
    long[] buffer_a2 = {0, 2, 3, 5, 9, 12};
    uint64_tArray a2 = Utils.newUint64Array(buffer_a2);
    String buffer_var_a2 = "jjmnnllllooopppp";
    charArray var_a2 = Utils.newCharArray(buffer_var_a2);

    float buffer_a3[] = {9.1f, 9.2f, 12.1f, 12.2f, 13.1f, 13.2f, 11.1f,
        11.2f, 14.1f, 14.2f, 15.1f, 15.2f};
    floatArray a3 = Utils.newFloatArray(buffer_a3);


    SWIGTYPE_p_p_void buffers = tiledb.new_voidpArray(4);
    tiledb.voidpArray_setitem(buffers, 0, PointerUtils.toVoid(a1));
    tiledb.voidpArray_setitem(buffers, 1, PointerUtils.toVoid(a2));
    tiledb.voidpArray_setitem(buffers, 2, PointerUtils.toVoid(var_a2));
    tiledb.voidpArray_setitem(buffers, 3, PointerUtils.toVoid(a3));
    long buffer_sizes_[] = {buffer_a1.length * 4, buffer_a2.length * 8,
        buffer_var_a2.length(), buffer_a3.length * 4};
    uint64_tArray buffer_sizes = Utils.newUint64Array(buffer_sizes_);

    // Create query
    SWIGTYPE_p_p_tiledb_query_t querypp = tiledb.new_tiledb_query_tpp();
    SWIGTYPE_p_p_char attributes = tiledb.new_charpArray(3);
    tiledb.charpArray_setitem(attributes, 0, "a1");
    tiledb.charpArray_setitem(attributes, 1, "a2");
    tiledb.charpArray_setitem(attributes, 2, "a3");

    long[] subarray_ = {3, 4, 2, 4};
    uint64_tArray subarray = Utils.newUint64Array(subarray_);
    tiledb.tiledb_query_create(ctx, querypp, "my_dense_array",
        tiledb_query_type_t.TILEDB_WRITE);
    tiledb_query_t query = tiledb.tiledb_query_tpp_value(querypp);
    tiledb.tiledb_query_set_layout(ctx, query,
        tiledb_layout_t.TILEDB_ROW_MAJOR);
    tiledb.tiledb_query_set_subarray(ctx, query, PointerUtils.toVoid(subarray));
    tiledb.tiledb_query_set_buffers(ctx, query, attributes, 3, buffers,
        buffer_sizes.cast());

    // Submit query
    tiledb.tiledb_query_submit(ctx, query);

    // Clean up
    tiledb.tiledb_query_free(ctx, query);
    tiledb.tiledb_ctx_free(ctx);

  }
}
