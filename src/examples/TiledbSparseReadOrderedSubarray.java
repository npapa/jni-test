package examples;

//import io.tiledb.api.Domain;
import io.tiledb.api.*;
import io.tiledb.custom.Version;

public class TiledbSparseReadOrderedSubarray {

	static {
		System.loadLibrary("tiledb");
	}

	/*
	 * It shows how to read from a sparse array, constraining the read to a
	 * specific subarray. This time the cells are returned in row-major order
	 * within the specified subarray.
	 * 
	 * You need to run the following to make it work:
	 * 
	 * $ ./tiledb_sparse_create_c 
	 * $ ./tiledb_sparse_write_global_1_c 
	 * $ ./tiledb_sparse_read_ordered_subarray_c
	 */
	public static void main(String[] args) {
		// Create TileDB context
		SWIGTYPE_p_p_tiledb_ctx_t ctxpp = tiledb.new_tiledb_ctx_tpp();
		tiledb.tiledb_ctx_create(ctxpp, null);
		tiledb_ctx_t ctx = tiledb.tiledb_ctx_tpp_value(ctxpp);

		// Compute maximum buffer sizes for each attribute
		SWIGTYPE_p_p_char attributes = tiledb.new_charpArray(4);
		tiledb.charpArray_setitem(attributes, 0, "a1");
		tiledb.charpArray_setitem(attributes, 1, "a2");
		tiledb.charpArray_setitem(attributes, 2, "a3");
		tiledb.charpArray_setitem(attributes, 3, tiledb.tiledb_coords());

		uint64_tArray buffer_sizes = new uint64_tArray(5);
		long[] subarray_ = { 3, 4, 2, 4 };
		uint64_tArray subarray = ArrayUtils.newUint64Array(subarray_);
		tiledb.tiledb_array_compute_max_read_buffer_sizes(ctx,
				"my_sparse_array", PointerUtils.toVoid(subarray), attributes, 4,
				buffer_sizes.cast());

		// Prepare cell buffers
		intArray buffer_a1 = new intArray(
				buffer_sizes.getitem(0).intValue() / 4);
		uint64_tArray buffer_a2 = new uint64_tArray(buffer_sizes.getitem(1)
				.intValue() / 8);
		charArray buffer_var_a2 = new charArray(buffer_sizes.getitem(2)
				.intValue());
		floatArray buffer_a3 = new floatArray(buffer_sizes.getitem(3)
				.intValue() / 4);
		uint64_tArray buffer_coords = new uint64_tArray(buffer_sizes.getitem(4)
				.intValue() / 8);

		SWIGTYPE_p_p_void buffers = tiledb.new_voidpArray(5);
		tiledb.voidpArray_setitem(buffers, 0, PointerUtils.toVoid(buffer_a1));
		tiledb.voidpArray_setitem(buffers, 1, PointerUtils.toVoid(buffer_a2));
		tiledb.voidpArray_setitem(buffers, 2,
				PointerUtils.toVoid(buffer_var_a2));
		tiledb.voidpArray_setitem(buffers, 3, PointerUtils.toVoid(buffer_a3));
		tiledb.voidpArray_setitem(buffers, 4, PointerUtils.toVoid(buffer_coords));

		// Create query
		SWIGTYPE_p_p_tiledb_query_t querypp = tiledb.new_tiledb_query_tpp();
		tiledb.tiledb_query_create(ctx, querypp, "my_sparse_array",
				tiledb_query_type_t.TILEDB_READ);
		tiledb_query_t query = tiledb.tiledb_query_tpp_value(querypp);
		tiledb.tiledb_query_set_layout(ctx, query,
				tiledb_layout_t.TILEDB_ROW_MAJOR);
		tiledb.tiledb_query_set_subarray(ctx, query,
				PointerUtils.toVoid(subarray));
		tiledb.tiledb_query_set_buffers(ctx, query, attributes, 4, buffers,
				buffer_sizes.cast());

		// Submit query
		tiledb.tiledb_query_submit(ctx, query);

		// Print cell values (assumes all attributes are read)
		int result_num = buffer_sizes.getitem(0).intValue() / 4;
		System.out.println("Result num: " + result_num);
		System.out.printf("%8s%9s%9s%11s%10s\n", tiledb.tiledb_coords(), "a1", "a2", "a3[0]", "a3[1]");
		System.out.printf("------------------------------------\n");
		for (int i = 0; i < result_num; ++i) {
			System.out.printf(
		            "(%s, %s)",
		            buffer_coords.getitem(2 * i),
		            buffer_coords.getitem(2 * i + 1));
			System.out.printf("%10d ", buffer_a1.getitem(i));
			int var_size = (i != result_num - 1) ? buffer_a2.getitem(i + 1)
					.intValue() - buffer_a2.getitem(i).intValue()
					: buffer_sizes.getitem(2).intValue()
							- buffer_a2.getitem(i).intValue();
			System.out.printf("%10s", ArrayUtils.substring(buffer_var_a2, buffer_a2
					.getitem(i).intValue(), var_size));
			System.out.printf("%10.1f%10.1f\n", buffer_a3.getitem(2 * i),
					buffer_a3.getitem(2 * i + 1));
		}

		// Clean up
		tiledb.tiledb_query_free(ctx, query);
		tiledb.tiledb_ctx_free(ctx);
	}
}
