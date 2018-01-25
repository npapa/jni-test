/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.tiledb.api;

public class tiledb implements tiledbConstants {
  public static int tiledb_dimension_create(tiledb_ctx_t ctx, tiledb_dimension_t dim, String name, tiledb_datatype_t type, int[] dim_domain, int[] tile_extent) {
    return tiledbJNI.tiledb_dimension_create__SWIG_0(tiledb_ctx_t.getCPtr(ctx), ctx, dim, name, type.swigValue(), dim_domain, tile_extent);
  }

  public static String tiledb_coords() {
    return tiledbJNI.tiledb_coords();
  }

  public static long tiledb_var_num() {
    return tiledbJNI.tiledb_var_num();
  }

  public static void tiledb_version(int[] major, int[] minor, int[] rev) {
    tiledbJNI.tiledb_version(major, minor, rev);
  }

  public static void test(tiledb_array_type_t.pointer test) {
    tiledbJNI.test(test);
  }

  public static void testt(tiledb_array_type_t.pointer test) {
    tiledbJNI.testt(test);
  }

  public static void printTest(int[] x) {
    tiledbJNI.printTest(x);
  }

  public static int tiledb_config_create(tiledb_config_t config) {
    return tiledbJNI.tiledb_config_create(config);
  }

  public static int tiledb_config_free(tiledb_config_t config) {
    return tiledbJNI.tiledb_config_free(tiledb_config_t.getCPtr(config), config);
  }

  public static int tiledb_config_set(tiledb_config_t config, String param, String value) {
    return tiledbJNI.tiledb_config_set(tiledb_config_t.getCPtr(config), config, param, value);
  }

  public static int tiledb_config_set_from_file(tiledb_config_t config, String filename) {
    return tiledbJNI.tiledb_config_set_from_file(tiledb_config_t.getCPtr(config), config, filename);
  }

  public static int tiledb_config_unset(tiledb_config_t config, String param) {
    return tiledbJNI.tiledb_config_unset(tiledb_config_t.getCPtr(config), config, param);
  }

  public static int tiledb_ctx_create(tiledb_ctx_t ctx, tiledb_config_t config) {
    return tiledbJNI.tiledb_ctx_create(ctx, tiledb_config_t.getCPtr(config), config);
  }

  public static int tiledb_ctx_free(tiledb_ctx_t ctx) {
    return tiledbJNI.tiledb_ctx_free(tiledb_ctx_t.getCPtr(ctx), ctx);
  }

  public static int tiledb_error_last(tiledb_ctx_t ctx, tiledb_error_t err) {
    return tiledbJNI.tiledb_error_last(tiledb_ctx_t.getCPtr(ctx), ctx, err);
  }

  public static int tiledb_error_message(tiledb_ctx_t ctx, tiledb_error_t err, String[] errmsg) {
    return tiledbJNI.tiledb_error_message(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_error_t.getCPtr(err), err, errmsg);
  }

  public static int tiledb_error_free(tiledb_ctx_t ctx, tiledb_error_t err) {
    return tiledbJNI.tiledb_error_free(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_error_t.getCPtr(err), err);
  }

  public static int tiledb_group_create(tiledb_ctx_t ctx, String group_uri) {
    return tiledbJNI.tiledb_group_create(tiledb_ctx_t.getCPtr(ctx), ctx, group_uri);
  }

  public static int tiledb_attribute_create(tiledb_ctx_t ctx, tiledb_attribute_t attr, String name, tiledb_datatype_t type) {
    return tiledbJNI.tiledb_attribute_create(tiledb_ctx_t.getCPtr(ctx), ctx, attr, name, type.swigValue());
  }

  public static int tiledb_attribute_free(tiledb_ctx_t ctx, tiledb_attribute_t attr) {
    return tiledbJNI.tiledb_attribute_free(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_attribute_t.getCPtr(attr), attr);
  }

  public static int tiledb_attribute_set_compressor(tiledb_ctx_t ctx, tiledb_attribute_t attr, tiledb_compressor_t compressor, int compression_level) {
    return tiledbJNI.tiledb_attribute_set_compressor(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_attribute_t.getCPtr(attr), attr, compressor.swigValue(), compression_level);
  }

