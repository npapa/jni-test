%module tiledb
%{
#include <string>
#include <vector>
#include "tiledb.h"
%}


%include "stdint.i"
%include "std_string.i"
%include "std_vector.i"
%include "cpointer.i"
%include "typemaps.i"
%include "enums.swg"
%javaconst(1);


%nodefaultctor tiledb_array_schema_t;
%nodefaultdtor tiledb_array_schema_t;
%nodefaultctor tiledb_attribute_t;
%nodefaultdtor tiledb_attribute_t;
%nodefaultctor tiledb_config_t;
%nodefaultdtor tiledb_config_t;
%nodefaultctor tiledb_ctx_t;
%nodefaultdtor tiledb_ctx_t;
%nodefaultctor tiledb_dimension_t;
%nodefaultdtor tiledb_dimension_t;
%nodefaultctor tiledb_domain_t;
%nodefaultdtor tiledb_domain_t;
%nodefaultctor tiledb_error_t;
%nodefaultdtor tiledb_error_t;
%nodefaultctor tiledb_kv_t;
%nodefaultdtor tiledb_kv_t;
%nodefaultctor tiledb_query_t;
%nodefaultdtor tiledb_query_t;
%nodefaultctor tiledb_vfs_t;
%nodefaultdtor tiledb_vfs_t;

%typemap(javacode) tiledb_array_schema_t %{
  /** This constructor creates the proxy which initially does not create nor own any C memory */
  public tiledb_array_schema_t() {
    this(0, false);
  }
%}
%typemap(javacode) tiledb_attribute_t %{
  /** This constructor creates the proxy which initially does not create nor own any C memory */
  public tiledb_attribute_t() {
    this(0, false);
  }
%}
%typemap(javacode) tiledb_config_t %{
  /** This constructor creates the proxy which initially does not create nor own any C memory */
  public tiledb_config_t() {
    this(0, false);
  }
%}
%typemap(javacode) tiledb_ctx_t %{
  /** This constructor creates the proxy which initially does not create nor own any C memory */
  public tiledb_ctx_t() {
    this(0, false);
  }
%}
%typemap(javacode) tiledb_dimension_t %{
  /** This constructor creates the proxy which initially does not create nor own any C memory */
  public tiledb_dimension_t() {
    this(0, false);
  }
%}
%typemap(javacode) tiledb_domain_t %{
  /** This constructor creates the proxy which initially does not create nor own any C memory */
  public tiledb_domain_t() {
    this(0, false);
  }
%}
%typemap(javacode) tiledb_error_t %{
  /** This constructor creates the proxy which initially does not create nor own any C memory */
  public tiledb_error_t() {
    this(0, false);
  }
%}
%typemap(javacode) tiledb_kv_t %{
  /** This constructor creates the proxy which initially does not create nor own any C memory */
  public tiledb_kv_t() {
    this(0, false);
  }
%}
%typemap(javacode) tiledb_query_t %{
  /** This constructor creates the proxy which initially does not create nor own any C memory */
  public tiledb_query_t() {
    this(0, false);
  }
%}
%typemap(javacode) tiledb_vfs_t %{
  /** This constructor creates the proxy which initially does not create nor own any C memory */
  public tiledb_vfs_t() {
    this(0, false);
  }
%}


