%module tiledb
%{
#include <string>
#include <vector>
#include "tiledb.h"
#include "tiledb_old.h"
%}


%include "stdint.i"
%include "std_string.i"
%include "std_vector.i"


%include carrays.i
%array_class(int, intArray);
%array_class(int32_t, int32_tArray);
%array_class(int64_t, int64_tArray);
%array_class(char, charArray);
%array_class(float, floatArray);
%array_class(double, doubleArray);
%array_class(int8_t, int8_tArray);
%array_class(uint8_t, uint8_tArray);
%array_class(int16_t, int16_tArray);
%array_class(uint16_t, uint16_tArray);
%array_class(uint32_t, uint32_tArray);
%array_class(uint64_t, uint64_tArray);

%array_functions(char *, charpArray);
%array_functions( void *, voidpArray )

%include "cpointer.i"
%pointer_functions(int, intp);
%pointer_functions(float, floatp);
%pointer_functions(int *, intpp);
%pointer_functions(char *, charpp);
%pointer_functions(unsigned int, uintp);
%pointer_functions(unsigned long long, ullp);
%pointer_functions(tiledb_config_t, tiledb_config_tp);
%pointer_functions(tiledb_config_t *, tiledb_config_tpp);
%pointer_functions(tiledb_config_iter_t, tiledb_config_iter_tp);
%pointer_functions(tiledb_config_iter_t *, tiledb_config_iter_tpp);
%pointer_functions(tiledb_ctx_t, tiledb_ctx_tp);
%pointer_functions(tiledb_ctx_t *, tiledb_ctx_tpp);
%pointer_functions(tiledb_error_t, tiledb_error_tp);
%pointer_functions(tiledb_error_t *, tiledb_error_tpp);
%pointer_functions(tiledb_attribute_t, tiledb_attribute_tp);
%pointer_functions(tiledb_attribute_t *, tiledb_attribute_tpp);
%pointer_functions(tiledb_array_schema_t, tiledb_array_schema_tp);
%pointer_functions(tiledb_array_schema_t *, tiledb_array_schema_tpp);
%pointer_functions(tiledb_dimension_t, tiledb_dimension_tp);
%pointer_functions(tiledb_dimension_t *, tiledb_dimension_tpp);
%pointer_functions(tiledb_domain_t, tiledb_domain_tp);
%pointer_functions(tiledb_domain_t *, tiledb_domain_tpp);
%pointer_functions(tiledb_query_t, tiledb_query_tp);
%pointer_functions(tiledb_query_t *, tiledb_query_tpp);
%pointer_functions(tiledb_kv_schema_t, tiledb_kv_schema_tp);
%pointer_functions(tiledb_kv_schema_t *, tiledb_kv_schema_tpp);
%pointer_functions(tiledb_kv_t, tiledb_kv_tp);
%pointer_functions(tiledb_kv_t *, tiledb_kv_tpp);
%pointer_functions(tiledb_kv_item_t, tiledb_kv_item_tp);
%pointer_functions(tiledb_kv_item_t *, tiledb_kv_item_tpp);
%pointer_functions(tiledb_kv_iter_t, tiledb_kv_iter_tp);
%pointer_functions(tiledb_kv_iter_t *, tiledb_kv_iter_tpp);
%pointer_functions(tiledb_vfs_t, tiledb_vfs_tp);
%pointer_functions(tiledb_vfs_t *, tiledb_vfs_tpp);
%pointer_functions(tiledb_vfs_fh_t, tiledb_vfs_fh_tp);
%pointer_functions(tiledb_vfs_fh_t *, tiledb_vfs_fh_tpp);


%pointer_functions(tiledb_object_t, tiledb_object_tp);
%pointer_functions(tiledb_query_type_t, tiledb_query_type_tp);
%pointer_functions(tiledb_query_status_t, tiledb_query_status_tp);
%pointer_functions(tiledb_filesystem_t, tiledb_filesystem_tp);
%pointer_functions(tiledb_datatype_t, tiledb_datatype_tp);
%pointer_functions(tiledb_array_type_t, tiledb_array_type_tp);
%pointer_functions(tiledb_layout_t, tiledb_layout_tp);
%pointer_functions(tiledb_compressor_t, tiledb_compressor_tp);
%pointer_functions(tiledb_walk_order_t, tiledb_walk_order_tp);
%pointer_functions(tiledb_vfs_mode_t, tiledb_vfs_mode_tp);

#%pointer_functions(void, void_tp);

%include "typemaps.i"
%include "enums.swg"
%javaconst(1);
    

%include "tiledb_old.h"
%include "tiledb.h"