  public static int tiledb_attribute_set_cell_val_num(tiledb_ctx_t ctx, tiledb_attribute_t attr, long cell_val_num) {
    return tiledbJNI.tiledb_attribute_set_cell_val_num(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_attribute_t.getCPtr(attr), attr, cell_val_num);
  }

  public static int tiledb_attribute_get_name(tiledb_ctx_t ctx, tiledb_attribute_t attr, String[] name) {
    return tiledbJNI.tiledb_attribute_get_name(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_attribute_t.getCPtr(attr), attr, name);
  }

  public static int tiledb_attribute_get_type(tiledb_ctx_t ctx, tiledb_attribute_t attr, tiledb_datatype_t.pointer type) {
    return tiledbJNI.tiledb_attribute_get_type(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_attribute_t.getCPtr(attr), attr, type);
  }

  public static int tiledb_attribute_get_compressor(tiledb_ctx_t ctx, tiledb_attribute_t attr, tiledb_compressor_t.pointer compressor, int[] compression_level) {
    return tiledbJNI.tiledb_attribute_get_compressor(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_attribute_t.getCPtr(attr), attr, compressor, compression_level);
  }

  public static int tiledb_attribute_get_cell_val_num(tiledb_ctx_t ctx, tiledb_attribute_t attr, SWIGTYPE_p_unsigned_int cell_val_num) {
    return tiledbJNI.tiledb_attribute_get_cell_val_num(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_attribute_t.getCPtr(attr), attr, SWIGTYPE_p_unsigned_int.getCPtr(cell_val_num));
  }

  public static int tiledb_attribute_dump(tiledb_ctx_t ctx, tiledb_attribute_t attr, SWIGTYPE_p_FILE out) {
    return tiledbJNI.tiledb_attribute_dump(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_attribute_t.getCPtr(attr), attr, SWIGTYPE_p_FILE.getCPtr(out));
  }

  public static int tiledb_domain_create(tiledb_ctx_t ctx, tiledb_domain_t domain) {
    return tiledbJNI.tiledb_domain_create(tiledb_ctx_t.getCPtr(ctx), ctx, domain);
  }

  public static int tiledb_domain_free(tiledb_ctx_t ctx, tiledb_domain_t domain) {
    return tiledbJNI.tiledb_domain_free(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_domain_t.getCPtr(domain), domain);
  }

  public static int tiledb_domain_get_type(tiledb_ctx_t ctx, tiledb_domain_t domain, tiledb_datatype_t.pointer type) {
    return tiledbJNI.tiledb_domain_get_type(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_domain_t.getCPtr(domain), domain, type);
  }

  public static int tiledb_domain_get_rank(tiledb_ctx_t ctx, tiledb_domain_t domain, SWIGTYPE_p_unsigned_int rank) {
    return tiledbJNI.tiledb_domain_get_rank(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_domain_t.getCPtr(domain), domain, SWIGTYPE_p_unsigned_int.getCPtr(rank));
  }

  public static int tiledb_domain_add_dimension(tiledb_ctx_t ctx, tiledb_domain_t domain, tiledb_dimension_t dim) {
    return tiledbJNI.tiledb_domain_add_dimension(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_domain_t.getCPtr(domain), domain, tiledb_dimension_t.getCPtr(dim), dim);
  }

  public static int tiledb_dimension_from_index(tiledb_ctx_t ctx, tiledb_domain_t domain, long index, tiledb_dimension_t dim) {
    return tiledbJNI.tiledb_dimension_from_index(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_domain_t.getCPtr(domain), domain, index, dim);
  }

  public static int tiledb_dimension_from_name(tiledb_ctx_t ctx, tiledb_domain_t domain, String name, tiledb_dimension_t dim) {
    return tiledbJNI.tiledb_dimension_from_name(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_domain_t.getCPtr(domain), domain, name, dim);
  }

