package examples;

//import io.tiledb.api.Domain;

import io.tiledb.api.*;
import io.tiledb.custom.Version;

public class TiledbGroupCreate {

  static {
    System.loadLibrary("tiledb");
  }

  public static void main(String[] args) {
    // Create TileDB context
    SWIGTYPE_p_p_tiledb_ctx_t ctxpp = tiledb.new_tiledb_ctx_tpp();
    tiledb.tiledb_ctx_create(ctxpp, null);
    tiledb_ctx_t ctx = tiledb.tiledb_ctx_tpp_value(ctxpp);
//
//
//		  // List children
//		  System.out.printf("List children:\n");
//		  SWIGTYPE_p_f_p_q_const__char_enum_tiledb_object_t_p_void__int print_path;
//		tiledb.tiledb_ls(ctx, "my_group", print_path, NULL);
//
//		  // Walk in a path with a pre- and post-order traversal
//		  System.out.printf("\nPreorder traversal:\n");
//		  tiledb.tiledb_object_walk(ctx, "my_group", TILEDB_PREORDER, print_path, NULL);
//		  System.out.printf("\nPostorder traversal:\n");
//		  tiledb.tiledb_object_walk(ctx, "my_group", TILEDB_POSTORDER, print_path, NULL);
//
//		  // Finalize context
//		  tiledb_ctx_free(ctx);


    // Clean up
    tiledb.tiledb_ctx_free(ctx);
  }

}