// Type typemaps for marshalling **
%typemap(jni) tiledb_array_schema_t ** "jobject"
%typemap(jtype) tiledb_array_schema_t ** "tiledb_array_schema_t"
%typemap(jstype) tiledb_array_schema_t ** "tiledb_array_schema_t"
%typemap(jni) tiledb_attribute_t ** "jobject"
%typemap(jtype) tiledb_attribute_t ** "tiledb_attribute_t"
%typemap(jstype) tiledb_attribute_t ** "tiledb_attribute_t"
%typemap(jni) tiledb_config_t ** "jobject"
%typemap(jtype) tiledb_config_t ** "tiledb_config_t"
%typemap(jstype) tiledb_config_t ** "tiledb_config_t"
%typemap(jni) tiledb_ctx_t ** "jobject"
%typemap(jtype) tiledb_ctx_t ** "tiledb_ctx_t"
%typemap(jstype) tiledb_ctx_t ** "tiledb_ctx_t"
%typemap(jni) tiledb_dimension_t ** "jobject"
%typemap(jtype) tiledb_dimension_t ** "tiledb_dimension_t"
%typemap(jstype) tiledb_dimension_t ** "tiledb_dimension_t"
%typemap(jni) tiledb_domain_t ** "jobject"
%typemap(jtype) tiledb_domain_t ** "tiledb_domain_t"
%typemap(jstype) tiledb_domain_t ** "tiledb_domain_t"
%typemap(jni) tiledb_error_t ** "jobject"
%typemap(jtype) tiledb_error_t ** "tiledb_error_t"
%typemap(jstype) tiledb_error_t ** "tiledb_error_t"
%typemap(jni) tiledb_kv_t ** "jobject"
%typemap(jtype) tiledb_kv_t ** "tiledb_kv_t"
%typemap(jstype) tiledb_kv_t ** "tiledb_kv_t"
%typemap(jni) tiledb_query_t ** "jobject"
%typemap(jtype) tiledb_query_t ** "tiledb_query_t"
%typemap(jstype) tiledb_query_t ** "tiledb_query_t"
%typemap(jni) tiledb_vfs_t ** "jobject"
%typemap(jtype) tiledb_vfs_t ** "tiledb_vfs_t"
%typemap(jstype) tiledb_vfs_t ** "tiledb_vfs_t"


// Typemaps for ** as a parameter output type
%typemap(in) tiledb_array_schema_t ** (tiledb_array_schema_t *pp = 0) %{
  $1 = &pp;
%}
%typemap(argout) tiledb_array_schema_t ** {
  // Give Java proxy the C pointer (of newly created object)
  jclass cls = jenv->GetObjectClass($input);
  jfieldID fid = jenv->GetFieldID(cls, "swigCPtr", "J");
  jlong cPtr = 0;
  *(tiledb_array_schema_t **)&cPtr = *$1;
  jenv->SetLongField($input, fid, cPtr);
}
%typemap(javain) tiledb_array_schema_t ** "$javainput"

%typemap(in) tiledb_attribute_t ** (tiledb_attribute_t *pp = 0) %{
  $1 = &pp;
%}
%typemap(argout) tiledb_attribute_t ** {
  // Give Java proxy the C pointer (of newly created object)
  jclass cls = jenv->GetObjectClass($input);
  jfieldID fid = jenv->GetFieldID(cls, "swigCPtr", "J");
  jlong cPtr = 0;
  *(tiledb_attribute_t **)&cPtr = *$1;
  jenv->SetLongField($input, fid, cPtr);
}
%typemap(javain) tiledb_attribute_t ** "$javainput"

%typemap(in) tiledb_config_t ** (tiledb_config_t *pp = 0) %{
  $1 = &pp;
%}
%typemap(argout) tiledb_config_t ** {
  // Give Java proxy the C pointer (of newly created object)
  jclass cls = jenv->GetObjectClass($input);
  jfieldID fid = jenv->GetFieldID(cls, "swigCPtr", "J");
  jlong cPtr = 0;
  *(tiledb_config_t **)&cPtr = *$1;
  jenv->SetLongField($input, fid, cPtr);
}
%typemap(javain) tiledb_config_t ** "$javainput"

%typemap(in) tiledb_ctx_t ** (tiledb_ctx_t *pp = 0) %{
  $1 = &pp;
%}
%typemap(argout) tiledb_ctx_t ** {
  // Give Java proxy the C pointer (of newly created object)
  jclass cls = jenv->GetObjectClass($input);
  jfieldID fid = jenv->GetFieldID(cls, "swigCPtr", "J");
  jlong cPtr = 0;
  *(tiledb_ctx_t **)&cPtr = *$1;
  jenv->SetLongField($input, fid, cPtr);
}
%typemap(javain) tiledb_ctx_t ** "$javainput"