  public static int tiledb_domain_dump(tiledb_ctx_t ctx, tiledb_domain_t domain, SWIGTYPE_p_FILE out) {
    return tiledbJNI.tiledb_domain_dump(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_domain_t.getCPtr(domain), domain, SWIGTYPE_p_FILE.getCPtr(out));
  }

  public static int tiledb_dimension_create(tiledb_ctx_t ctx, tiledb_dimension_t dim, String name, tiledb_datatype_t type, SWIGTYPE_p_void dim_domain, SWIGTYPE_p_void tile_extent) {
    return tiledbJNI.tiledb_dimension_create__SWIG_1(tiledb_ctx_t.getCPtr(ctx), ctx, dim, name, type.swigValue(), SWIGTYPE_p_void.getCPtr(dim_domain), SWIGTYPE_p_void.getCPtr(tile_extent));
  }

  public static int tiledb_dimension_free(tiledb_ctx_t ctx, tiledb_dimension_t dim) {
    return tiledbJNI.tiledb_dimension_free(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_dimension_t.getCPtr(dim), dim);
  }

  public static int tiledb_dimension_get_name(tiledb_ctx_t ctx, tiledb_dimension_t dim, String[] name) {
    return tiledbJNI.tiledb_dimension_get_name(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_dimension_t.getCPtr(dim), dim, name);
  }

  public static int tiledb_dimension_get_type(tiledb_ctx_t ctx, tiledb_dimension_t dim, tiledb_datatype_t.pointer type) {
    return tiledbJNI.tiledb_dimension_get_type(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_dimension_t.getCPtr(dim), dim, type);
  }

  public static int tiledb_dimension_get_domain(tiledb_ctx_t ctx, tiledb_dimension_t dim, SWIGTYPE_p_p_void domain) {
    return tiledbJNI.tiledb_dimension_get_domain(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_dimension_t.getCPtr(dim), dim, SWIGTYPE_p_p_void.getCPtr(domain));
  }

  public static int tiledb_dimension_get_tile_extent(tiledb_ctx_t ctx, tiledb_dimension_t dim, SWIGTYPE_p_p_void tile_extent) {
    return tiledbJNI.tiledb_dimension_get_tile_extent(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_dimension_t.getCPtr(dim), dim, SWIGTYPE_p_p_void.getCPtr(tile_extent));
  }

  public static int tiledb_dimension_dump(tiledb_ctx_t ctx, tiledb_dimension_t dim, SWIGTYPE_p_FILE out) {
    return tiledbJNI.tiledb_dimension_dump(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_dimension_t.getCPtr(dim), dim, SWIGTYPE_p_FILE.getCPtr(out));
  }

  public static int tiledb_array_schema_create(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema) {
    return tiledbJNI.tiledb_array_schema_create(tiledb_ctx_t.getCPtr(ctx), ctx, array_schema);
  }

  public static int tiledb_array_schema_free(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema) {
    return tiledbJNI.tiledb_array_schema_free(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema);
  }

  public static int tiledb_array_schema_add_attribute(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema, tiledb_attribute_t attr) {
    return tiledbJNI.tiledb_array_schema_add_attribute(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema, tiledb_attribute_t.getCPtr(attr), attr);
  }

  public static int tiledb_array_schema_set_domain(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema, tiledb_domain_t domain) {
    return tiledbJNI.tiledb_array_schema_set_domain(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema, tiledb_domain_t.getCPtr(domain), domain);
  }

  public static int tiledb_array_schema_set_as_kv(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema) {
    return tiledbJNI.tiledb_array_schema_set_as_kv(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema);
  }

  public static int tiledb_array_schema_set_capacity(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema, java.math.BigInteger capacity) {
    return tiledbJNI.tiledb_array_schema_set_capacity(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema, capacity);
  }

  public static int tiledb_array_schema_set_cell_order(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema, tiledb_layout_t cell_order) {
    return tiledbJNI.tiledb_array_schema_set_cell_order(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema, cell_order.swigValue());
  }

  public static int tiledb_array_schema_set_tile_order(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema, tiledb_layout_t tile_order) {
    return tiledbJNI.tiledb_array_schema_set_tile_order(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema, tile_order.swigValue());
  }

