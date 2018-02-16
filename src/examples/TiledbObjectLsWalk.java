package examples;

//import io.tiledb.api.Domain;
import io.tiledb.api.*;
import io.tiledb.custom.ArrayUtils;
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

		// Create a group
		tiledb.tiledb_group_create(ctx, "my_group");

		// Create two groups inside the first group
		tiledb.tiledb_group_create(ctx, "my_group/dense_arrays");
		tiledb.tiledb_group_create(ctx, "my_group/sparse_arrays");

		// Clean up
		tiledb.tiledb_ctx_free(ctx);
	}

}