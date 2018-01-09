#include <jni.h>
#include <stdlib.h>
#include <string.h>

#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT void JNICALL Java_io_tiledb_api_tiledbJNI_testBuffer(JNIEnv *env, jobject obj, jobject buffer) {
  //get pointer to direct buffer array (No copy)
  char *buff = (char*)env->GetDirectBufferAddress(buffer); 
  jlong capacity = (env->GetDirectBufferCapacity(buffer)); 
  
  //print array elements as binary data
//  printf("C Buffer capacity: %lld\n",capacity);
  printf("C byte value: [");
  for(int i=0; i<capacity; i++){
    printf("%02x,",buff[i]);
  }
  printf("]\n");
  
  //print array elements as C integers (wrong values)
  printf("C int value: [");
  int* intbuf = (int*)buff;
  for(int i=0; i<capacity/4; i++){
    printf("%d,",intbuf[i]);
  }
  printf("]\n");
  
  //print array elements as C integers (correct values with byte parsing)
  printf("C correct int value: [");
  for(int i=0; i<capacity; i+=4){
  	int value = buff[i+3] | (buff[i+2]<<8) | (buff[i+1]<<16) | (buff[i]<<24);
    printf("%d,",value);
  }
  printf("]\n");
  //change on element, this is visible to Java
  buff[5]=0x11;
  
  fflush(stdout);
}

JNIEXPORT void JNICALL Java_io_tiledb_api_tiledbJNI_testIntArray(JNIEnv *env, jobject obj, jintArray array) {
  //retrieve input array and print it
  jsize len = env->GetArrayLength(array);
  int i, sum = 0;
  //copies array from Java to C
  int *arr = env->GetIntArrayElements(array, 0);
  printf("C int value: [");
  for(int i=0; i<len; i++){
    printf("%d,",arr[i]);
  }
  printf("]\n");
  fflush(stdout);
  
  //change one element of the array
  arr[5]=42;
  //copies array back to Java
  env->ReleaseIntArrayElements(array, arr, 0);
}

#ifdef __cplusplus
}
#endif