  public static int tiledb_array_schema_set_array_type(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema, tiledb_array_type_t array_type) {
    return tiledbJNI.tiledb_array_schema_set_array_type(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema, array_type.swigValue());
  }

  public static int tiledb_array_schema_set_coords_compressor(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema, tiledb_compressor_t compressor, int compression_level) {
    return tiledbJNI.tiledb_array_schema_set_coords_compressor(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema, compressor.swigValue(), compression_level);
  }

  public static int tiledb_array_schema_set_offsets_compressor(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema, tiledb_compressor_t compressor, int compression_level) {
    return tiledbJNI.tiledb_array_schema_set_offsets_compressor(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema, compressor.swigValue(), compression_level);
  }

  public static int tiledb_array_schema_check(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema) {
    return tiledbJNI.tiledb_array_schema_check(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema);
  }

  public static int tiledb_array_schema_load(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema, String array_uri) {
    return tiledbJNI.tiledb_array_schema_load(tiledb_ctx_t.getCPtr(ctx), ctx, array_schema, array_uri);
  }

  public static int tiledb_array_schema_get_array_type(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema, tiledb_array_type_t.pointer array_type) {
    return tiledbJNI.tiledb_array_schema_get_array_type(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema, array_type);
  }

  public static int tiledb_array_schema_get_capacity(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema, SWIGTYPE_p_unsigned_long_long capacity) {
    return tiledbJNI.tiledb_array_schema_get_capacity(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema, SWIGTYPE_p_unsigned_long_long.getCPtr(capacity));
  }

  public static int tiledb_array_schema_get_cell_order(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema, tiledb_layout_t.pointer cell_order) {
    return tiledbJNI.tiledb_array_schema_get_cell_order(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema, cell_order);
  }

  public static int tiledb_array_schema_get_coords_compressor(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema, tiledb_compressor_t.pointer compressor, int[] compression_level) {
    return tiledbJNI.tiledb_array_schema_get_coords_compressor(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema, compressor, compression_level);
  }

  public static int tiledb_array_schema_get_offsets_compressor(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema, tiledb_compressor_t.pointer compressor, int[] compression_level) {
    return tiledbJNI.tiledb_array_schema_get_offsets_compressor(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema, compressor, compression_level);
  }

  public static int tiledb_array_schema_get_domain(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema, tiledb_domain_t domain) {
    return tiledbJNI.tiledb_array_schema_get_domain(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema, domain);
  }

  public static int tiledb_array_schema_get_as_kv(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema, int[] as_kv) {
    return tiledbJNI.tiledb_array_schema_get_as_kv(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema, as_kv);
  }

  public static int tiledb_array_schema_get_tile_order(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema, tiledb_layout_t.pointer tile_order) {
    return tiledbJNI.tiledb_array_schema_get_tile_order(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema, tile_order);
  }

  public static int tiledb_array_schema_get_num_attributes(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema, SWIGTYPE_p_unsigned_int num_attributes) {
    return tiledbJNI.tiledb_array_schema_get_num_attributes(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema, SWIGTYPE_p_unsigned_int.getCPtr(num_attributes));
  }

  public static int tiledb_attribute_from_index(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema, long index, tiledb_attribute_t attr) {
    return tiledbJNI.tiledb_attribute_from_index(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema, index, attr);
  }

  public static int tiledb_attribute_from_name(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema, String name, tiledb_attribute_t attr) {
    return tiledbJNI.tiledb_attribute_from_name(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema, name, attr);
  }

  public static int tiledb_array_schema_dump(tiledb_ctx_t ctx, tiledb_array_schema_t array_schema, SWIGTYPE_p_FILE out) {
    return tiledbJNI.tiledb_array_schema_dump(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_array_schema_t.getCPtr(array_schema), array_schema, SWIGTYPE_p_FILE.getCPtr(out));
  }