%typemap(in) tiledb_dimension_t ** (tiledb_dimension_t *pp = 0) %{
  $1 = &pp;
%}
%typemap(argout) tiledb_dimension_t ** {
  // Give Java proxy the C pointer (of newly created object)
  jclass cls = jenv->GetObjectClass($input);
  jfieldID fid = jenv->GetFieldID(cls, "swigCPtr", "J");
  jlong cPtr = 0;
  *(tiledb_dimension_t **)&cPtr = *$1;
  jenv->SetLongField($input, fid, cPtr);
}
%typemap(javain) tiledb_dimension_t ** "$javainput"

%typemap(in) tiledb_domain_t ** (tiledb_domain_t *pp = 0) %{
  $1 = &pp;
%}
%typemap(argout) tiledb_domain_t ** {
  // Give Java proxy the C pointer (of newly created object)
  jclass cls = jenv->GetObjectClass($input);
  jfieldID fid = jenv->GetFieldID(cls, "swigCPtr", "J");
  jlong cPtr = 0;
  *(tiledb_domain_t **)&cPtr = *$1;
  jenv->SetLongField($input, fid, cPtr);
}
%typemap(javain) tiledb_domain_t ** "$javainput"

%typemap(in) tiledb_error_t ** (tiledb_error_t *pp = 0) %{
  $1 = &pp;
%}
%typemap(argout) tiledb_error_t ** {
  // Give Java proxy the C pointer (of newly created object)
  jclass cls = jenv->GetObjectClass($input);
  jfieldID fid = jenv->GetFieldID(cls, "swigCPtr", "J");
  jlong cPtr = 0;
  *(tiledb_error_t **)&cPtr = *$1;
  jenv->SetLongField($input, fid, cPtr);
}
%typemap(javain) tiledb_error_t ** "$javainput"

%typemap(in) tiledb_kv_t ** (tiledb_kv_t *pp = 0) %{
  $1 = &pp;
%}
%typemap(argout) tiledb_kv_t ** {
  // Give Java proxy the C pointer (of newly created object)
  jclass cls = jenv->GetObjectClass($input);
  jfieldID fid = jenv->GetFieldID(cls, "swigCPtr", "J");
  jlong cPtr = 0;
  *(tiledb_kv_t **)&cPtr = *$1;
  jenv->SetLongField($input, fid, cPtr);
}
%typemap(javain) tiledb_kv_t ** "$javainput"

%typemap(in) tiledb_query_t ** (tiledb_query_t *pp = 0) %{
  $1 = &pp;
%}
%typemap(argout) tiledb_query_t ** {
  // Give Java proxy the C pointer (of newly created object)
  jclass cls = jenv->GetObjectClass($input);
  jfieldID fid = jenv->GetFieldID(cls, "swigCPtr", "J");
  jlong cPtr = 0;
  *(tiledb_query_t **)&cPtr = *$1;
  jenv->SetLongField($input, fid, cPtr);
}
%typemap(javain) tiledb_query_t ** "$javainput"

%typemap(in) tiledb_vfs_t ** (tiledb_vfs_t *pp = 0) %{
  $1 = &pp;
%}
%typemap(argout) tiledb_vfs_t ** {
  // Give Java proxy the C pointer (of newly created object)
  jclass cls = jenv->GetObjectClass($input);
  jfieldID fid = jenv->GetFieldID(cls, "swigCPtr", "J");
  jlong cPtr = 0;
  *(tiledb_vfs_t **)&cPtr = *$1;
  jenv->SetLongField($input, fid, cPtr);
}
%typemap(javain) tiledb_vfs_t ** "$javainput"




