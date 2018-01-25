#include <jni.h>
#include <stdlib.h>
#include <string.h>
#include "tiledb.h"
#include "tiledb_cpp_api_array_schema.h"
#include "tiledb_cpp_api_array.h"
#include "tiledb_cpp_api_attribute.h"
#include "tiledb_cpp_api_compressor.h"
#include "tiledb_cpp_api_config.h"
#include "tiledb_cpp_api_context.h"
#include "tiledb_cpp_api_deleter.h"
#include "tiledb_cpp_api_dimension.h"
#include "tiledb_cpp_api_domain.h"
#include "tiledb_cpp_api_exception.h"
#include "tiledb_cpp_api_group.h"
#include "tiledb_cpp_api_object_iter.h"
#include "tiledb_cpp_api_object.h"
#include "tiledb_cpp_api_query.h"
#include "tiledb_cpp_api_type.h"
#include "tiledb_cpp_api_utils.h"
#include "tiledb_cpp_api_version.h"
#include "tiledb_cpp_api_vfs_filebuf.h"
#include "tiledb_cpp_api_vfs.h"

#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT void JNICALL Java_io_tiledb_custom_tiledbJNI_version(JNIEnv *env, jobject obj, jobject version) {
  // Get version
  int major, minor, rev;
  tiledb_version(&major, &minor, &rev);
  jclass jcls = env->GetObjectClass(version);
  jfieldID majorId = env->GetFieldID(jcls, "major", "I");
  env->SetIntField(version, majorId, major);
  jfieldID minorId = env->GetFieldID(jcls, "minor", "I");
  env->SetIntField(version, minorId, minor);
  jfieldID revId = env->GetFieldID(jcls, "rev", "I");
  env->SetIntField(version, revId, rev);  
}

#ifdef __cplusplus
}
#endif