  public static int tiledb_query_create(tiledb_ctx_t ctx, tiledb_query_t query, String array_uri, tiledb_query_type_t type) {
    return tiledbJNI.tiledb_query_create(tiledb_ctx_t.getCPtr(ctx), ctx, query, array_uri, type.swigValue());
  }

  public static int tiledb_query_set_subarray(tiledb_ctx_t ctx, tiledb_query_t query, SWIGTYPE_p_void subarray) {
    return tiledbJNI.tiledb_query_set_subarray(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_query_t.getCPtr(query), query, SWIGTYPE_p_void.getCPtr(subarray));
  }

  public static int tiledb_query_set_buffers(tiledb_ctx_t ctx, tiledb_query_t query, String[] attributes, long attribute_num, SWIGTYPE_p_p_void buffers, SWIGTYPE_p_unsigned_long_long buffer_sizes) {
    return tiledbJNI.tiledb_query_set_buffers(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_query_t.getCPtr(query), query, attributes, attribute_num, SWIGTYPE_p_p_void.getCPtr(buffers), SWIGTYPE_p_unsigned_long_long.getCPtr(buffer_sizes));
  }

  public static int tiledb_query_set_layout(tiledb_ctx_t ctx, tiledb_query_t query, tiledb_layout_t layout) {
    return tiledbJNI.tiledb_query_set_layout(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_query_t.getCPtr(query), query, layout.swigValue());
  }

  public static int tiledb_query_free(tiledb_ctx_t ctx, tiledb_query_t query) {
    return tiledbJNI.tiledb_query_free(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_query_t.getCPtr(query), query);
  }

  public static int tiledb_query_set_kv(tiledb_ctx_t ctx, tiledb_query_t query, tiledb_kv_t kv) {
    return tiledbJNI.tiledb_query_set_kv(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_query_t.getCPtr(query), query, tiledb_kv_t.getCPtr(kv), kv);
  }

  public static int tiledb_query_set_kv_key(tiledb_ctx_t ctx, tiledb_query_t query, SWIGTYPE_p_void key, tiledb_datatype_t type, java.math.BigInteger key_size) {
    return tiledbJNI.tiledb_query_set_kv_key(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_query_t.getCPtr(query), query, SWIGTYPE_p_void.getCPtr(key), type.swigValue(), key_size);
  }

  public static int tiledb_query_submit(tiledb_ctx_t ctx, tiledb_query_t query) {
    return tiledbJNI.tiledb_query_submit(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_query_t.getCPtr(query), query);
  }

  public static int tiledb_query_submit_async(tiledb_ctx_t ctx, tiledb_query_t query, SWIGTYPE_p_f_p_void__void callback, SWIGTYPE_p_void callback_data) {
    return tiledbJNI.tiledb_query_submit_async(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_query_t.getCPtr(query), query, SWIGTYPE_p_f_p_void__void.getCPtr(callback), SWIGTYPE_p_void.getCPtr(callback_data));
  }

  public static int tiledb_query_reset_buffers(tiledb_ctx_t ctx, tiledb_query_t query, SWIGTYPE_p_p_void buffers, SWIGTYPE_p_unsigned_long_long buffer_sizes) {
    return tiledbJNI.tiledb_query_reset_buffers(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_query_t.getCPtr(query), query, SWIGTYPE_p_p_void.getCPtr(buffers), SWIGTYPE_p_unsigned_long_long.getCPtr(buffer_sizes));
  }

  public static int tiledb_query_get_status(tiledb_ctx_t ctx, tiledb_query_t query, tiledb_query_status_t.pointer status) {
    return tiledbJNI.tiledb_query_get_status(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_query_t.getCPtr(query), query, status);
  }

  public static int tiledb_query_get_attribute_status(tiledb_ctx_t ctx, tiledb_query_t query, String attribute_name, tiledb_query_status_t.pointer status) {
    return tiledbJNI.tiledb_query_get_attribute_status(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_query_t.getCPtr(query), query, attribute_name, status);
  }