%typemap(javacode) tiledb_array_type_t %{
  public static class pointer{
	  tiledb_array_type_t tiledb_array_type_t;
	  public pointer(){
		  tiledb_array_type_t=null;
	  }
	  public tiledb_array_type_t get() {
		return tiledb_array_type_t;
	  }
	  public void set(tiledb_array_type_t tiledb_array_type_t) {
		this.tiledb_array_type_t = tiledb_array_type_t;
	  }
  }
%}
%typemap(jni) tiledb_array_type_t * "jobject"
%typemap(jtype) tiledb_array_type_t * "tiledb_array_type_t.pointer"
%typemap(jstype) tiledb_array_type_t * "tiledb_array_type_t.pointer"
%typemap(in) tiledb_array_type_t * (tiledb_array_type_t pp) %{
  $1 = &pp;
%}
%typemap(argout) tiledb_array_type_t * {
    jclass cls = jenv->FindClass("io/tiledb/api/tiledb_array_type_t");
    jmethodID mid = jenv->GetStaticMethodID(cls, "swigToEnum", "(I)Lio/tiledb/api/tiledb_array_type_t;");
    jobject newObj = jenv->CallStaticObjectMethod(cls, mid, (jint)*$1);
    cls = jenv->GetObjectClass($input);
    mid = jenv->GetMethodID(cls, "set", "(Lio/tiledb/api/tiledb_array_type_t;)V");
    jenv->CallVoidMethod($input, mid, newObj);
}
%typemap(javain) tiledb_array_type_t * "$javainput"

%typemap(javacode) tiledb_compressor_t %{
  public static class pointer{
	  tiledb_compressor_t tiledb_compressor_t;
	  public pointer(){
		  tiledb_compressor_t=null;
	  }
	  public tiledb_compressor_t get() {
		return tiledb_compressor_t;
	  }
	  public void set(tiledb_compressor_t tiledb_compressor_t) {
		this.tiledb_compressor_t = tiledb_compressor_t;
	  }
  }
%}
%typemap(jni) tiledb_compressor_t * "jobject"
%typemap(jtype) tiledb_compressor_t * "tiledb_compressor_t.pointer"
%typemap(jstype) tiledb_compressor_t * "tiledb_compressor_t.pointer"
%typemap(in) tiledb_compressor_t * (tiledb_compressor_t pp) %{
  $1 = &pp;
%}
%typemap(argout) tiledb_compressor_t * {
    jclass cls = jenv->FindClass("io/tiledb/api/tiledb_compressor_t");
    jmethodID mid = jenv->GetStaticMethodID(cls, "swigToEnum", "(I)Lio/tiledb/api/tiledb_compressor_t;");
    jobject newObj = jenv->CallStaticObjectMethod(cls, mid, (jint)*$1);
    cls = jenv->GetObjectClass($input);
    mid = jenv->GetMethodID(cls, "set", "(Lio/tiledb/api/tiledb_compressor_t;)V");
    jenv->CallVoidMethod($input, mid, newObj);
}
%typemap(javain) tiledb_compressor_t * "$javainput"

%typemap(javacode) tiledb_datatype_t %{
  public static class pointer{
	  tiledb_datatype_t tiledb_datatype_t;
	  public pointer(){
		  tiledb_datatype_t=null;
	  }
	  public tiledb_datatype_t get() {
		return tiledb_datatype_t;
	  }
	  public void set(tiledb_datatype_t tiledb_datatype_t) {
		this.tiledb_datatype_t = tiledb_datatype_t;
	  }
  }
%}
%typemap(jni) tiledb_datatype_t * "jobject"
%typemap(jtype) tiledb_datatype_t * "tiledb_datatype_t.pointer"
%typemap(jstype) tiledb_datatype_t * "tiledb_datatype_t.pointer"
%typemap(in) tiledb_datatype_t * (tiledb_datatype_t pp) %{
  $1 = &pp;
%}
%typemap(argout) tiledb_datatype_t * {
    jclass cls = jenv->FindClass("io/tiledb/api/tiledb_datatype_t");
    jmethodID mid = jenv->GetStaticMethodID(cls, "swigToEnum", "(I)Lio/tiledb/api/tiledb_datatype_t;");
    jobject newObj = jenv->CallStaticObjectMethod(cls, mid, (jint)*$1);
    cls = jenv->GetObjectClass($input);
    mid = jenv->GetMethodID(cls, "set", "(Lio/tiledb/api/tiledb_datatype_t;)V");
    jenv->CallVoidMethod($input, mid, newObj);
}
%typemap(javain) tiledb_datatype_t * "$javainput"

