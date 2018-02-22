
#ifndef SWIGJAVA
#define SWIGJAVA
#endif



#ifdef __cplusplus
/* SwigValueWrapper is described in swig.swg */
template<typename T> class SwigValueWrapper {
  struct SwigMovePointer {
    T *ptr;
    SwigMovePointer(T *p) : ptr(p) { }
    ~SwigMovePointer() { delete ptr; }
    SwigMovePointer& operator=(SwigMovePointer& rhs) { T* oldptr = ptr; ptr = 0; delete oldptr; ptr = rhs.ptr; rhs.ptr = 0; return *this; }
  } pointer;
  SwigValueWrapper& operator=(const SwigValueWrapper<T>& rhs);
  SwigValueWrapper(const SwigValueWrapper<T>& rhs);
public:
  SwigValueWrapper() : pointer(0) { }
  SwigValueWrapper& operator=(const T& t) { SwigMovePointer tmp(new T(t)); pointer = tmp; return *this; }
  operator T&() const { return *pointer.ptr; }
  T *operator&() { return pointer.ptr; }
};

template <typename T> T SwigValueInit() {
  return T();
}
#endif

/* -----------------------------------------------------------------------------
 *  This section contains generic SWIG labels for method/variable
 *  declarations/attributes, and other compiler dependent labels.
 * ----------------------------------------------------------------------------- */

/* template workaround for compilers that cannot correctly implement the C++ standard */
#ifndef SWIGTEMPLATEDISAMBIGUATOR
# if defined(__SUNPRO_CC) && (__SUNPRO_CC <= 0x560)
#  define SWIGTEMPLATEDISAMBIGUATOR template
# elif defined(__HP_aCC)
/* Needed even with `aCC -AA' when `aCC -V' reports HP ANSI C++ B3910B A.03.55 */
/* If we find a maximum version that requires this, the test would be __HP_aCC <= 35500 for A.03.55 */
#  define SWIGTEMPLATEDISAMBIGUATOR template
# else
#  define SWIGTEMPLATEDISAMBIGUATOR
# endif
#endif

/* inline attribute */
#ifndef SWIGINLINE
# if defined(__cplusplus) || (defined(__GNUC__) && !defined(__STRICT_ANSI__))
#   define SWIGINLINE inline
# else
#   define SWIGINLINE
# endif
#endif

/* attribute recognised by some compilers to avoid 'unused' warnings */
#ifndef SWIGUNUSED
# if defined(__GNUC__)
#   if !(defined(__cplusplus)) || (__GNUC__ > 3 || (__GNUC__ == 3 && __GNUC_MINOR__ >= 4))
#     define SWIGUNUSED __attribute__ ((__unused__))
#   else
#     define SWIGUNUSED
#   endif
# elif defined(__ICC)
#   define SWIGUNUSED __attribute__ ((__unused__))
# else
#   define SWIGUNUSED
# endif
#endif

#ifndef SWIG_MSC_UNSUPPRESS_4505
# if defined(_MSC_VER)
#   pragma warning(disable : 4505) /* unreferenced local function has been removed */
# endif
#endif

#ifndef SWIGUNUSEDPARM
# ifdef __cplusplus
#   define SWIGUNUSEDPARM(p)
# else
#   define SWIGUNUSEDPARM(p) p SWIGUNUSED
# endif
#endif

/* internal SWIG method */
#ifndef SWIGINTERN
# define SWIGINTERN static SWIGUNUSED
#endif

/* internal inline SWIG method */
#ifndef SWIGINTERNINLINE
# define SWIGINTERNINLINE SWIGINTERN SWIGINLINE
#endif

/* exporting methods */
#if defined(__GNUC__)
#  if (__GNUC__ >= 4) || (__GNUC__ == 3 && __GNUC_MINOR__ >= 4)
#    ifndef GCC_HASCLASSVISIBILITY
#      define GCC_HASCLASSVISIBILITY
#    endif
#  endif
#endif

#ifndef SWIGEXPORT
# if defined(_WIN32) || defined(__WIN32__) || defined(__CYGWIN__)
#   if defined(STATIC_LINKED)
#     define SWIGEXPORT
#   else
#     define SWIGEXPORT __declspec(dllexport)
#   endif
# else
#   if defined(__GNUC__) && defined(GCC_HASCLASSVISIBILITY)
#     define SWIGEXPORT __attribute__ ((visibility("default")))
#   else
#     define SWIGEXPORT
#   endif
# endif
#endif

/* calling conventions for Windows */
#ifndef SWIGSTDCALL
# if defined(_WIN32) || defined(__WIN32__) || defined(__CYGWIN__)
#   define SWIGSTDCALL __stdcall
# else
#   define SWIGSTDCALL
# endif
#endif

/* Deal with Microsoft's attempt at deprecating C standard runtime functions */
#if !defined(SWIG_NO_CRT_SECURE_NO_DEPRECATE) && defined(_MSC_VER) && !defined(_CRT_SECURE_NO_DEPRECATE)
# define _CRT_SECURE_NO_DEPRECATE
#endif

/* Deal with Microsoft's attempt at deprecating methods in the standard C++ library */
#if !defined(SWIG_NO_SCL_SECURE_NO_DEPRECATE) && defined(_MSC_VER) && !defined(_SCL_SECURE_NO_DEPRECATE)
# define _SCL_SECURE_NO_DEPRECATE
#endif

/* Deal with Apple's deprecated 'AssertMacros.h' from Carbon-framework */
#if defined(__APPLE__) && !defined(__ASSERT_MACROS_DEFINE_VERSIONS_WITHOUT_UNDERSCORES)
# define __ASSERT_MACROS_DEFINE_VERSIONS_WITHOUT_UNDERSCORES 0
#endif

/* Intel's compiler complains if a variable which was never initialised is
 * cast to void, which is a common idiom which we use to indicate that we
 * are aware a variable isn't used.  So we just silence that warning.
 * See: https://github.com/swig/swig/issues/192 for more discussion.
 */
#ifdef __INTEL_COMPILER
# pragma warning disable 592
#endif


/* Fix for jlong on some versions of gcc on Windows */
#if defined(__GNUC__) && !defined(__INTEL_COMPILER)
  typedef long long __int64;
#endif

/* Fix for jlong on 64-bit x86 Solaris */
#if defined(__x86_64)
# ifdef _LP64
#   undef _LP64
# endif
#endif

