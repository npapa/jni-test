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
    tiledb.tiledb_object_walk_jc(ctx, "my_group", tiledb_walk_order_t.TILEDB_PREORDER, tiledb.java_path_callback(), new ReadCallback(""));
    System.out.printf("\nPostorder traversal:\n");
    tiledb.tiledb_object_walk_jc(ctx, "my_group", tiledb_walk_order_t.TILEDB_POSTORDER, tiledb.java_path_callback(), new ReadCallback(""));

    // Clean up
    tiledb.tiledb_ctx_free(ctx);
  }

  private static class ReadCallback extends CallbackPath {

    private final String data;

    public ReadCallback(String data){
      this.data = data;
    }

    @Override
    public int call(String path, tiledb_object_t type) {
      System.out.printf("Wowwww %s ", path);
      switch (type) {
        case TILEDB_ARRAY:
          System.out.printf("ARRAY");
          break;
        case TILEDB_KEY_VALUE:
          System.out.printf("KEY_VALUE");
          break;
        case TILEDB_GROUP:
          System.out.printf("GROUP");
          break;
        default:
          System.out.printf("INVALID");
      }
      System.out.printf("\n");

      // Always iterate till the end
      return 1;
    }
  }
}
