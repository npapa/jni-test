package examples;

//import io.tiledb.api.Domain;

import io.tiledb.api.*;
import io.tiledb.custom.Version;

public class TiledbDenseWriteGlobal1 {

  static {
    System.loadLibrary("tiledb");
  }

  public static void main(String[] args) {
    // Create TileDB context
    SWIGTYPE_p_p_tiledb_ctx_t ctxpp = tiledb.new_tiledb_ctx_tpp();
    tiledb.tiledb_ctx_create(ctxpp, null);
    tiledb_ctx_t ctx = tiledb.tiledb_ctx_tpp_value(ctxpp);

    // Prepare cell buffers
    byte[] buffer_a1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
        15};
    int8_tArray a1 = ArrayUtils.newInt8_tArray(buffer_a1);
    long[] buffer_a2 = {0, 1, 3, 6, 10, 11, 13, 16, 20, 21, 23, 26, 30,
        31, 33, 36};
    uint64_tArray a2 = ArrayUtils.newUint64Array(buffer_a2);
    String buffer_var_a2 = "aβcccdddd" + "effggghhhh" + "ijjkkkllll"
        + "mnnooopppp";
    charArray var_a2 = ArrayUtils.newCharArray(buffer_var_a2);

    float buffer_a3[] = {0.1f, 0.2f, 1.1f, 1.2f, 2.1f, 2.2f, 3.1f, 3.2f,
        4.1f, 4.2f, 5.1f, 5.2f, 6.1f, 6.2f, 7.1f, 7.2f, 8.1f, 8.2f,
        9.1f, 9.2f, 10.1f, 10.2f, 11.1f, 11.2f, 12.1f, 12.2f, 13.1f,
        13.2f, 14.1f, 14.2f, 15.1f, 15.2f};
    floatArray a3 = ArrayUtils.newFloatArray(buffer_a3);

    SWIGTYPE_p_p_void buffers = tiledb.new_voidpArray(4);
    tiledb.voidpArray_setitem(buffers, 0, PointerUtils.toVoid(a1));
    tiledb.voidpArray_setitem(buffers, 1, PointerUtils.toVoid(a2));
    tiledb.voidpArray_setitem(buffers, 2, PointerUtils.toVoid(var_a2));
    tiledb.voidpArray_setitem(buffers, 3, PointerUtils.toVoid(a3));
    long buffer_sizes_[] = {buffer_a1.length * ArrayUtils.sizeOfType(buffer_a1),
        buffer_a2.length * ArrayUtils.sizeOfType(buffer_a2),
        buffer_var_a2.length() * ArrayUtils.sizeOfType(buffer_var_a2),
        buffer_a3.length * ArrayUtils.sizeOfType(buffer_a3)};
    uint64_tArray buffer_sizes = ArrayUtils.newUint64Array(buffer_sizes_);

    // Create query
    SWIGTYPE_p_p_tiledb_query_t querypp = tiledb.new_tiledb_query_tpp();
    SWIGTYPE_p_p_char attributes = tiledb.new_charpArray(3);
    tiledb.charpArray_setitem(attributes, 0, "a1");
    tiledb.charpArray_setitem(attributes, 1, "a2");
    tiledb.charpArray_setitem(attributes, 2, "a3");
    // String[] attributes = {"a1", "a2", "a3"};
    tiledb.tiledb_query_create(ctx, querypp, "my_dense_array",
        tiledb_query_type_t.TILEDB_WRITE);
    tiledb_query_t query = tiledb.tiledb_query_tpp_value(querypp);
    tiledb.tiledb_query_set_layout(ctx, query,
        tiledb_layout_t.TILEDB_GLOBAL_ORDER);

    tiledb.tiledb_query_set_buffers(ctx, query, attributes, 3, buffers,
        buffer_sizes.cast());

    // Submit query
    tiledb.tiledb_query_submit(ctx, query);

    // Clean up
    tiledb.tiledb_query_free(ctx, query);
    tiledb.tiledb_ctx_free(ctx);

  }
}
