package examples;

//import io.tiledb.api.Domain;

import io.tiledb.api.*;
import io.tiledb.custom.Version;

public class TiledbObjectMove {

  static {
    System.loadLibrary("tiledb");
  }

  public static void main(String[] args) {
    // Create TileDB context
    SWIGTYPE_p_p_tiledb_ctx_t ctxpp = tiledb.new_tiledb_ctx_tpp();
    tiledb.tiledb_ctx_create(ctxpp, null);
    tiledb_ctx_t ctx = tiledb.tiledb_ctx_tpp_value(ctxpp);

    // Rename a valid group and array
    tiledb.tiledb_object_move(ctx, "my_group", "my_group_2", 1);
    tiledb.tiledb_object_move(ctx, "my_dense_array",
        "my_group_2/dense_arrays/my_dense_array", 0);

    // Rename an invalid path
    int rc = tiledb.tiledb_object_move(ctx, "invalid_path", "path", 0);
    if (rc == tiledb.TILEDB_ERR)
      System.out.printf("Failed moving invalid path\n");

    // Clean up
    tiledb.tiledb_ctx_free(ctx);
  }
}
