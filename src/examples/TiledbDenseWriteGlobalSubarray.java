package examples;

//import io.tiledb.api.Domain;

import io.tiledb.api.*;
import io.tiledb.custom.Version;

public class TiledbDenseWriteGlobalSubarray {

  static {
    System.loadLibrary("tiledb");
  }

  public static void main(String[] args) {
    // Create TileDB context
    SWIGTYPE_p_p_tiledb_ctx_t ctxpp = tiledb.new_tiledb_ctx_tpp();
    tiledb.tiledb_ctx_create(ctxpp, null);
    tiledb_ctx_t ctx = tiledb.tiledb_ctx_tpp_value(ctxpp);

    // Prepare cell buffers - #1
    int[] buffer_a1 = {112, 113, 114, 115};
    intArray a1 = ArrayUtils.newIntArray(buffer_a1);
    long[] buffer_a2 = {0, 1, 3, 6};
    uint64_tArray a2 = ArrayUtils.newUint64Array(buffer_a2);
    String buffer_var_a2 = "MNNOOOPPPP";
    charArray var_a2 = ArrayUtils.newCharArray(buffer_var_a2);

    float buffer_a3[] = {
        112.1f, 112.2f, 113.1f, 113.2f, 114.1f, 114.2f, 115.1f, 115.2f};
    floatArray a3 = ArrayUtils.newFloatArray(buffer_a3);


    SWIGTYPE_p_p_void buffers = tiledb.new_voidpArray(4);
    tiledb.voidpArray_setitem(buffers, 0, PointerUtils.toVoid(a1));
    tiledb.voidpArray_setitem(buffers, 1, PointerUtils.toVoid(a2));
    tiledb.voidpArray_setitem(buffers, 2, PointerUtils.toVoid(var_a2));
    tiledb.voidpArray_setitem(buffers, 3, PointerUtils.toVoid(a3));
    long buffer_sizes_[] = {buffer_a1.length * 4, buffer_a2.length * 8,
        buffer_var_a2.length(), buffer_a3.length * 4};
    uint64_tArray buffer_sizes = ArrayUtils.newUint64Array(buffer_sizes_);

    // Create query
    SWIGTYPE_p_p_tiledb_query_t querypp = tiledb.new_tiledb_query_tpp();
    SWIGTYPE_p_p_char attributes = tiledb.new_charpArray(3);
    tiledb.charpArray_setitem(attributes, 0, "a1");
    tiledb.charpArray_setitem(attributes, 1, "a2");
    tiledb.charpArray_setitem(attributes, 2, "a3");

    long[] subarray_ = {3, 4, 3, 4};
    uint64_tArray subarray = ArrayUtils.newUint64Array(subarray_);
    tiledb.tiledb_query_create(ctx, querypp, "my_dense_array",
        tiledb_query_type_t.TILEDB_WRITE);
    tiledb_query_t query = tiledb.tiledb_query_tpp_value(querypp);
    tiledb.tiledb_query_set_layout(ctx, query,
        tiledb_layout_t.TILEDB_GLOBAL_ORDER);
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
