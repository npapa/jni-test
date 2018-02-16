package examples;

//import io.tiledb.api.Domain;
import io.tiledb.api.*;
import io.tiledb.custom.ArrayUtils;
import io.tiledb.custom.Version;

public class TiledbError {

	static {
		System.loadLibrary("tiledb");
	}

	public static void main(String[] args) {
		// Create TileDB context
		SWIGTYPE_p_p_tiledb_ctx_t ctxpp = tiledb.new_tiledb_ctx_tpp();
		tiledb.tiledb_ctx_create(ctxpp, null);
		tiledb_ctx_t ctx = tiledb.tiledb_ctx_tpp_value(ctxpp);

		// Create a group
		int rc = tiledb.tiledb_group_create(ctx, "my_group");
		if (rc == tiledb.TILEDB_OK)
			System.out.printf("Group created successfully!\n");
		else if (rc == tiledb.TILEDB_ERR)
			print_error(ctx);

		// Create the same group again - ERROR
		rc = tiledb.tiledb_group_create(ctx, "my_group");
		if (rc == tiledb.TILEDB_OK)
			System.out.printf("Group created successfully!\n");
		else if (rc == tiledb.TILEDB_ERR)
			print_error(ctx);

		// Clean up
		tiledb.tiledb_ctx_free(ctx);
	}

	public static void print_error(tiledb_ctx_t ctx) {

		SWIGTYPE_p_p_tiledb_error_t errpp = tiledb.new_tiledb_error_tpp();
		tiledb.tiledb_ctx_get_last_error(ctx, errpp);
		tiledb_error_t err = tiledb.tiledb_error_tpp_value(errpp);

		SWIGTYPE_p_p_char msg = tiledb.new_charpp();
		tiledb.tiledb_error_message(err, msg);
		System.out.printf("%s\n", tiledb.charpp_value(msg));
		tiledb.tiledb_error_free(err);
	}

}
