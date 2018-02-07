


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