#include <jni.h>
#include <stdlib.h>
#include <string.h>


/* Support for throwing Java exceptions */
typedef enum {
  SWIG_JavaOutOfMemoryError = 1, 
  SWIG_JavaIOException, 
  SWIG_JavaRuntimeException, 
  SWIG_JavaIndexOutOfBoundsException,
  SWIG_JavaArithmeticException,
  SWIG_JavaIllegalArgumentException,
  SWIG_JavaNullPointerException,
  SWIG_JavaDirectorPureVirtual,
  SWIG_JavaUnknownError
} SWIG_JavaExceptionCodes;

typedef struct {
  SWIG_JavaExceptionCodes code;
  const char *java_exception;
} SWIG_JavaExceptions_t;


static void SWIGUNUSED SWIG_JavaThrowException(JNIEnv *jenv, SWIG_JavaExceptionCodes code, const char *msg) {
  jclass excep;
  static const SWIG_JavaExceptions_t java_exceptions[] = {
    { SWIG_JavaOutOfMemoryError, "java/lang/OutOfMemoryError" },
    { SWIG_JavaIOException, "java/io/IOException" },
    { SWIG_JavaRuntimeException, "java/lang/RuntimeException" },
    { SWIG_JavaIndexOutOfBoundsException, "java/lang/IndexOutOfBoundsException" },
    { SWIG_JavaArithmeticException, "java/lang/ArithmeticException" },
    { SWIG_JavaIllegalArgumentException, "java/lang/IllegalArgumentException" },
    { SWIG_JavaNullPointerException, "java/lang/NullPointerException" },
    { SWIG_JavaDirectorPureVirtual, "java/lang/RuntimeException" },
    { SWIG_JavaUnknownError,  "java/lang/UnknownError" },
    { (SWIG_JavaExceptionCodes)0,  "java/lang/UnknownError" }
  };
  const SWIG_JavaExceptions_t *except_ptr = java_exceptions;

  while (except_ptr->code != code && except_ptr->code)
    except_ptr++;

  jenv->ExceptionClear();
  excep = jenv->FindClass(except_ptr->java_exception);
  if (excep)
    jenv->ThrowNew(excep, msg);
}


/* Contract support */

#define SWIG_contract_assert(nullreturn, expr, msg) if (!(expr)) {SWIG_JavaThrowException(jenv, SWIG_JavaIllegalArgumentException, msg); return nullreturn; } else


#include <stdio.h>
#include <typeinfo>

typedef int intArray;


#if defined(SWIG_NOINCLUDE) || defined(SWIG_NOARRAYS)


static int SWIG_JavaArrayInBool (JNIEnv *jenv, jboolean **jarr, bool **carr, jbooleanArray input);
static void SWIG_JavaArrayArgoutBool (JNIEnv *jenv, jboolean *jarr, bool *carr, jbooleanArray input);
static jbooleanArray SWIG_JavaArrayOutBool (JNIEnv *jenv, bool *result, jsize sz);


static int SWIG_JavaArrayInSchar (JNIEnv *jenv, jbyte **jarr, signed char **carr, jbyteArray input);
static void SWIG_JavaArrayArgoutSchar (JNIEnv *jenv, jbyte *jarr, signed char *carr, jbyteArray input);
static jbyteArray SWIG_JavaArrayOutSchar (JNIEnv *jenv, signed char *result, jsize sz);


static int SWIG_JavaArrayInUchar (JNIEnv *jenv, jshort **jarr, unsigned char **carr, jshortArray input);
static void SWIG_JavaArrayArgoutUchar (JNIEnv *jenv, jshort *jarr, unsigned char *carr, jshortArray input);
static jshortArray SWIG_JavaArrayOutUchar (JNIEnv *jenv, unsigned char *result, jsize sz);


static int SWIG_JavaArrayInShort (JNIEnv *jenv, jshort **jarr, short **carr, jshortArray input);
static void SWIG_JavaArrayArgoutShort (JNIEnv *jenv, jshort *jarr, short *carr, jshortArray input);
static jshortArray SWIG_JavaArrayOutShort (JNIEnv *jenv, short *result, jsize sz);


static int SWIG_JavaArrayInUshort (JNIEnv *jenv, jint **jarr, unsigned short **carr, jintArray input);
static void SWIG_JavaArrayArgoutUshort (JNIEnv *jenv, jint *jarr, unsigned short *carr, jintArray input);
static jintArray SWIG_JavaArrayOutUshort (JNIEnv *jenv, unsigned short *result, jsize sz);


static int SWIG_JavaArrayInInt (JNIEnv *jenv, jint **jarr, int **carr, jintArray input);
static void SWIG_JavaArrayArgoutInt (JNIEnv *jenv, jint *jarr, int *carr, jintArray input);
static jintArray SWIG_JavaArrayOutInt (JNIEnv *jenv, int *result, jsize sz);


static int SWIG_JavaArrayInUint (JNIEnv *jenv, jlong **jarr, unsigned int **carr, jlongArray input);
static void SWIG_JavaArrayArgoutUint (JNIEnv *jenv, jlong *jarr, unsigned int *carr, jlongArray input);
static jlongArray SWIG_JavaArrayOutUint (JNIEnv *jenv, unsigned int *result, jsize sz);


static int SWIG_JavaArrayInLong (JNIEnv *jenv, jint **jarr, long **carr, jintArray input);
static void SWIG_JavaArrayArgoutLong (JNIEnv *jenv, jint *jarr, long *carr, jintArray input);
static jintArray SWIG_JavaArrayOutLong (JNIEnv *jenv, long *result, jsize sz);


static int SWIG_JavaArrayInUlong (JNIEnv *jenv, jlong **jarr, uint64_t **carr, jlongArray input);
static void SWIG_JavaArrayArgoutUlong (JNIEnv *jenv, jlong *jarr, uint64_t *carr, jlongArray input);
static jlongArray SWIG_JavaArrayOutUlong (JNIEnv *jenv, uint64_t *result, jsize sz);


static int SWIG_JavaArrayInLonglong (JNIEnv *jenv, jlong **jarr, jlong **carr, jlongArray input);
static void SWIG_JavaArrayArgoutLonglong (JNIEnv *jenv, jlong *jarr, jlong *carr, jlongArray input);
static jlongArray SWIG_JavaArrayOutLonglong (JNIEnv *jenv, jlong *result, jsize sz);