  public static int tiledb_array_create(tiledb_ctx_t ctx, String array_uri, tiledb_array_schema_t array_schema) {
    return tiledbJNI.tiledb_array_create(tiledb_ctx_t.getCPtr(ctx), ctx, array_uri, tiledb_array_schema_t.getCPtr(array_schema), array_schema);
  }

  public static int tiledb_array_consolidate(tiledb_ctx_t ctx, String array_uri) {
    return tiledbJNI.tiledb_array_consolidate(tiledb_ctx_t.getCPtr(ctx), ctx, array_uri);
  }

  public static int tiledb_object_type(tiledb_ctx_t ctx, String path, tiledb_object_t.pointer type) {
    return tiledbJNI.tiledb_object_type(tiledb_ctx_t.getCPtr(ctx), ctx, path, type);
  }

  public static int tiledb_object_remove(tiledb_ctx_t ctx, String path) {
    return tiledbJNI.tiledb_object_remove(tiledb_ctx_t.getCPtr(ctx), ctx, path);
  }

  public static int tiledb_object_move(tiledb_ctx_t ctx, String old_path, String new_path, int force) {
    return tiledbJNI.tiledb_object_move(tiledb_ctx_t.getCPtr(ctx), ctx, old_path, new_path, force);
  }

  public static int tiledb_object_walk(tiledb_ctx_t ctx, String path, tiledb_walk_order_t order, SWIGTYPE_p_f_p_q_const__char_enum_tiledb_object_t_p_void__int callback, SWIGTYPE_p_void data) {
    return tiledbJNI.tiledb_object_walk(tiledb_ctx_t.getCPtr(ctx), ctx, path, order.swigValue(), SWIGTYPE_p_f_p_q_const__char_enum_tiledb_object_t_p_void__int.getCPtr(callback), SWIGTYPE_p_void.getCPtr(data));
  }

  public static int tiledb_object_ls(tiledb_ctx_t ctx, String path, SWIGTYPE_p_f_p_q_const__char_enum_tiledb_object_t_p_void__int callback, SWIGTYPE_p_void data) {
    return tiledbJNI.tiledb_object_ls(tiledb_ctx_t.getCPtr(ctx), ctx, path, SWIGTYPE_p_f_p_q_const__char_enum_tiledb_object_t_p_void__int.getCPtr(callback), SWIGTYPE_p_void.getCPtr(data));
  }

  public static int tiledb_kv_create(tiledb_ctx_t ctx, tiledb_kv_t kv, long attribute_num, String[] attributes, tiledb_datatype_t.pointer types, SWIGTYPE_p_unsigned_int nitems) {
    return tiledbJNI.tiledb_kv_create(tiledb_ctx_t.getCPtr(ctx), ctx, kv, attribute_num, attributes, types, SWIGTYPE_p_unsigned_int.getCPtr(nitems));
  }

  public static int tiledb_kv_free(tiledb_ctx_t ctx, tiledb_kv_t kv) {
    return tiledbJNI.tiledb_kv_free(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_kv_t.getCPtr(kv), kv);
  }

  public static int tiledb_kv_add_key(tiledb_ctx_t ctx, tiledb_kv_t kv, SWIGTYPE_p_void key, tiledb_datatype_t key_type, java.math.BigInteger key_size) {
    return tiledbJNI.tiledb_kv_add_key(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_kv_t.getCPtr(kv), kv, SWIGTYPE_p_void.getCPtr(key), key_type.swigValue(), key_size);
  }

  public static int tiledb_kv_add_value(tiledb_ctx_t ctx, tiledb_kv_t kv, long attribute_idx, SWIGTYPE_p_void value) {
    return tiledbJNI.tiledb_kv_add_value(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_kv_t.getCPtr(kv), kv, attribute_idx, SWIGTYPE_p_void.getCPtr(value));
  }

  public static int tiledb_kv_add_value_var(tiledb_ctx_t ctx, tiledb_kv_t kv, long attribute_idx, SWIGTYPE_p_void value, java.math.BigInteger value_size) {
    return tiledbJNI.tiledb_kv_add_value_var(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_kv_t.getCPtr(kv), kv, attribute_idx, SWIGTYPE_p_void.getCPtr(value), value_size);
  }

