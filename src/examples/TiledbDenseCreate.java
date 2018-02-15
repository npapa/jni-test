package examples;

//import io.tiledb.api.Domain;
import io.tiledb.api.*;
import io.tiledb.custom.ArrayUtils;
import io.tiledb.custom.Version;

public class TiledbDenseCreate {

	static {
		System.loadLibrary("tiledb");
	}
	
	public static void main(String[] args) {
		//Create TileDB context
		SWIGTYPE_p_p_tiledb_ctx_t ctxpp = tiledb.new_tiledb_ctx_tpp();
		SWIGTYPE_p_p_tiledb_config_t configpp = tiledb.new_tiledb_config_tpp();
		SWIGTYPE_p_p_tiledb_error_t errorpp  = tiledb.new_tiledb_error_tpp();
		tiledb.tiledb_config_create(configpp, errorpp);
		tiledb_config_t config = tiledb.tiledb_config_tpp_value(configpp);
		tiledb.tiledb_ctx_create(ctxpp, config);
		tiledb_ctx_t ctx = tiledb.tiledb_ctx_tpp_value(ctxpp);

		// Create dimensions
		long[] d1_domain_ = { 1, 4 };
		uint64_tArray d1_domain = ArrayUtils.newUint64Array(d1_domain_);
		long[] d1_tile_extents_ = { 2 };
		uint64_tArray d1_tile_extents = ArrayUtils
				.newUint64Array(d1_tile_extents_);
		SWIGTYPE_p_p_tiledb_dimension_t d1pp = tiledb
				.new_tiledb_dimension_tpp();
		tiledb.tiledb_dimension_create(ctx, d1pp, "d1",
				tiledb_datatype_t.TILEDB_UINT64,
				PointerUtils.toVoid(d1_domain),
				PointerUtils.toVoid(d1_tile_extents));
		tiledb_dimension_t d1 = tiledb.tiledb_dimension_tpp_value(d1pp);

		long[] d2_domain_ = { 1, 4 };
		uint64_tArray d2_domain = ArrayUtils.newUint64Array(d2_domain_);
		long[] d2_tile_extents_ = { 2 };
		uint64_tArray d2_tile_extents = ArrayUtils
				.newUint64Array(d2_tile_extents_);
		SWIGTYPE_p_p_tiledb_dimension_t d2pp = tiledb
				.new_tiledb_dimension_tpp();
		tiledb.tiledb_dimension_create(ctx, d2pp, "d2",
				tiledb_datatype_t.TILEDB_UINT64,
				PointerUtils.toVoid(d2_domain),
				PointerUtils.toVoid(d2_tile_extents));
		tiledb_dimension_t d2 = tiledb.tiledb_dimension_tpp_value(d2pp);

		// Create domain
		SWIGTYPE_p_p_tiledb_domain_t domainpp = tiledb.new_tiledb_domain_tpp();
		tiledb.tiledb_domain_create(ctx, domainpp);
		tiledb_domain_t domain = tiledb.tiledb_domain_tpp_value(domainpp);
		tiledb.tiledb_domain_add_dimension(ctx, domain, d1);
		tiledb.tiledb_domain_add_dimension(ctx, domain, d2);

		// Create attributes
		SWIGTYPE_p_p_tiledb_attribute_t a1pp = tiledb
				.new_tiledb_attribute_tpp();
		tiledb.tiledb_attribute_create(ctx, a1pp, "a1",
				tiledb_datatype_t.TILEDB_INT32);
		tiledb_attribute_t a1 = tiledb.tiledb_attribute_tpp_value(a1pp);
		tiledb.tiledb_attribute_set_compressor(ctx, a1,
				tiledb_compressor_t.TILEDB_GZIP, -1);
		tiledb.tiledb_attribute_set_cell_val_num(ctx, a1, 1);

		SWIGTYPE_p_p_tiledb_attribute_t a2pp = tiledb
				.new_tiledb_attribute_tpp();
		tiledb.tiledb_attribute_create(ctx, a2pp, "a2",
				tiledb_datatype_t.TILEDB_CHAR);
		tiledb_attribute_t a2 = tiledb.tiledb_attribute_tpp_value(a2pp);
		tiledb.tiledb_attribute_set_compressor(ctx, a2,
				tiledb_compressor_t.TILEDB_GZIP, -1);
		tiledb.tiledb_attribute_set_cell_val_num(ctx, a2, -1);

		SWIGTYPE_p_p_tiledb_attribute_t a3pp = tiledb
				.new_tiledb_attribute_tpp();
		tiledb.tiledb_attribute_create(ctx, a3pp, "a3",
				tiledb_datatype_t.TILEDB_FLOAT32);
		tiledb_attribute_t a3 = tiledb.tiledb_attribute_tpp_value(a3pp);
		tiledb.tiledb_attribute_set_compressor(ctx, a3,
				tiledb_compressor_t.TILEDB_ZSTD, -1);
		tiledb.tiledb_attribute_set_cell_val_num(ctx, a3, 2);

		// Create array schema
		SWIGTYPE_p_p_tiledb_array_schema_t array_schemapp = tiledb
				.new_tiledb_array_schema_tpp();
		tiledb.tiledb_array_schema_create(ctx, array_schemapp,
				tiledb_array_type_t.TILEDB_DENSE);
		tiledb_array_schema_t array_schema = tiledb
				.tiledb_array_schema_tpp_value(array_schemapp);
		tiledb.tiledb_array_schema_set_cell_order(ctx, array_schema,
				tiledb_layout_t.TILEDB_ROW_MAJOR);
		tiledb.tiledb_array_schema_set_tile_order(ctx, array_schema,
				tiledb_layout_t.TILEDB_ROW_MAJOR);
		tiledb.tiledb_array_schema_set_domain(ctx, array_schema, domain);
		tiledb.tiledb_array_schema_add_attribute(ctx, array_schema, a1);
		tiledb.tiledb_array_schema_add_attribute(ctx, array_schema, a2);
		tiledb.tiledb_array_schema_add_attribute(ctx, array_schema, a3);

		// Check array metadata
		if (tiledb.tiledb_array_schema_check(ctx, array_schema) != tiledb.TILEDB_OK) {
			System.out.println("Invalid array metadata");
			System.exit(1);
		}
		// Create array
		if (tiledb.tiledb_array_create(ctx, "my_dense_array", array_schema) != tiledb.TILEDB_OK) {
			System.out.println("error");
		}

		tiledb.tiledb_array_schema_dump_stdout(ctx, array_schema);

		// Clean up
		tiledb.tiledb_attribute_free(ctx, a1);
		tiledb.tiledb_attribute_free(ctx, a2);
		tiledb.tiledb_attribute_free(ctx, a3);
		tiledb.tiledb_dimension_free(ctx, d1);
		tiledb.tiledb_dimension_free(ctx, d2);
		tiledb.tiledb_domain_free(ctx, domain);
		tiledb.tiledb_array_schema_free(ctx, array_schema);
		tiledb.tiledb_config_free(config);
		tiledb.tiledb_ctx_free(ctx);
	}
}
