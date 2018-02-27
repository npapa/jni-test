package examples;

//import io.tiledb.api.Domain;

import io.tiledb.api.*;

public class TiledbSparseWriteGlobal2 {

  static {
    System.loadLibrary("tiledb");
  }

  public static void main(String[] args) {
    // Create TileDB context
    SWIGTYPE_p_p_tiledb_ctx_t ctxpp = tiledb.new_tiledb_ctx_tpp();
    tiledb.tiledb_ctx_create(ctxpp, null);
    tiledb_ctx_t ctx = tiledb.tiledb_ctx_tpp_value(ctxpp);

    // Prepare cell buffers - #1
    int[] buffer_a1 = {0, 1, 2};
    intArray a1 = Utils.newIntArray(buffer_a1);
    long[] buffer_a2 = {0, 1, 3, 6, 10, 11, 13, 16};
    uint64_tArray a2 = Utils.newUint64Array(buffer_a2);
    String buffer_var_a2 = "abbcccddddeffggghhhh";
    charArray var_a2 = Utils.newCharArray(buffer_var_a2);

    float buffer_a3[] = {0.1f, 0.2f, 1.1f, 1.2f, 2.1f, 2.2f, 3.1f, 3.2f,
        4.1f, 4.2f, 5.1f, 5.2f, 6.1f, 6.2f, 7.1f, 7.2f};
    floatArray a3 = Utils.newFloatArray(buffer_a3);

    long buffer_coords_[] = {1, 1, 1, 2};
    uint64_tArray buffer_coords = Utils.newUint64Array(buffer_coords_);

    SWIGTYPE_p_p_void buffers = tiledb.new_voidpArray(5);
    tiledb.voidpArray_setitem(buffers, 0, PointerUtils.toVoid(a1));
    tiledb.voidpArray_setitem(buffers, 1, PointerUtils.toVoid(a2));
    tiledb.voidpArray_setitem(buffers, 2, PointerUtils.toVoid(var_a2));
    tiledb.voidpArray_setitem(buffers, 3, PointerUtils.toVoid(a3));
    tiledb.voidpArray_setitem(buffers, 4,
        PointerUtils.toVoid(buffer_coords));
    long buffer_sizes_[] = {buffer_a1.length * 4, buffer_a2.length * 8,
        buffer_var_a2.length(), buffer_a3.length * 4,
        buffer_coords_.length * 8};
    uint64_tArray buffer_sizes = Utils.newUint64Array(buffer_sizes_);

    // Create query
    SWIGTYPE_p_p_tiledb_query_t querypp = tiledb.new_tiledb_query_tpp();
    SWIGTYPE_p_p_char attributes = tiledb.new_charpArray(4);
    tiledb.charpArray_setitem(attributes, 0, "a1");
    tiledb.charpArray_setitem(attributes, 1, "a2");
    tiledb.charpArray_setitem(attributes, 2, "a3");
    tiledb.charpArray_setitem(attributes, 3, tiledb.tiledb_coords());
    tiledb.tiledb_query_create(ctx, querypp, "my_sparse_array",
        tiledb_query_type_t.TILEDB_WRITE);
    tiledb_query_t query = tiledb.tiledb_query_tpp_value(querypp);
    tiledb.tiledb_query_set_layout(ctx, query,
        tiledb_layout_t.TILEDB_GLOBAL_ORDER);
    tiledb.tiledb_query_set_buffers(ctx, query, attributes, 4, buffers,
        buffer_sizes.cast());

    // Submit query - #1
    tiledb.tiledb_query_submit(ctx, query);

    // Prepare cell buffers - #2
    int[] buffer_a1_2 = {3, 4, 5, 6, 7};
    intArray a1_2 = Utils.newIntArray(buffer_a1_2);
    long[] buffer_a2_2 = {};
    uint64_tArray a2_2 = Utils.newUint64Array(buffer_a2_2);
    String buffer_var_a2_2 = "";
    charArray var_a2_2 = Utils.newCharArray(buffer_var_a2_2);

    float buffer_a3_2[] = {};
    floatArray a3_2 = Utils.newFloatArray(buffer_a3_2);

    long buffer_coords_2_[] = {1, 4, 2, 3, 3, 1, 4, 2, 3, 3, 3, 4};
    uint64_tArray buffer_coords_2 = Utils.newUint64Array(buffer_coords_2_);

    SWIGTYPE_p_p_void buffers_2 = tiledb.new_voidpArray(5);
    tiledb.voidpArray_setitem(buffers_2, 0, PointerUtils.toVoid(a1_2));
    tiledb.voidpArray_setitem(buffers_2, 1, PointerUtils.toVoid(a2_2));
    tiledb.voidpArray_setitem(buffers_2, 2, PointerUtils.toVoid(var_a2_2));
    tiledb.voidpArray_setitem(buffers_2, 3, PointerUtils.toVoid(a3_2));
    tiledb.voidpArray_setitem(buffers_2, 4, PointerUtils.toVoid(buffer_coords_2));
    long buffer_sizes_2_[] = {buffer_a1_2.length * 4,
        buffer_a2_2.length * 8, buffer_var_a2_2.length(),
        buffer_a3_2.length * 4,
        buffer_coords_2_.length * 8};
    uint64_tArray buffer_sizes_2 = Utils
        .newUint64Array(buffer_sizes_2_);

    // Reset buffers
    tiledb.tiledb_query_reset_buffers(ctx, query, buffers_2,
        buffer_sizes_2.cast());

    // Submit query - #2
    tiledb.tiledb_query_submit(ctx, query);

    // Clean up
    tiledb.tiledb_query_free(ctx, query);
    tiledb.tiledb_ctx_free(ctx);

  }
}