static int SWIG_JavaArrayInFloat (JNIEnv *jenv, jfloat **jarr, float **carr, jfloatArray input);
static void SWIG_JavaArrayArgoutFloat (JNIEnv *jenv, jfloat *jarr, float *carr, jfloatArray input);
static jfloatArray SWIG_JavaArrayOutFloat (JNIEnv *jenv, float *result, jsize sz);


static int SWIG_JavaArrayInDouble (JNIEnv *jenv, jdouble **jarr, double **carr, jdoubleArray input);
static void SWIG_JavaArrayArgoutDouble (JNIEnv *jenv, jdouble *jarr, double *carr, jdoubleArray input);
static jdoubleArray SWIG_JavaArrayOutDouble (JNIEnv *jenv, double *result, jsize sz);


#else


/* bool[] support */
static int SWIG_JavaArrayInBool (JNIEnv *jenv, jboolean **jarr, bool **carr, jbooleanArray input) {
  int i;
  jsize sz;
  if (!input) {
    SWIG_JavaThrowException(jenv, SWIG_JavaNullPointerException, "null array");
    return 0;
  }
  sz = jenv->GetArrayLength(input);
  *jarr = jenv->GetBooleanArrayElements(input, 0);
  if (!*jarr)
    return 0; 
  *carr = new bool[sz]; 
  if (!*carr) {
    SWIG_JavaThrowException(jenv, SWIG_JavaOutOfMemoryError, "array memory allocation failed");
    return 0;
  }
  for (i=0; i<sz; i++)
    (*carr)[i] = ((*jarr)[i] != 0);
  return 1;
}

static void SWIG_JavaArrayArgoutBool (JNIEnv *jenv, jboolean *jarr, bool *carr, jbooleanArray input) {
  jenv->ReleaseBooleanArrayElements(input, jarr, JNI_ABORT);
}

static jbooleanArray SWIG_JavaArrayOutBool (JNIEnv *jenv, bool *result, jsize sz) {
  jboolean *arr;
  int i;
  jbooleanArray jresult = jenv->NewBooleanArray(sz);
  if (!jresult)
    return NULL;
  arr = jenv->GetBooleanArrayElements(jresult, 0);
  if (!arr)
    return NULL;
  for (i=0; i<sz; i++)
    arr[i] = (jboolean)result[i];
  jenv->ReleaseBooleanArrayElements(jresult, arr, 0);
  return jresult;
}


/* signed char[] support */
static int SWIG_JavaArrayInSchar (JNIEnv *jenv, jbyte **jarr, signed char **carr, jbyteArray input) {
  int i;
  jsize sz;
  if (!input) {
    SWIG_JavaThrowException(jenv, SWIG_JavaNullPointerException, "null array");
    return 0;
  }
  sz = jenv->GetArrayLength(input);
  *jarr = jenv->GetByteArrayElements(input, 0);
  if (!*jarr)
    return 0; 
  *carr = new signed char[sz]; 
  if (!*carr) {
    SWIG_JavaThrowException(jenv, SWIG_JavaOutOfMemoryError, "array memory allocation failed");
    return 0;
  }
  for (i=0; i<sz; i++)
    (*carr)[i] = (signed char)(*jarr)[i];
  return 1;
}

static void SWIG_JavaArrayArgoutSchar (JNIEnv *jenv, jbyte *jarr, signed char *carr, jbyteArray input) {
  jenv->ReleaseByteArrayElements(input, jarr, JNI_ABORT);
}

static jbyteArray SWIG_JavaArrayOutSchar (JNIEnv *jenv, signed char *result, jsize sz) {
  jbyte *arr;
  int i;
  jbyteArray jresult = jenv->NewByteArray(sz);
  if (!jresult)
    return NULL;
  arr = jenv->GetByteArrayElements(jresult, 0);
  if (!arr)
    return NULL;
  for (i=0; i<sz; i++)
    arr[i] = (jbyte)result[i];
  jenv->ReleaseByteArrayElements(jresult, arr, 0);
  return jresult;
}


/* unsigned char[] support */
static int SWIG_JavaArrayInUchar (JNIEnv *jenv, jshort **jarr, unsigned char **carr, jshortArray input) {
  int i;
  jsize sz;
  if (!input) {
    SWIG_JavaThrowException(jenv, SWIG_JavaNullPointerException, "null array");
    return 0;
  }
  sz = jenv->GetArrayLength(input);
  *jarr = jenv->GetShortArrayElements(input, 0);
  if (!*jarr)
    return 0; 
  *carr = new unsigned char[sz]; 
  if (!*carr) {
    SWIG_JavaThrowException(jenv, SWIG_JavaOutOfMemoryError, "array memory allocation failed");
    return 0;
  }
  for (i=0; i<sz; i++)
    (*carr)[i] = (unsigned char)(*jarr)[i];
  return 1;
}

static void SWIG_JavaArrayArgoutUchar (JNIEnv *jenv, jshort *jarr, unsigned char *carr, jshortArray input) {
  jenv->ReleaseShortArrayElements(input, jarr, JNI_ABORT);
}

static jshortArray SWIG_JavaArrayOutUchar (JNIEnv *jenv, unsigned char *result, jsize sz) {
  jshort *arr;
  int i;
  jshortArray jresult = jenv->NewShortArray(sz);
  if (!jresult)
    return NULL;
  arr = jenv->GetShortArrayElements(jresult, 0);
  if (!arr)
    return NULL;
  for (i=0; i<sz; i++)
    arr[i] = (jshort)result[i];
  jenv->ReleaseShortArrayElements(jresult, arr, 0);
  return jresult;
}


/* short[] support */
static int SWIG_JavaArrayInShort (JNIEnv *jenv, jshort **jarr, short **carr, jshortArray input) {
  int i;
  jsize sz;
  if (!input) {
    SWIG_JavaThrowException(jenv, SWIG_JavaNullPointerException, "null array");
    return 0;
  }
  sz = jenv->GetArrayLength(input);
  *jarr = jenv->GetShortArrayElements(input, 0);
  if (!*jarr)
    return 0; 
  *carr = new short[sz]; 
  if (!*carr) {
    SWIG_JavaThrowException(jenv, SWIG_JavaOutOfMemoryError, "array memory allocation failed");
    return 0;
  }
  for (i=0; i<sz; i++)
    (*carr)[i] = (short)(*jarr)[i];
  return 1;
}

