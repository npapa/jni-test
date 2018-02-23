package examples;

//import io.tiledb.api.Domain;

import io.tiledb.api.*;
import io.tiledb.custom.Version;

public class TiledbObjectLsWalk {

  static {
    System.loadLibrary("tiledb");
  }

  public static void main(String[] args) {
    // Create TileDB context
    SWIGTYPE_p_p_tiledb_ctx_t ctxpp = tiledb.new_tiledb_ctx_tpp();
    tiledb.tiledb_ctx_create(ctxpp, null);
    tiledb_ctx_t ctx = tiledb.tiledb_ctx_tpp_value(ctxpp);

    // List children
    System.out.printf("List children:\n");
    tiledb.tiledb_ls(ctx, "my_group", tiledb.native_walk_callback(), null);

    // Walk in a path with a pre- and post-order traversal
    System.out.printf("\nPreorder traversal:\n");
    tiledb.tiledb_object_walk(ctx, "my_group", tiledb_walk_order_t.TILEDB_PREORDER, tiledb.native_walk_callback(), null);
    System.out.printf("\nPostorder traversal:\n");
    tiledb.tiledb_object_walk(ctx, "my_group", tiledb_walk_order_t.TILEDB_POSTORDER, tiledb.native_walk_callback(), null);

    // Clean up
    tiledb.tiledb_ctx_free(ctx);
  }

}
