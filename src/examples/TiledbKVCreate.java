package examples;

//import io.tiledb.api.Domain;

import java.math.BigInteger;

import io.tiledb.api.*;

public class TiledbKVCreate {

  static {
    System.loadLibrary("tiledb");
  }

  /*
   * It shows how to create a key-value store.
   */
  public static void main(String[] args) {
    // Create TileDB context
    SWIGTYPE_p_p_tiledb_ctx_t ctxpp = tiledb.new_tiledb_ctx_tpp();
    tiledb.tiledb_ctx_create(ctxpp, null);
    tiledb_ctx_t ctx = tiledb.tiledb_ctx_tpp_value(ctxpp);

    // Create attributes
    SWIGTYPE_p_p_tiledb_attribute_t a1pp = tiledb
        .new_tiledb_attribute_tpp();
    tiledb.tiledb_attribute_create(ctx, a1pp, "a1",
        tiledb_datatype_t.TILEDB_INT32);
    tiledb_attribute_t a1 = tiledb.tiledb_attribute_tpp_value(a1pp);
    tiledb.tiledb_attribute_set_compressor(ctx, a1,
        tiledb_compressor_t.TILEDB_BLOSC, -1);
    tiledb.tiledb_attribute_set_cell_val_num(ctx, a1, 1);

    SWIGTYPE_p_p_tiledb_attribute_t a2pp = tiledb
        .new_tiledb_attribute_tpp();
    tiledb.tiledb_attribute_create(ctx, a2pp, "a2",
        tiledb_datatype_t.TILEDB_CHAR);
    tiledb_attribute_t a2 = tiledb.tiledb_attribute_tpp_value(a2pp);
    tiledb.tiledb_attribute_set_compressor(ctx, a2,
        tiledb_compressor_t.TILEDB_GZIP, -1);
    tiledb.tiledb_attribute_set_cell_val_num(ctx, a2,
        tiledb.tiledb_var_num());

    SWIGTYPE_p_p_tiledb_attribute_t a3pp = tiledb
        .new_tiledb_attribute_tpp();
    tiledb.tiledb_attribute_create(ctx, a3pp, "a3",
        tiledb_datatype_t.TILEDB_FLOAT32);
    tiledb_attribute_t a3 = tiledb.tiledb_attribute_tpp_value(a3pp);
    tiledb.tiledb_attribute_set_compressor(ctx, a3,
        tiledb_compressor_t.TILEDB_ZSTD, -1);
    tiledb.tiledb_attribute_set_cell_val_num(ctx, a3, 2);

    // Create kv schema
    SWIGTYPE_p_p_tiledb_kv_schema_t kv_schemapp = tiledb
        .new_tiledb_kv_schema_tpp();
    tiledb.tiledb_kv_schema_create(ctx, kv_schemapp);
    tiledb_kv_schema_t kv_schema = tiledb
        .tiledb_kv_schema_tpp_value(kv_schemapp);
    tiledb.tiledb_kv_schema_add_attribute(ctx, kv_schema, a1);
    tiledb.tiledb_kv_schema_add_attribute(ctx, kv_schema, a2);
    tiledb.tiledb_kv_schema_add_attribute(ctx, kv_schema, a3);

    if (tiledb.tiledb_kv_schema_check(ctx, kv_schema) != tiledb.TILEDB_OK) {
      System.out.println("Invalid key-value metadata");
      System.exit(1);
    }
    // Create kv
    tiledb.tiledb_kv_create(ctx, "my_kv", kv_schema);

    // Dump the key-value schema in ASCII format in standard output
    tiledb.tiledb_kv_schema_dump_stdout(ctx, kv_schema);

    // Clean up
    tiledb.tiledb_attribute_free(ctx, a1);
    tiledb.tiledb_attribute_free(ctx, a2);
    tiledb.tiledb_attribute_free(ctx, a3);
    tiledb.tiledb_kv_schema_free(ctx, kv_schema);
    tiledb.tiledb_ctx_free(ctx);
  }
}