static void SWIG_JavaArrayArgoutShort (JNIEnv *jenv, jshort *jarr, short *carr, jshortArray input) {
  jenv->ReleaseShortArrayElements(input, jarr, JNI_ABORT);
}

static jshortArray SWIG_JavaArrayOutShort (JNIEnv *jenv, short *result, jsize sz) {
  jshort *arr;
  int i;
  jshortArray jresult = jenv->NewShortArray(sz);
  if (!jresult)
    return NULL;
  arr = jenv->GetShortArrayElements(jresult, 0);
  if (!arr)
    return NULL;
  for (i=0; i<sz; i++)
    arr[i] = (jshort)result[i];
  jenv->ReleaseShortArrayElements(jresult, arr, 0);
  return jresult;
}


/* unsigned short[] support */
static int SWIG_JavaArrayInUshort (JNIEnv *jenv, jint **jarr, unsigned short **carr, jintArray input) {
  int i;
  jsize sz;
  if (!input) {
    SWIG_JavaThrowException(jenv, SWIG_JavaNullPointerException, "null array");
    return 0;
  }
  sz = jenv->GetArrayLength(input);
  *jarr = jenv->GetIntArrayElements(input, 0);
  if (!*jarr)
    return 0; 
  *carr = new unsigned short[sz]; 
  if (!*carr) {
    SWIG_JavaThrowException(jenv, SWIG_JavaOutOfMemoryError, "array memory allocation failed");
    return 0;
  }
  for (i=0; i<sz; i++)
    (*carr)[i] = (unsigned short)(*jarr)[i];
  return 1;
}

static void SWIG_JavaArrayArgoutUshort (JNIEnv *jenv, jint *jarr, unsigned short *carr, jintArray input) {
  jenv->ReleaseIntArrayElements(input, jarr, JNI_ABORT);
}

static jintArray SWIG_JavaArrayOutUshort (JNIEnv *jenv, unsigned short *result, jsize sz) {
  jint *arr;
  int i;
  jintArray jresult = jenv->NewIntArray(sz);
  if (!jresult)
    return NULL;
  arr = jenv->GetIntArrayElements(jresult, 0);
  if (!arr)
    return NULL;
  for (i=0; i<sz; i++)
    arr[i] = (jint)result[i];
  jenv->ReleaseIntArrayElements(jresult, arr, 0);
  return jresult;
}


/* int[] support */
static int SWIG_JavaArrayInInt (JNIEnv *jenv, jint **jarr, int **carr, jintArray input) {
  int i;
  jsize sz;
  if (!input) {
    SWIG_JavaThrowException(jenv, SWIG_JavaNullPointerException, "null array");
    return 0;
  }
  sz = jenv->GetArrayLength(input);
  *jarr = jenv->GetIntArrayElements(input, 0);
  if (!*jarr)
    return 0; 
  *carr = new int[sz]; 
  if (!*carr) {
    SWIG_JavaThrowException(jenv, SWIG_JavaOutOfMemoryError, "array memory allocation failed");
    return 0;
  }
  for (i=0; i<sz; i++)
    (*carr)[i] = (int)(*jarr)[i];
  return 1;
}

static void SWIG_JavaArrayArgoutInt (JNIEnv *jenv, jint *jarr, int *carr, jintArray input) {
  jenv->ReleaseIntArrayElements(input, jarr, JNI_ABORT);
}



/* unsigned int[] support */
static int SWIG_JavaArrayInUint (JNIEnv *jenv, jlong **jarr, unsigned int **carr, jlongArray input) {
  int i;
  jsize sz;
  if (!input) {
    SWIG_JavaThrowException(jenv, SWIG_JavaNullPointerException, "null array");
    return 0;
  }
  sz = jenv->GetArrayLength(input);
  *jarr = jenv->GetLongArrayElements(input, 0);
  if (!*jarr)
    return 0; 
  *carr = new unsigned int[sz]; 
  if (!*carr) {
    SWIG_JavaThrowException(jenv, SWIG_JavaOutOfMemoryError, "array memory allocation failed");
    return 0;
  }
  for (i=0; i<sz; i++)
    (*carr)[i] = (unsigned int)(*jarr)[i];
  return 1;
}

static void SWIG_JavaArrayArgoutUint (JNIEnv *jenv, jlong *jarr, unsigned int *carr, jlongArray input) {
  jenv->ReleaseLongArrayElements(input, jarr, JNI_ABORT);
}

static jlongArray SWIG_JavaArrayOutUint (JNIEnv *jenv, unsigned int *result, jsize sz) {
  jlong *arr;
  int i;
  jlongArray jresult = jenv->NewLongArray(sz);
  if (!jresult)
    return NULL;
  arr = jenv->GetLongArrayElements(jresult, 0);
  if (!arr)
    return NULL;
  for (i=0; i<sz; i++)
    arr[i] = (jlong)result[i];
  jenv->ReleaseLongArrayElements(jresult, arr, 0);
  return jresult;
}


/* long[] support */
static int SWIG_JavaArrayInLong (JNIEnv *jenv, jint **jarr, long **carr, jintArray input) {
  int i;
  jsize sz;
  if (!input) {
    SWIG_JavaThrowException(jenv, SWIG_JavaNullPointerException, "null array");
    return 0;
  }
  sz = jenv->GetArrayLength(input);
  *jarr = jenv->GetIntArrayElements(input, 0);
  if (!*jarr)
    return 0; 
  *carr = new long[sz]; 
  if (!*carr) {
    SWIG_JavaThrowException(jenv, SWIG_JavaOutOfMemoryError, "array memory allocation failed");
    return 0;
  }
  for (i=0; i<sz; i++)
    (*carr)[i] = (long)(*jarr)[i];
  return 1;
}

static void SWIG_JavaArrayArgoutLong (JNIEnv *jenv, jint *jarr, long *carr, jintArray input) {
  jenv->ReleaseIntArrayElements(input, jarr, JNI_ABORT);
}

static jintArray SWIG_JavaArrayOutLong (JNIEnv *jenv, long *result, jsize sz) {
  jint *arr;
  int i;
  jintArray jresult = jenv->NewIntArray(sz);
  if (!jresult)
    return NULL;
  arr = jenv->GetIntArrayElements(jresult, 0);
  if (!arr)
    return NULL;
  for (i=0; i<sz; i++)
    arr[i] = (jint)result[i];
  jenv->ReleaseIntArrayElements(jresult, arr, 0);
  return jresult;
}