%typemap(javacode) tiledb_filesystem_t %{
  public static class pointer{
	  tiledb_filesystem_t tiledb_filesystem_t;
	  public pointer(){
		  tiledb_filesystem_t=null;
	  }
	  public tiledb_filesystem_t get() {
		return tiledb_filesystem_t;
	  }
	  public void set(tiledb_filesystem_t tiledb_filesystem_t) {
		this.tiledb_filesystem_t = tiledb_filesystem_t;
	  }
  }
%}
%typemap(jni) tiledb_filesystem_t * "jobject"
%typemap(jtype) tiledb_filesystem_t * "tiledb_filesystem_t.pointer"
%typemap(jstype) tiledb_filesystem_t * "tiledb_filesystem_t.pointer"
%typemap(in) tiledb_filesystem_t * (tiledb_filesystem_t pp) %{
  $1 = &pp;
%}
%typemap(argout) tiledb_filesystem_t * {
    jclass cls = jenv->FindClass("io/tiledb/api/tiledb_filesystem_t");
    jmethodID mid = jenv->GetStaticMethodID(cls, "swigToEnum", "(I)Lio/tiledb/api/tiledb_filesystem_t;");
    jobject newObj = jenv->CallStaticObjectMethod(cls, mid, (jint)*$1);
    cls = jenv->GetObjectClass($input);
    mid = jenv->GetMethodID(cls, "set", "(Lio/tiledb/api/tiledb_filesystem_t;)V");
    jenv->CallVoidMethod($input, mid, newObj);
}
%typemap(javain) tiledb_filesystem_t * "$javainput"

%typemap(javacode) tiledb_layout_t %{
  public static class pointer{
	  tiledb_layout_t tiledb_layout_t;
	  public pointer(){
		  tiledb_layout_t=null;
	  }
	  public tiledb_layout_t get() {
		return tiledb_layout_t;
	  }
	  public void set(tiledb_layout_t tiledb_layout_t) {
		this.tiledb_layout_t = tiledb_layout_t;
	  }
  }
%}
%typemap(jni) tiledb_layout_t * "jobject"
%typemap(jtype) tiledb_layout_t * "tiledb_layout_t.pointer"
%typemap(jstype) tiledb_layout_t * "tiledb_layout_t.pointer"
%typemap(in) tiledb_layout_t * (tiledb_layout_t pp) %{
  $1 = &pp;
%}
%typemap(argout) tiledb_layout_t * {
    jclass cls = jenv->FindClass("io/tiledb/api/tiledb_layout_t");
    jmethodID mid = jenv->GetStaticMethodID(cls, "swigToEnum", "(I)Lio/tiledb/api/tiledb_layout_t;");
    jobject newObj = jenv->CallStaticObjectMethod(cls, mid, (jint)*$1);
    cls = jenv->GetObjectClass($input);
    mid = jenv->GetMethodID(cls, "set", "(Lio/tiledb/api/tiledb_layout_t;)V");
    jenv->CallVoidMethod($input, mid, newObj);
}
%typemap(javain) tiledb_layout_t * "$javainput"

%typemap(javacode) tiledb_object_t %{
  public static class pointer{
	  tiledb_object_t tiledb_object_t;
	  public pointer(){
		  tiledb_object_t=null;
	  }
	  public tiledb_object_t get() {
		return tiledb_object_t;
	  }
	  public void set(tiledb_object_t tiledb_object_t) {
		this.tiledb_object_t = tiledb_object_t;
	  }
  }
%}
%typemap(jni) tiledb_object_t * "jobject"
%typemap(jtype) tiledb_object_t * "tiledb_object_t.pointer"
%typemap(jstype) tiledb_object_t * "tiledb_object_t.pointer"
%typemap(in) tiledb_object_t * (tiledb_object_t pp) %{
  $1 = &pp;
%}
%typemap(argout) tiledb_object_t * {
    jclass cls = jenv->FindClass("io/tiledb/api/tiledb_object_t");
    jmethodID mid = jenv->GetStaticMethodID(cls, "swigToEnum", "(I)Lio/tiledb/api/tiledb_object_t;");
    jobject newObj = jenv->CallStaticObjectMethod(cls, mid, (jint)*$1);
    cls = jenv->GetObjectClass($input);
    mid = jenv->GetMethodID(cls, "set", "(Lio/tiledb/api/tiledb_object_t;)V");
    jenv->CallVoidMethod($input, mid, newObj);
}
%typemap(javain) tiledb_object_t * "$javainput"

