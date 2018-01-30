package test;

//import io.tiledb.api.Domain;
import io.tiledb.api.tiledb;
import io.tiledb.api.*;
import io.tiledb.custom.Version;

public class Test {

	static {
		System.loadLibrary("tiledb");
	}
	
	public static void main(String[] args) {
		
		//check enums
		System.out.println(tiledb_object_t.TILEDB_ARRAY.toString()+" : "+tiledb_object_t.TILEDB_ARRAY.swigValue());
		System.out.println(tiledb_query_type_t.TILEDB_READ.toString()+" : "+tiledb_query_type_t.TILEDB_READ.swigValue());
		System.out.println(tiledb_query_type_t.TILEDB_WRITE.toString()+" : "+tiledb_query_type_t.TILEDB_WRITE.swigValue());
		System.out.println(tiledb_query_status_t.TILEDB_COMPLETED.toString()+" : "+tiledb_query_status_t.TILEDB_COMPLETED.swigValue());
		tiledb_array_type_t.pointer t = new tiledb_array_type_t.pointer();
		tiledb.testt(t);
		System.out.println("ok");
		System.out.println("type java: "+t.get().toString());
		
		
		//check version
		Version version = new Version();
		System.out.println(version);
		
		//Create context
		tiledb_ctx_t ctx = new tiledb_ctx_t();
		tiledb_config_t config = new tiledb_config_t();

		//Create config
		tiledb.tiledb_config_create(config);
		tiledb.tiledb_config_set(config, "sm.tile_cache_size", "1000");
		tiledb.tiledb_ctx_create(ctx, config);
		
		//Create dimensions
		int[] rows_domain = {1, 4};
		int[] rows_tile_extents = {2};
		tiledb_dimension_t rows = new tiledb_dimension_t();
		tiledb.tiledb_dimension_create(ctx, rows, "rows", tiledb_datatype_t.TILEDB_INT32, rows_domain, rows_tile_extents);

		int[] col_domain = {1, 8};
		int[] col_tile_extents = {4};
		tiledb_dimension_t col = new tiledb_dimension_t();
		tiledb.tiledb_dimension_create(ctx, col, "columns", tiledb_datatype_t.TILEDB_INT32, col_domain, col_tile_extents);
		String[] name = new String[1];
		tiledb.tiledb_dimension_get_name(ctx, rows, name);
		System.out.println(name[0]);
		tiledb.tiledb_dimension_get_name(ctx, col, name);
		System.out.println(name[0]);
		

		// Create domain
		tiledb_domain_t domain = new tiledb_domain_t();
		tiledb.tiledb_domain_create(ctx, domain);
		tiledb.tiledb_domain_add_dimension(ctx, domain, rows);
		tiledb.tiledb_domain_add_dimension(ctx, domain, col);
		int[] got_domain = new int[2];
		tiledb.tiledb_dimension_get_domain_i(ctx, rows, got_domain);
		System.out.println(got_domain.length+ " "+got_domain[0]+ " "+got_domain[1]);
		tiledb.tiledb_dimension_get_domain_i(ctx, col, got_domain);
		System.out.println(got_domain.length+ " "+got_domain[0]+ " "+got_domain[1]);
		
		// Create attributes
	    tiledb_attribute_t a1 = new tiledb_attribute_t();
		tiledb.tiledb_attribute_create(ctx, a1, "a1", tiledb_datatype_t.TILEDB_INT32);
		tiledb.tiledb_attribute_set_compressor(ctx, a1, tiledb_compressor_t.TILEDB_BLOSC, -1);
		tiledb.tiledb_attribute_set_cell_val_num(ctx, a1, 1);

	    // Create array schema
		tiledb_array_schema_t array_schema = new tiledb_array_schema_t();
		tiledb.tiledb_array_schema_create(ctx, array_schema);
		tiledb.tiledb_array_schema_set_cell_order(ctx, array_schema, tiledb_layout_t.TILEDB_ROW_MAJOR);
		tiledb.tiledb_array_schema_set_tile_order(ctx, array_schema, tiledb_layout_t.TILEDB_ROW_MAJOR);
		tiledb.tiledb_array_schema_set_array_type(ctx, array_schema, tiledb_array_type_t.TILEDB_DENSE);
		tiledb.tiledb_array_schema_set_domain(ctx, array_schema, domain);
		tiledb.tiledb_array_schema_add_attribute(ctx, array_schema, a1);
		
		// Check array metadata
		if (tiledb.tiledb_array_schema_check(ctx, array_schema) != tiledb.TILEDB_OK) {
			System.out.println("Invalid array metadata");
		    System.exit(1);
		}
		// Create array
		tiledb.tiledb_array_create(ctx, "my_dense_array1", array_schema);

		// Clean up
		tiledb.tiledb_attribute_free(ctx, a1);
		tiledb.tiledb_dimension_free(ctx, rows);
		tiledb.tiledb_dimension_free(ctx, col);
		tiledb.tiledb_domain_free(ctx, domain);
		tiledb.tiledb_array_schema_free(ctx, array_schema);
		tiledb.tiledb_ctx_free(ctx);
		tiledb.tiledb_config_free(config);
	}
}