/* unsigned long[] support */
static int SWIG_JavaArrayInUlong (JNIEnv *jenv, jlong **jarr, uint64_t **carr, jlongArray input) {
  int i;
  jsize sz;
  if (!input) {
    SWIG_JavaThrowException(jenv, SWIG_JavaNullPointerException, "null array");
    return 0;
  }
  sz = jenv->GetArrayLength(input);
  *jarr = jenv->GetLongArrayElements(input, 0);
  if (!*jarr)
    return 0; 
  *carr = new uint64_t[sz]; 
  if (!*carr) {
    SWIG_JavaThrowException(jenv, SWIG_JavaOutOfMemoryError, "array memory allocation failed");
    return 0;
  }
  for (i=0; i<sz; i++)
    (*carr)[i] = (uint64_t)(*jarr)[i];
  return 1;
}

static void SWIG_JavaArrayArgoutUlong (JNIEnv *jenv, jlong *jarr, uint64_t *carr, jlongArray input) {
  jenv->ReleaseLongArrayElements(input, jarr, JNI_ABORT);
}

static jlongArray SWIG_JavaArrayOutUlong (JNIEnv *jenv, uint64_t *result, jsize sz) {
  jlong *arr;
  int i;
  jlongArray jresult = jenv->NewLongArray(sz);
  if (!jresult)
    return NULL;
  arr = jenv->GetLongArrayElements(jresult, 0);
  if (!arr)
    return NULL;
  for (i=0; i<sz; i++)
    arr[i] = (jlong)result[i];
  jenv->ReleaseLongArrayElements(jresult, arr, 0);
  return jresult;
}


/* jlong[] support */
static int SWIG_JavaArrayInLonglong (JNIEnv *jenv, jlong **jarr, jlong **carr, jlongArray input) {
  int i;
  jsize sz;
  if (!input) {
    SWIG_JavaThrowException(jenv, SWIG_JavaNullPointerException, "null array");
    return 0;
  }
  sz = jenv->GetArrayLength(input);
  *jarr = jenv->GetLongArrayElements(input, 0);
  if (!*jarr)
    return 0; 
  *carr = new jlong[sz]; 
  if (!*carr) {
    SWIG_JavaThrowException(jenv, SWIG_JavaOutOfMemoryError, "array memory allocation failed");
    return 0;
  }
  for (i=0; i<sz; i++)
    (*carr)[i] = (jlong)(*jarr)[i];
  return 1;
}

static void SWIG_JavaArrayArgoutLonglong (JNIEnv *jenv, jlong *jarr, jlong *carr, jlongArray input) {
  jenv->ReleaseLongArrayElements(input, jarr, JNI_ABORT);
}

static jlongArray SWIG_JavaArrayOutLonglong (JNIEnv *jenv, jlong *result, jsize sz) {
  jlong *arr;
  int i;
  jlongArray jresult = jenv->NewLongArray(sz);
  if (!jresult)
    return NULL;
  arr = jenv->GetLongArrayElements(jresult, 0);
  if (!arr)
    return NULL;
  for (i=0; i<sz; i++)
    arr[i] = (jlong)result[i];
  jenv->ReleaseLongArrayElements(jresult, arr, 0);
  return jresult;
}


/* float[] support */
static int SWIG_JavaArrayInFloat (JNIEnv *jenv, jfloat **jarr, float **carr, jfloatArray input) {
  int i;
  jsize sz;
  if (!input) {
    SWIG_JavaThrowException(jenv, SWIG_JavaNullPointerException, "null array");
    return 0;
  }
  sz = jenv->GetArrayLength(input);
  *jarr = jenv->GetFloatArrayElements(input, 0);
  if (!*jarr)
    return 0; 
  *carr = new float[sz]; 
  if (!*carr) {
    SWIG_JavaThrowException(jenv, SWIG_JavaOutOfMemoryError, "array memory allocation failed");
    return 0;
  }
  for (i=0; i<sz; i++)
    (*carr)[i] = (float)(*jarr)[i];
  return 1;
}

static void SWIG_JavaArrayArgoutFloat (JNIEnv *jenv, jfloat *jarr, float *carr, jfloatArray input) {
  jenv->ReleaseFloatArrayElements(input, jarr, JNI_ABORT);
}

static jfloatArray SWIG_JavaArrayOutFloat (JNIEnv *jenv, float *result, jsize sz) {
  jfloat *arr;
  int i;
  jfloatArray jresult = jenv->NewFloatArray(sz);
  if (!jresult)
    return NULL;
  arr = jenv->GetFloatArrayElements(jresult, 0);
  if (!arr)
    return NULL;
  for (i=0; i<sz; i++)
    arr[i] = (jfloat)result[i];
  jenv->ReleaseFloatArrayElements(jresult, arr, 0);
  return jresult;
}


/* double[] support */
static int SWIG_JavaArrayInDouble (JNIEnv *jenv, jdouble **jarr, double **carr, jdoubleArray input) {
  int i;
  jsize sz;
  if (!input) {
    SWIG_JavaThrowException(jenv, SWIG_JavaNullPointerException, "null array");
    return 0;
  }
  sz = jenv->GetArrayLength(input);
  *jarr = jenv->GetDoubleArrayElements(input, 0);
  if (!*jarr)
    return 0; 
  *carr = new double[sz]; 
  if (!*carr) {
    SWIG_JavaThrowException(jenv, SWIG_JavaOutOfMemoryError, "array memory allocation failed");
    return 0;
  }
  for (i=0; i<sz; i++)
    (*carr)[i] = (double)(*jarr)[i];
  return 1;
}

static void SWIG_JavaArrayArgoutDouble (JNIEnv *jenv, jdouble *jarr, double *carr, jdoubleArray input) {
  jenv->ReleaseDoubleArrayElements(input, jarr, JNI_ABORT);
}

static jdoubleArray SWIG_JavaArrayOutDouble (JNIEnv *jenv, double *result, jsize sz) {
  jdouble *arr;
  int i;
  jdoubleArray jresult = jenv->NewDoubleArray(sz);
  if (!jresult)
    return NULL;
  arr = jenv->GetDoubleArrayElements(jresult, 0);
  if (!arr)
    return NULL;
  for (i=0; i<sz; i++)
    arr[i] = (jdouble)result[i];
  jenv->ReleaseDoubleArrayElements(jresult, arr, 0);
  return jresult;
}