  public static int tiledb_kv_get_key_num(tiledb_ctx_t ctx, tiledb_kv_t kv, SWIGTYPE_p_unsigned_long_long num) {
    return tiledbJNI.tiledb_kv_get_key_num(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_kv_t.getCPtr(kv), kv, SWIGTYPE_p_unsigned_long_long.getCPtr(num));
  }

  public static int tiledb_kv_get_value_num(tiledb_ctx_t ctx, tiledb_kv_t kv, long attribute_idx, SWIGTYPE_p_unsigned_long_long num) {
    return tiledbJNI.tiledb_kv_get_value_num(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_kv_t.getCPtr(kv), kv, attribute_idx, SWIGTYPE_p_unsigned_long_long.getCPtr(num));
  }

  public static int tiledb_kv_get_key(tiledb_ctx_t ctx, tiledb_kv_t kv, java.math.BigInteger key_idx, SWIGTYPE_p_p_void key, tiledb_datatype_t.pointer key_type, SWIGTYPE_p_unsigned_long_long key_size) {
    return tiledbJNI.tiledb_kv_get_key(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_kv_t.getCPtr(kv), kv, key_idx, SWIGTYPE_p_p_void.getCPtr(key), key_type, SWIGTYPE_p_unsigned_long_long.getCPtr(key_size));
  }

  public static int tiledb_kv_get_value(tiledb_ctx_t ctx, tiledb_kv_t kv, java.math.BigInteger obj_idx, long attr_idx, SWIGTYPE_p_p_void value) {
    return tiledbJNI.tiledb_kv_get_value(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_kv_t.getCPtr(kv), kv, obj_idx, attr_idx, SWIGTYPE_p_p_void.getCPtr(value));
  }

  public static int tiledb_kv_get_value_var(tiledb_ctx_t ctx, tiledb_kv_t kv, java.math.BigInteger obj_idx, long attr_idx, SWIGTYPE_p_p_void value, SWIGTYPE_p_unsigned_long_long value_size) {
    return tiledbJNI.tiledb_kv_get_value_var(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_kv_t.getCPtr(kv), kv, obj_idx, attr_idx, SWIGTYPE_p_p_void.getCPtr(value), SWIGTYPE_p_unsigned_long_long.getCPtr(value_size));
  }

  public static int tiledb_kv_set_buffer_size(tiledb_ctx_t ctx, tiledb_kv_t kv, java.math.BigInteger nbytes) {
    return tiledbJNI.tiledb_kv_set_buffer_size(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_kv_t.getCPtr(kv), kv, nbytes);
  }

  public static int tiledb_vfs_create(tiledb_ctx_t ctx, tiledb_vfs_t vfs, tiledb_config_t config) {
    return tiledbJNI.tiledb_vfs_create(tiledb_ctx_t.getCPtr(ctx), ctx, vfs, tiledb_config_t.getCPtr(config), config);
  }

  public static int tiledb_vfs_free(tiledb_ctx_t ctx, tiledb_vfs_t vfs) {
    return tiledbJNI.tiledb_vfs_free(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_vfs_t.getCPtr(vfs), vfs);
  }

  public static int tiledb_vfs_create_bucket(tiledb_ctx_t ctx, tiledb_vfs_t vfs, String uri) {
    return tiledbJNI.tiledb_vfs_create_bucket(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_vfs_t.getCPtr(vfs), vfs, uri);
  }

  public static int tiledb_vfs_remove_bucket(tiledb_ctx_t ctx, tiledb_vfs_t vfs, String uri) {
    return tiledbJNI.tiledb_vfs_remove_bucket(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_vfs_t.getCPtr(vfs), vfs, uri);
  }

  public static int tiledb_vfs_is_bucket(tiledb_ctx_t ctx, tiledb_vfs_t vfs, String uri, int[] is_bucket) {
    return tiledbJNI.tiledb_vfs_is_bucket(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_vfs_t.getCPtr(vfs), vfs, uri, is_bucket);
  }