%typemap(javacode) tiledb_query_status_t %{
  public static class pointer{
	  tiledb_query_status_t tiledb_query_status_t;
	  public pointer(){
		  tiledb_query_status_t=null;
	  }
	  public tiledb_query_status_t get() {
		return tiledb_query_status_t;
	  }
	  public void set(tiledb_query_status_t tiledb_query_status_t) {
		this.tiledb_query_status_t = tiledb_query_status_t;
	  }
  }
%}
%typemap(jni) tiledb_query_status_t * "jobject"
%typemap(jtype) tiledb_query_status_t * "tiledb_query_status_t.pointer"
%typemap(jstype) tiledb_query_status_t * "tiledb_query_status_t.pointer"
%typemap(in) tiledb_query_status_t * (tiledb_query_status_t pp) %{
  $1 = &pp;
%}
%typemap(argout) tiledb_query_status_t * {
    jclass cls = jenv->FindClass("io/tiledb/api/tiledb_query_status_t");
    jmethodID mid = jenv->GetStaticMethodID(cls, "swigToEnum", "(I)Lio/tiledb/api/tiledb_query_status_t;");
    jobject newObj = jenv->CallStaticObjectMethod(cls, mid, (jint)*$1);
    cls = jenv->GetObjectClass($input);
    mid = jenv->GetMethodID(cls, "set", "(Lio/tiledb/api/tiledb_query_status_t;)V");
    jenv->CallVoidMethod($input, mid, newObj);
}
%typemap(javain) tiledb_query_status_t * "$javainput"

%typemap(javacode) tiledb_query_type_t %{
  public static class pointer{
	  tiledb_query_type_t tiledb_query_type_t;
	  public pointer(){
		  tiledb_query_type_t=null;
	  }
	  public tiledb_query_type_t get() {
		return tiledb_query_type_t;
	  }
	  public void set(tiledb_query_type_t tiledb_query_type_t) {
		this.tiledb_query_type_t = tiledb_query_type_t;
	  }
  }
%}
%typemap(jni) tiledb_query_type_t * "jobject"
%typemap(jtype) tiledb_query_type_t * "tiledb_query_type_t.pointer"
%typemap(jstype) tiledb_query_type_t * "tiledb_query_type_t.pointer"
%typemap(in) tiledb_query_type_t * (tiledb_query_type_t pp) %{
  $1 = &pp;
%}
%typemap(argout) tiledb_query_type_t * {
    jclass cls = jenv->FindClass("io/tiledb/api/tiledb_query_type_t");
    jmethodID mid = jenv->GetStaticMethodID(cls, "swigToEnum", "(I)Lio/tiledb/api/tiledb_query_type_t;");
    jobject newObj = jenv->CallStaticObjectMethod(cls, mid, (jint)*$1);
    cls = jenv->GetObjectClass($input);
    mid = jenv->GetMethodID(cls, "set", "(Lio/tiledb/api/tiledb_query_type_t;)V");
    jenv->CallVoidMethod($input, mid, newObj);
}
%typemap(javain) tiledb_query_type_t * "$javainput"