#endif


#ifdef __cplusplus
extern "C" {
#endif


 int SWIG_JavaArrayInBool (JNIEnv *jenv, jboolean **jarr, bool **carr, jbooleanArray input);
 void SWIG_JavaArrayArgoutBool (JNIEnv *jenv, jboolean *jarr, bool *carr, jbooleanArray input);
 jbooleanArray SWIG_JavaArrayOutBool (JNIEnv *jenv, bool *result, jsize sz);


 int SWIG_JavaArrayInSchar (JNIEnv *jenv, jbyte **jarr, signed char **carr, jbyteArray input);
 void SWIG_JavaArrayArgoutSchar (JNIEnv *jenv, jbyte *jarr, signed char *carr, jbyteArray input);
 jbyteArray SWIG_JavaArrayOutSchar (JNIEnv *jenv, signed char *result, jsize sz);


 int SWIG_JavaArrayInUchar (JNIEnv *jenv, jshort **jarr, unsigned char **carr, jshortArray input);
 void SWIG_JavaArrayArgoutUchar (JNIEnv *jenv, jshort *jarr, unsigned char *carr, jshortArray input);
 jshortArray SWIG_JavaArrayOutUchar (JNIEnv *jenv, unsigned char *result, jsize sz);


 int SWIG_JavaArrayInShort (JNIEnv *jenv, jshort **jarr, short **carr, jshortArray input);
 void SWIG_JavaArrayArgoutShort (JNIEnv *jenv, jshort *jarr, short *carr, jshortArray input);
 jshortArray SWIG_JavaArrayOutShort (JNIEnv *jenv, short *result, jsize sz);


 int SWIG_JavaArrayInUshort (JNIEnv *jenv, jint **jarr, unsigned short **carr, jintArray input);
 void SWIG_JavaArrayArgoutUshort (JNIEnv *jenv, jint *jarr, unsigned short *carr, jintArray input);
 jintArray SWIG_JavaArrayOutUshort (JNIEnv *jenv, unsigned short *result, jsize sz);


 int SWIG_JavaArrayInInt (JNIEnv *jenv, jint **jarr, int **carr, jintArray input);
 void SWIG_JavaArrayArgoutInt (JNIEnv *jenv, jint *jarr, int *carr, jintArray input);
 jintArray SWIG_JavaArrayOutInt (JNIEnv *jenv, int *result, jsize sz);


 int SWIG_JavaArrayInUint (JNIEnv *jenv, jlong **jarr, unsigned int **carr, jlongArray input);
 void SWIG_JavaArrayArgoutUint (JNIEnv *jenv, jlong *jarr, unsigned int *carr, jlongArray input);
 jlongArray SWIG_JavaArrayOutUint (JNIEnv *jenv, unsigned int *result, jsize sz);


 int SWIG_JavaArrayInLong (JNIEnv *jenv, jint **jarr, long **carr, jintArray input);
 void SWIG_JavaArrayArgoutLong (JNIEnv *jenv, jint *jarr, long *carr, jintArray input);
 jintArray SWIG_JavaArrayOutLong (JNIEnv *jenv, long *result, jsize sz);


 int SWIG_JavaArrayInUlong (JNIEnv *jenv, jlong **jarr, uint64_t **carr, jlongArray input);
 void SWIG_JavaArrayArgoutUlong (JNIEnv *jenv, jlong *jarr, unsigned long *carr, jlongArray input);
 jlongArray SWIG_JavaArrayOutUlong (JNIEnv *jenv, unsigned long *result, jsize sz);


 int SWIG_JavaArrayInLonglong (JNIEnv *jenv, jlong **jarr, jlong **carr, jlongArray input);
 void SWIG_JavaArrayArgoutLonglong (JNIEnv *jenv, jlong *jarr, jlong *carr, jlongArray input);
 jlongArray SWIG_JavaArrayOutLonglong (JNIEnv *jenv, jlong *result, jsize sz);


 int SWIG_JavaArrayInFloat (JNIEnv *jenv, jfloat **jarr, float **carr, jfloatArray input);
 void SWIG_JavaArrayArgoutFloat (JNIEnv *jenv, jfloat *jarr, float *carr, jfloatArray input);
 jfloatArray SWIG_JavaArrayOutFloat (JNIEnv *jenv, float *result, jsize sz);


 int SWIG_JavaArrayInDouble (JNIEnv *jenv, jdouble **jarr, double **carr, jdoubleArray input);
 void SWIG_JavaArrayArgoutDouble (JNIEnv *jenv, jdouble *jarr, double *carr, jdoubleArray input);
 jdoubleArray SWIG_JavaArrayOutDouble (JNIEnv *jenv, double *result, jsize sz);



/*
JNIEXPORT void JNICALL Java_io_tiledb_api_customJNI_version(JNIEnv *env, jobject obj, jobject version) {
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
*/

JNIEXPORT jlong JNICALL Java_io_tiledb_api_customJNI_newIntArray(JNIEnv *jenv, jobject obj, jintArray array, jint size) {
  jlong jresult = 0 ;
  intArray *result = 0 ;
  int *arr = jenv->GetIntArrayElements(array, 0);
  result = (intArray *)new int[(int) size]();
  memcpy(result, arr, size * sizeof(int));
  jenv->ReleaseIntArrayElements(array, arr, 0);
  *(intArray **)&jresult = result; 
  return jresult;
}

JNIEXPORT jlong JNICALL Java_io_tiledb_api_customJNI_newIntArraySet(JNIEnv *jenv, jclass jcls, jintArray jarg1) {
  jlong jresult = 0 ;
  int *arg1 ;
  jint *jarr1 ;
  
  (void)jenv;
  (void)jcls;
  if (!SWIG_JavaArrayInInt(jenv, &jarr1, (int **)&arg1, jarg1)) return 0; 
  SWIG_JavaArrayArgoutInt(jenv, jarr1, arg1, jarg1);
  *(void **)&jresult = (void *)arg1; 
  return jresult;
}

JNIEXPORT jintArray JNICALL Java_io_tiledb_api_customJNI_intArrayGet(JNIEnv *jenv, jobject obj, jlong array, jint sz) {
  intArray *arr = *(intArray **)&array;
  jintArray jresult = jenv->NewIntArray(sz);
  if (!jresult)
    return NULL;
  jenv->ReleaseIntArrayElements(jresult, arr, 0);
  return jresult;
}


JNIEXPORT jlong JNICALL Java_io_tiledb_api_customJNI_newInt32ArraySet(JNIEnv *jenv, jclass jcls, jintArray jarg1) {
  jlong jresult = 0 ;
  int32_t *arg1 ;
  jint *jarr1 ;
  
  (void)jenv;
  (void)jcls;
  if (!SWIG_JavaArrayInInt(jenv, &jarr1, (int **)&arg1, jarg1)) return 0; 
  SWIG_JavaArrayArgoutInt(jenv, jarr1, arg1, jarg1);
  *(void **)&jresult = (void *)arg1; 
  return jresult; 
}

JNIEXPORT jintArray JNICALL Java_io_tiledb_api_customJNI_int32ArrayGet(JNIEnv *jenv, jobject obj, jlong array, jint sz) {
  intArray *arr = *(intArray **)&array;
  jintArray jresult = jenv->NewIntArray(sz);
  if (!jresult)
    return NULL;
  jenv->ReleaseIntArrayElements(jresult, arr, 0);
  return jresult;
}


JNIEXPORT jlong JNICALL Java_io_tiledb_api_customJNI_newInt64ArraySet(JNIEnv *jenv, jclass jcls, jlongArray jarg1) {
  jlong jresult = 0 ;
  int64_t *arg1 ;
  jlong *jarr1 ;
  
  (void)jenv;
  (void)jcls;
  if (!SWIG_JavaArrayInLonglong(jenv, &jarr1, (long long **)&arg1, jarg1)) return 0;  
  SWIG_JavaArrayArgoutLonglong(jenv, jarr1, arg1, jarg1);
  *(void **)&jresult = (void *)arg1; 
  return jresult; 
}

JNIEXPORT jlongArray JNICALL Java_io_tiledb_api_customJNI_int64ArrayGet(JNIEnv *jenv, jobject obj, jlong array, jint sz) {
  int64_t *arr = *(int64_t **)&array;
  jlongArray jresult = jenv->NewLongArray(sz);
  if (!jresult)
    return NULL;
  jenv->ReleaseLongArrayElements(jresult, arr, 0);
  return jresult;
}

JNIEXPORT jlong JNICALL Java_io_tiledb_api_customJNI_newCharArraySet(JNIEnv *jenv, jclass jcls, jstring jarg1) {
  jlong jresult = 0 ;
  char *arg1 ;
  
  (void)jenv;
  (void)jcls;
  arg1 = 0;
  if (jarg1) {
    char *temp = (char *)jenv->GetStringUTFChars(jarg1, 0);
    jsize length = jenv->GetStringUTFLength(jarg1);
  	arg1 = new char[length];
  	strcpy(arg1, temp);
    if (!arg1) return 0;
    jenv->ReleaseStringUTFChars(jarg1, (const char *)temp);
  }
  *(void **)&jresult = (void *)arg1; 
  return jresult; 
}

JNIEXPORT jstring JNICALL Java_io_tiledb_api_customJNI_charArrayGet(JNIEnv *jenv, jobject obj, jlong array, jint sz) {
  char *arr = *(char **)&array;
  jstring jresult = jenv->NewStringUTF(arr);
  if (!jresult)
    return NULL;
  return jresult;
}

JNIEXPORT jlong JNICALL Java_io_tiledb_api_customJNI_newFloatArraySet(JNIEnv *jenv, jclass jcls, jfloatArray jarg1) {
  jlong jresult = 0 ;
  float *arg1 ;
  jfloat *jarr1 ;
  
  (void)jenv;
  (void)jcls;
  if (!SWIG_JavaArrayInFloat(jenv, &jarr1, (float **)&arg1, jarg1)) return 0; 
  SWIG_JavaArrayArgoutFloat(jenv, jarr1, arg1, jarg1);
  *(void **)&jresult = (void *)arg1; 
  return jresult; 
}

JNIEXPORT jfloatArray JNICALL Java_io_tiledb_api_customJNI_floatArrayGet(JNIEnv *jenv, jobject obj, jlong array, jint sz) {
  float *arr = *(float **)&array;
  jfloatArray jresult = jenv->NewFloatArray(sz);
  if (!jresult)
    return NULL;
  jenv->ReleaseFloatArrayElements(jresult, arr, 0);
  return jresult;
}


JNIEXPORT jlong JNICALL Java_io_tiledb_api_customJNI_newDoubleArraySet(JNIEnv *jenv, jclass jcls, jdoubleArray jarg1) {
  jlong jresult = 0 ;
  double *arg1 ;
  jdouble *jarr1 ;
  
  (void)jenv;
  (void)jcls;
  if (!SWIG_JavaArrayInDouble(jenv, &jarr1, (double **)&arg1, jarg1)) return 0; 
  SWIG_JavaArrayArgoutDouble(jenv, jarr1, arg1, jarg1);
  *(void **)&jresult = (void *)arg1; 
  return jresult; 
}

JNIEXPORT jdoubleArray JNICALL Java_io_tiledb_api_customJNI_doubleArrayGet(JNIEnv *jenv, jobject obj, jlong array, jint sz) {
  double *arr = *(double **)&array;
  jdoubleArray jresult = jenv->NewDoubleArray(sz);
  if (!jresult)
    return NULL;
  jenv->ReleaseDoubleArrayElements(jresult, arr, 0);
  return jresult;
}

JNIEXPORT jlong JNICALL Java_io_tiledb_api_customJNI_newInt8ArraySet(JNIEnv *jenv, jclass jcls, jbyteArray jarg1) {
  jlong jresult = 0 ;
  int8_t *arg1 ;
  jbyte *jarr1 ;
  
  (void)jenv;
  (void)jcls;
  if (!SWIG_JavaArrayInSchar(jenv, &jarr1, (signed char **)&arg1, jarg1)) return 0; 
  SWIG_JavaArrayArgoutSchar(jenv, jarr1, arg1, jarg1);
  *(void **)&jresult = (void *)arg1; 
  return jresult; 
}


JNIEXPORT jbyteArray JNICALL Java_io_tiledb_api_customJNI_int8ArrayGet(JNIEnv *jenv, jobject obj, jlong array, jint sz) {
  int8_t *arr = *(int8_t **)&array;
  jbyteArray jresult = jenv->NewByteArray(sz);
  if (!jresult)
    return NULL;
  jenv->ReleaseByteArrayElements(jresult, arr, 0);
  return jresult;
}

JNIEXPORT jlong JNICALL Java_io_tiledb_api_customJNI_newUint8ArraySet(JNIEnv *jenv, jclass jcls, jshortArray jarg1) {
  jlong jresult = 0 ;
  uint8_t *arg1 ;
  jshort *jarr1 ;
  
  (void)jenv;
  (void)jcls;
  if (!SWIG_JavaArrayInUchar(jenv, &jarr1, (unsigned char **)&arg1, jarg1)) return 0; 
  SWIG_JavaArrayArgoutUchar(jenv, jarr1, arg1, jarg1);
  *(void **)&jresult = (void *)arg1; 
  return jresult; 
}

JNIEXPORT jshortArray JNICALL Java_io_tiledb_api_customJNI_uint8ArrayGet(JNIEnv *jenv, jobject obj, jlong array, jint sz) {
  uint8_t *arr = *(uint8_t **)&array;
  jshortArray jresult = jenv->NewShortArray(sz);
  if (!jresult)
    return NULL;
  jshort * short_arr = new jshort[sz];
  for(int i = 0; i<sz; i++){
    short_arr[i] = (jshort)arr[i];
  }
  jenv->ReleaseShortArrayElements(jresult, short_arr, 0);
  return jresult;
}

JNIEXPORT jlong JNICALL Java_io_tiledb_api_customJNI_newInt16ArraySet(JNIEnv *jenv, jclass jcls, jshortArray jarg1) {
  jlong jresult = 0 ;
  int16_t *arg1 ;
  jshort *jarr1 ;
  
  (void)jenv;
  (void)jcls;
  if (!SWIG_JavaArrayInShort(jenv, &jarr1, (short **)&arg1, jarg1)) return 0; 
  SWIG_JavaArrayArgoutShort(jenv, jarr1, arg1, jarg1);
  *(void **)&jresult = (void *)arg1; 
  return jresult; 
}

JNIEXPORT jshortArray JNICALL Java_io_tiledb_api_customJNI_int16ArrayGet(JNIEnv *jenv, jobject obj, jlong array, jint sz) {
  int16_t *arr = *(int16_t **)&array;
  jshortArray jresult = jenv->NewShortArray(sz);
  if (!jresult)
    return NULL;
  jenv->ReleaseShortArrayElements(jresult, arr, 0);
  return jresult;
}

JNIEXPORT jlong JNICALL Java_io_tiledb_api_customJNI_newUint16ArraySet(JNIEnv *jenv, jclass jcls, jintArray jarg1) {
  jlong jresult = 0 ;
  uint16_t *arg1 ;
  jint *jarr1 ;
  
  (void)jenv;
  (void)jcls;
  if (!SWIG_JavaArrayInUshort(jenv, &jarr1, (unsigned short **)&arg1, jarg1)) return 0; 
  SWIG_JavaArrayArgoutUshort(jenv, jarr1, arg1, jarg1);
  *(void **)&jresult = (void *)arg1; 
  return jresult; 
}

JNIEXPORT jintArray JNICALL Java_io_tiledb_api_customJNI_uint16ArrayGet(JNIEnv *jenv, jobject obj, jlong array, jint sz) {
  uint16_t *arr = *(uint16_t **)&array;
  jintArray jresult = jenv->NewIntArray(sz);
  if (!jresult)
    return NULL;
  jint * int_arr = new jint[sz];
  for(int i = 0; i<sz; i++){
    int_arr[i] = (jint)arr[i];
  }
  jenv->ReleaseIntArrayElements(jresult, int_arr, 0);
  return jresult;
}

JNIEXPORT jlong JNICALL Java_io_tiledb_api_customJNI_newUint32ArraySet(JNIEnv *jenv, jclass jcls, jlongArray jarg1) {
  jlong jresult = 0 ;
  uint32_t *arg1 ;
  jlong *jarr1 ;
  
  (void)jenv;
  (void)jcls;
  if (!SWIG_JavaArrayInUint(jenv, &jarr1, (unsigned int **)&arg1, jarg1)) return 0; 
  SWIG_JavaArrayArgoutUint(jenv, jarr1, arg1, jarg1);
  *(void **)&jresult = (void *)arg1; 
  return jresult; 
}

JNIEXPORT jlongArray JNICALL Java_io_tiledb_api_customJNI_uint32ArrayGet(JNIEnv *jenv, jobject obj, jlong array, jint sz) {
  uint32_t *arr = *(uint32_t **)&array;
  jlongArray jresult = jenv->NewLongArray(sz);
  if (!jresult)
    return NULL;
  jlong * long_arr = new jlong[sz];
  for(int i = 0; i<sz; i++){
    long_arr[i] = (jlong)arr[i];
  }
  jenv->ReleaseLongArrayElements(jresult, long_arr, 0);
  return jresult;
}


JNIEXPORT jlong JNICALL Java_io_tiledb_api_customJNI_newUint64ArraySet(JNIEnv *jenv, jclass jcls, jlongArray jarg1) {
  jlong jresult = 0 ;
  uint64_t *arg1 ;
  jlong *jarr1 ;
  
  (void)jenv;
  (void)jcls;
  if (!SWIG_JavaArrayInUlong(jenv, &jarr1, (uint64_t **)&arg1, jarg1)) return 0; 
  SWIG_JavaArrayArgoutUlong(jenv, jarr1, arg1, jarg1);
  *(void **)&jresult = (void *)arg1; 
  return jresult; 
}

JNIEXPORT jlongArray JNICALL Java_io_tiledb_api_customJNI_uint64ArrayGet(JNIEnv *jenv, jobject obj, jlong array, jint sz) {
  uint64_t *arr = *(uint64_t **)&array;
  jlongArray jresult = jenv->NewLongArray(sz);
  if (!jresult)
    return NULL;
  jlong * long_arr = new jlong[sz];
  for(int i = 0; i<sz; i++){
    long_arr[i] = (jlong)arr[i];
  }
  jenv->ReleaseLongArrayElements(jresult, long_arr, 0);
  return jresult;
}






#ifdef __cplusplus
}
#endif