  public static int tiledb_vfs_create_dir(tiledb_ctx_t ctx, tiledb_vfs_t vfs, String uri) {
    return tiledbJNI.tiledb_vfs_create_dir(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_vfs_t.getCPtr(vfs), vfs, uri);
  }

  public static int tiledb_vfs_is_dir(tiledb_ctx_t ctx, tiledb_vfs_t vfs, String uri, int[] is_dir) {
    return tiledbJNI.tiledb_vfs_is_dir(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_vfs_t.getCPtr(vfs), vfs, uri, is_dir);
  }

  public static int tiledb_vfs_remove_dir(tiledb_ctx_t ctx, tiledb_vfs_t vfs, String uri) {
    return tiledbJNI.tiledb_vfs_remove_dir(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_vfs_t.getCPtr(vfs), vfs, uri);
  }

  public static int tiledb_vfs_is_file(tiledb_ctx_t ctx, tiledb_vfs_t vfs, String uri, int[] is_file) {
    return tiledbJNI.tiledb_vfs_is_file(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_vfs_t.getCPtr(vfs), vfs, uri, is_file);
  }

  public static int tiledb_vfs_remove_file(tiledb_ctx_t ctx, tiledb_vfs_t vfs, String uri) {
    return tiledbJNI.tiledb_vfs_remove_file(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_vfs_t.getCPtr(vfs), vfs, uri);
  }

  public static int tiledb_vfs_file_size(tiledb_ctx_t ctx, tiledb_vfs_t vfs, String uri, SWIGTYPE_p_unsigned_long_long size) {
    return tiledbJNI.tiledb_vfs_file_size(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_vfs_t.getCPtr(vfs), vfs, uri, SWIGTYPE_p_unsigned_long_long.getCPtr(size));
  }

  public static int tiledb_vfs_move(tiledb_ctx_t ctx, tiledb_vfs_t vfs, String old_uri, String new_uri) {
    return tiledbJNI.tiledb_vfs_move(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_vfs_t.getCPtr(vfs), vfs, old_uri, new_uri);
  }

  public static int tiledb_vfs_read(tiledb_ctx_t ctx, tiledb_vfs_t vfs, String uri, java.math.BigInteger offset, SWIGTYPE_p_void buffer, java.math.BigInteger nbytes) {
    return tiledbJNI.tiledb_vfs_read(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_vfs_t.getCPtr(vfs), vfs, uri, offset, SWIGTYPE_p_void.getCPtr(buffer), nbytes);
  }

  public static int tiledb_vfs_write(tiledb_ctx_t ctx, tiledb_vfs_t vfs, String uri, SWIGTYPE_p_void buffer, java.math.BigInteger nbytes) {
    return tiledbJNI.tiledb_vfs_write(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_vfs_t.getCPtr(vfs), vfs, uri, SWIGTYPE_p_void.getCPtr(buffer), nbytes);
  }

  public static int tiledb_vfs_sync(tiledb_ctx_t ctx, tiledb_vfs_t vfs, String uri) {
    return tiledbJNI.tiledb_vfs_sync(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_vfs_t.getCPtr(vfs), vfs, uri);
  }

  public static int tiledb_vfs_supports_fs(tiledb_ctx_t ctx, tiledb_vfs_t vfs, tiledb_filesystem_t fs, int[] supports) {
    return tiledbJNI.tiledb_vfs_supports_fs(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_vfs_t.getCPtr(vfs), vfs, fs.swigValue(), supports);
  }

  public static int tiledb_vfs_touch(tiledb_ctx_t ctx, tiledb_vfs_t vfs, String uri) {
    return tiledbJNI.tiledb_vfs_touch(tiledb_ctx_t.getCPtr(ctx), ctx, tiledb_vfs_t.getCPtr(vfs), vfs, uri);
  }

  public static int tiledb_uri_to_path(tiledb_ctx_t ctx, String uri, String path_out, SWIGTYPE_p_unsigned_int path_length) {
    return tiledbJNI.tiledb_uri_to_path(tiledb_ctx_t.getCPtr(ctx), ctx, uri, path_out, SWIGTYPE_p_unsigned_int.getCPtr(path_length));
  }

}
