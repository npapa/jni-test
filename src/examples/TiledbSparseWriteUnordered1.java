package examples;

//import io.tiledb.api.Domain;
import io.tiledb.api.*;
import io.tiledb.custom.ArrayUtils;
import io.tiledb.custom.Version;

public class TiledbSparseWriteUnordered1 {

	static {
		System.loadLibrary("tiledb");
	}

	/*
	 * It shows how to write unordered cells to a sparse array in a single
	 * write.
	 * 
	 * You need to run the following to make this work:
	 * 
	 * ./tiledb_sparse_create_c ./tiledb_sparse_write_unordered_1_c
	 */
	public static void main(String[] args) {
		// Create TileDB context
		SWIGTYPE_p_p_tiledb_ctx_t ctxpp = tiledb.new_tiledb_ctx_tpp();
		tiledb.tiledb_ctx_create(ctxpp, null);
		tiledb_ctx_t ctx = tiledb.tiledb_ctx_tpp_value(ctxpp);

		// Prepare cell buffers - #1
		int[] buffer_a1 = { 7, 5, 0, 6, 4, 3, 1, 2 };
		intArray a1 = ArrayUtils.newIntArray(buffer_a1);
		long[] buffer_a2 = { 0, 4, 6, 7, 10, 11, 15, 17 };
		uint64_tArray a2 = ArrayUtils.newUint64Array(buffer_a2);
		String buffer_var_a2 = "hhhhffagggeddddbbccc";
		charArray var_a2 = ArrayUtils.newCharArray(buffer_var_a2);

		float buffer_a3[] = { 7.1f, 7.2f, 5.1f, 5.2f, 0.1f, 0.2f, 6.1f, 6.2f,
				4.1f, 4.2f, 3.1f, 3.2f, 1.1f, 1.2f, 2.1f, 2.2f };
		floatArray a3 = ArrayUtils.newFloatArray(buffer_a3);

		long buffer_coords_[] = {3, 4, 4, 2, 1, 1, 3, 3, 3, 1, 2, 3, 1, 2, 1, 4};
		uint64_tArray buffer_coords = ArrayUtils.newUint64Array(buffer_coords_);

		SWIGTYPE_p_p_void buffers = tiledb.new_voidpArray(5);
		tiledb.voidpArray_setitem(buffers, 0, PointerUtils.toVoid(a1));
		tiledb.voidpArray_setitem(buffers, 1, PointerUtils.toVoid(a2));
		tiledb.voidpArray_setitem(buffers, 2, PointerUtils.toVoid(var_a2));
		tiledb.voidpArray_setitem(buffers, 3, PointerUtils.toVoid(a3));
		tiledb.voidpArray_setitem(buffers, 4,
				PointerUtils.toVoid(buffer_coords));
		long buffer_sizes_[] = { buffer_a1.length * 4, buffer_a2.length * 8,
				buffer_var_a2.length(), buffer_a3.length * 4,
				buffer_coords_.length * 8 };
		uint64_tArray buffer_sizes = ArrayUtils.newUint64Array(buffer_sizes_);

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
				tiledb_layout_t.TILEDB_UNORDERED);
		tiledb.tiledb_query_set_buffers(ctx, query, attributes, 4, buffers,
				buffer_sizes.cast());

		// Submit query
		tiledb.tiledb_query_submit(ctx, query);

		// Clean up
		tiledb.tiledb_query_free(ctx, query);
		tiledb.tiledb_ctx_free(ctx);

	}
}
