package examples;

import io.tiledb.api.*;

public class TiledbArrayConsolidate {

  public static void main(String[] args) {
    // Create TileDB context
    SWIGTYPE_p_p_tiledb_ctx_t ctxpp = tiledb.new_tiledb_ctx_tpp();
    tiledb.tiledb_ctx_create(ctxpp, null);
    tiledb_ctx_t ctx = tiledb.tiledb_ctx_tpp_value(ctxpp);

    // Consolidate array
    tiledb.tiledb_array_consolidate(ctx, "my_dense_array");

    // Clean up
    tiledb.tiledb_ctx_free(ctx);
  }
}
