package test;

//import io.tiledb.api.Domain;
import io.tiledb.api.tiledb;
import io.tiledb.api.tiledbJNI;
import io.tiledb.api.tiledb_array_type_t;
import io.tiledb.api.tiledb_config_t;
import io.tiledb.api.tiledb_ctx_t;
import io.tiledb.api.tiledb_datatype_t;
import io.tiledb.api.tiledb_dimension_t;
import io.tiledb.api.tiledb_object_t;
import io.tiledb.api.tiledb_query_status_t;
import io.tiledb.api.tiledb_query_type_t;
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
		tiledb_ctx_t ctx = new tiledb_ctx_t();
		tiledb_config_t config = new tiledb_config_t();

		tiledb.tiledb_config_create(config);
		tiledb.tiledb_config_set(config, "sm.tile_cache_size", "1");
		tiledb.tiledb_ctx_create(ctx, config);
		
		int[] x = {1,2,3,4,5,6,7,8,9,10,11};
		tiledb_dimension_t dim = new tiledb_dimension_t();
		tiledb.tiledb_dimension_create(ctx, dim, "test11σδγσδγσδ1", tiledb_datatype_t.TILEDB_INT32, x, x);
		String[] name = new String[1];
		tiledb.tiledb_dimension_get_name(ctx, dim, name);
		System.out.println("!!!"+name[0]);
//		tiledbJNI.tiledb_dimension_create(jarg1, jarg2, jarg3, jarg4, jarg5, jarg6)
		
//		//check config
//		Config c = new Config();
//		c.set("test", "value");
//		c.unset("test");
//		Context ctx = new Context(c);
//		
//		Domain domain = new Domain(ctx);
//		Dimension d1 = Dimensio
//		
		
//
//		  // Create dimensions
//		  uint64_t dim_domain[] = {1, 4, 1, 4};
//		  uint64_t tile_extents[] = {2, 2};
//		  tiledb_dimension_t* d1;
//		  tiledb_dimension_create(
//		      ctx, &d1, "d1", TILEDB_UINT64, &dim_domain[0], &tile_extents[0]);
//		  tiledb_dimension_t* d2;
//		  tiledb_dimension_create(
//		      ctx, &d2, "d2", TILEDB_UINT64, &dim_domain[2], &tile_extents[1]);
//
//		  // Create domain
//		  tiledb_domain_t* domain;
//		  tiledb_domain_create(ctx, &domain);
//		  tiledb_domain_add_dimension(ctx, domain, d1);
//		  tiledb_domain_add_dimension(ctx, domain, d2);
//
//		  // Create attributes
//		  tiledb_attribute_t* a1;
//		  tiledb_attribute_create(ctx, &a1, "a1", TILEDB_INT32);
//		  tiledb_attribute_set_compressor(ctx, a1, TILEDB_BLOSC, -1);
//		  tiledb_attribute_set_cell_val_num(ctx, a1, 1);
//		  tiledb_attribute_t* a2;
//		  tiledb_attribute_create(ctx, &a2, "a2", TILEDB_CHAR);
//		  tiledb_attribute_set_compressor(ctx, a2, TILEDB_GZIP, -1);
//		  tiledb_attribute_set_cell_val_num(ctx, a2, TILEDB_VAR_NUM);
//		  tiledb_attribute_t* a3;
//		  tiledb_attribute_create(ctx, &a3, "a3", TILEDB_FLOAT32);
//		  tiledb_attribute_set_compressor(ctx, a3, TILEDB_ZSTD, -1);
//		  tiledb_attribute_set_cell_val_num(ctx, a3, 2);
//
//		  // Create array schema
//		  tiledb_array_schema_t* array_schema;
//		  tiledb_array_schema_create(ctx, &array_schema);
//		  tiledb_array_schema_set_cell_order(ctx, array_schema, TILEDB_ROW_MAJOR);
//		  tiledb_array_schema_set_tile_order(ctx, array_schema, TILEDB_ROW_MAJOR);
//		  tiledb_array_schema_set_array_type(ctx, array_schema, TILEDB_SPARSE);
//		  tiledb_array_schema_set_capacity(ctx, array_schema, 2);
//		  tiledb_array_schema_set_domain(ctx, array_schema, domain);
//		  tiledb_array_schema_add_attribute(ctx, array_schema, a1);
//		  tiledb_array_schema_add_attribute(ctx, array_schema, a2);
//		  tiledb_array_schema_add_attribute(ctx, array_schema, a3);
//
//		  // Check array schema
//		  if (tiledb_array_schema_check(ctx, array_schema) != TILEDB_OK) {
//		    printf("Invalid array schema\n");
//		    return -1;
//		  }
//
//		  // Create array
//		  tiledb_array_create(ctx, "my_sparse_array", array_schema);
//
//		  // Clean up
//		  tiledb_attribute_free(ctx, a1);
//		  tiledb_attribute_free(ctx, a2);
//		  tiledb_attribute_free(ctx, a3);
//		  tiledb_dimension_free(ctx, d1);
//		  tiledb_dimension_free(ctx, d2);
//		  tiledb_domain_free(ctx, domain);
//		  tiledb_array_schema_free(ctx, array_schema);
//		  tiledb_ctx_free(ctx);
//
//		  return 0;

	}
}