%typemap(javacode) tiledb_walk_order_t %{
  public static class pointer{
	  tiledb_walk_order_t tiledb_walk_order_t;
	  public pointer(){
		  tiledb_walk_order_t=null;
	  }
	  public tiledb_walk_order_t get() {
		return tiledb_walk_order_t;
	  }
	  public void set(tiledb_walk_order_t tiledb_walk_order_t) {
		this.tiledb_walk_order_t = tiledb_walk_order_t;
	  }
  }
%}
%typemap(jni) tiledb_walk_order_t * "jobject"
%typemap(jtype) tiledb_walk_order_t * "tiledb_walk_order_t.pointer"
%typemap(jstype) tiledb_walk_order_t * "tiledb_walk_order_t.pointer"
%typemap(in) tiledb_walk_order_t * (tiledb_walk_order_t pp) %{
  $1 = &pp;
%}
%typemap(argout) tiledb_walk_order_t * {
    jclass cls = jenv->FindClass("io/tiledb/api/tiledb_walk_order_t");
    jmethodID mid = jenv->GetStaticMethodID(cls, "swigToEnum", "(I)Lio/tiledb/api/tiledb_walk_order_t;");
    jobject newObj = jenv->CallStaticObjectMethod(cls, mid, (jint)*$1);
    cls = jenv->GetObjectClass($input);
    mid = jenv->GetMethodID(cls, "set", "(Lio/tiledb/api/tiledb_walk_order_t;)V");
    jenv->CallVoidMethod($input, mid, newObj);
}
%typemap(javain) tiledb_walk_order_t * "$javainput"


#%pass single pointers - input values 
%typemap(jni) int* "jintArray"
%typemap(jtype) int* "int[]"
%typemap(jstype) int* "int[]"
%typemap(in) int * (jsize len) %{
  len = jenv->GetArrayLength($input);
  //copies array from Java to C
  $1 = jenv->GetIntArrayElements($input, 0);
%}
%typemap(argout) int * {
  jenv->ReleaseIntArrayElements($input, $1, 0);
}
%typemap(javain) int * "$javainput"


#%pass double pointers - output values
%typemap(jni) char ** "jobjectArray"
%typemap(jtype) char ** "String[]"
%typemap(jstype) char ** "String[]"
%typemap(javain) char ** "$javainput"
%typemap(in) char ** (char * ret) %{
  $1 = &ret;
%}
%typemap(argout) char ** {
  jstring str = jenv->NewStringUTF(*$1); 
  jenv->SetObjectArrayElement($input,0, str);
}

%typemap(jni) int** "jintArray"
%typemap(jtype) int** "int[]"
%typemap(jstype) int** "int[]"
%typemap(in) int** (int * ret) %{
  $1 = &ret;
%}
%typemap(argout) int** {
  //$input = jenv->NewIntArray(2);
  //jenv->SetIntArrayRegion($input, 0 , 2, *$1);
  jenv->ReleaseIntArrayElements($input, *$1, 0);
}
%typemap(javain) int** "$javainput"

int tiledb_dimension_create(
    tiledb_ctx_t* ctx,
    tiledb_dimension_t** dim,
    const char* name,
    tiledb_datatype_t type,
    int* dim_domain,
    int* tile_extent);
    

%include "tiledb.h"



#%include "tiledb_cpp_api_config.h"
#%include "tiledb_cpp_api_context.h"
#%include "tiledb_cpp_api_domain.h"
#%include "tiledb_cpp_api_dimension.h"


#%include "tiledb_cpp_api_array_schema.h"
#%include "tiledb_cpp_api_array.h"
#%include "tiledb_cpp_api_attribute.h"
#%include "tiledb_cpp_api_compressor.h"
#%include "tiledb_cpp_api_deleter.h"
#%include "tiledb_cpp_api_dimension.h"
#%include "tiledb_cpp_api_exception.h"
#%include "tiledb_cpp_api_group.h"
#%include "tiledb_cpp_api_object_iter.h"
#%include "tiledb_cpp_api_object.h"
#%include "tiledb_cpp_api_query.h"
#%include "tiledb_cpp_api_type.h"
#%include "tiledb_cpp_api_utils.h"
#%include "tiledb_cpp_api_vfs_filebuf.h"
#%include "tiledb_cpp_api_vfs.h"



