package io.tiledb.api;

public class ArrayUtils {

  public static intArray newIntArray(int[] array) {
    intArray ret = new intArray(ArrayUtilsJNI.newIntArraySet(array), true);
    return ret;
  }


  public static int32_tArray newInt32_tArray(int[] array) {
    int32_tArray ret = new int32_tArray(ArrayUtilsJNI.newInt32ArraySet(array), true);
    return ret;
  }

  public static int64_tArray newInt64_tArray(long[] array) {
    int64_tArray ret = new int64_tArray(ArrayUtilsJNI.newInt64ArraySet(array), true);
    return ret;
  }

  public static charArray newCharArray(String array) {
    charArray ret = new charArray(ArrayUtilsJNI.newCharArraySet(array), true);
    return ret;
  }

  public static floatArray newFloatArray(float[] array) {
    floatArray ret = new floatArray(ArrayUtilsJNI.newFloatArraySet(array), true);
    return ret;
  }

  public static doubleArray newDoubleArray(double[] array) {
    doubleArray ret = new doubleArray(ArrayUtilsJNI.newDoubleArraySet(array), true);
    return ret;
  }

  public static int8_tArray newInt8_tArray(byte[] array) {
    int8_tArray ret = new int8_tArray(ArrayUtilsJNI.newInt8ArraySet(array), true);
    return ret;
  }

  public static uint8_tArray newUint8_tArray(short[] array) {
    uint8_tArray ret = new uint8_tArray(ArrayUtilsJNI.newUint8ArraySet(array), true);
    return ret;
  }

  public static int16_tArray newInt16_tArray(short[] array) {
    int16_tArray ret = new int16_tArray(ArrayUtilsJNI.newInt16ArraySet(array), true);
    return ret;
  }

  public static uint16_tArray newUint16_tArray(int[] array) {
    uint16_tArray ret = new uint16_tArray(ArrayUtilsJNI.newUint16ArraySet(array), true);
    return ret;
  }

  public static uint32_tArray newUint32_tArray(long[] array) {
    uint32_tArray ret = new uint32_tArray(ArrayUtilsJNI.newUint32ArraySet(array), true);
    return ret;
  }

  public static uint64_tArray newUint64Array(long[] array) {
    uint64_tArray ret = new uint64_tArray(ArrayUtilsJNI.newUint64ArraySet(array), true);
    return ret;
  }


  public static int[] intArrayGet(intArray array, int size) {
    return ArrayUtilsJNI.intArrayGet(intArray.getCPtr(array), size);
  }

  public static int[] int32ArrayGet(int32_tArray array, int size) {
    return ArrayUtilsJNI.int32ArrayGet(int32_tArray.getCPtr(array), size);
  }

  public static long[] int64ArrayGet(int64_tArray array, int size) {
    return ArrayUtilsJNI.int64ArrayGet(int64_tArray.getCPtr(array), size);
  }

  public static String charArrayGet(charArray array) {
    return ArrayUtilsJNI.charArrayGet(charArray.getCPtr(array));
  }

  public static float[] floatArrayGet(floatArray array, int size) {
    return ArrayUtilsJNI.floatArrayGet(floatArray.getCPtr(array), size);
  }

  public static double[] doubleArrayGet(doubleArray array, int size) {
    return ArrayUtilsJNI.doubleArrayGet(doubleArray.getCPtr(array), size);
  }

  public static byte[] int8ArrayGet(int8_tArray array, int size) {
    return ArrayUtilsJNI.int8ArrayGet(int8_tArray.getCPtr(array), size);
  }

  public static short[] uint8ArrayGet(uint8_tArray array, int size) {
    return ArrayUtilsJNI.uint8ArrayGet(uint8_tArray.getCPtr(array), size);
  }

  public static short[] int16ArrayGet(int16_tArray array, int size) {
    return ArrayUtilsJNI.int16ArrayGet(int16_tArray.getCPtr(array), size);
  }

  public static int[] uint16ArrayGet(uint16_tArray array, int size) {
    return ArrayUtilsJNI.uint16ArrayGet(uint16_tArray.getCPtr(array), size);
  }

  public static long[] uint32ArrayGet(uint32_tArray array, int size) {
    return ArrayUtilsJNI.uint32ArrayGet(uint32_tArray.getCPtr(array), size);
  }

  public static long[] uint64ArrayGet(uint64_tArray array, int size) {
    return ArrayUtilsJNI.uint64ArrayGet(uint64_tArray.getCPtr(array), size);
  }


  public static int sizeOfType(Object array) {
    Class arrayClass = array.getClass();
    if(arrayClass.equals(intArray.class)){
      return ArrayUtilsJNI.sizeOfInt();
    }
    else if(arrayClass.equals(int32_tArray.class)){
      return ArrayUtilsJNI.sizeOfInt32();
    }
    else if(arrayClass.equals(int64_tArray.class)){
      return ArrayUtilsJNI.sizeOfInt64();
    }
    else if(arrayClass.equals(charArray.class)){
      return ArrayUtilsJNI.sizeOfChar();
    }
    else if(arrayClass.equals(floatArray.class)){
      return ArrayUtilsJNI.sizeOfFloat();
    }
    else if(arrayClass.equals(doubleArray.class)){
      return ArrayUtilsJNI.sizeOfDouble();
    }
    else if(arrayClass.equals(int8_tArray.class)){
      return ArrayUtilsJNI.sizeOfInt8();
    }
    else if(arrayClass.equals(uint8_tArray.class)){
      return ArrayUtilsJNI.sizeOfUint8();
    }
    else if(arrayClass.equals(int16_tArray.class)){
      return ArrayUtilsJNI.sizeOfInt16();
    }
    else if(arrayClass.equals(uint16_tArray.class)){
      return ArrayUtilsJNI.sizeOfUint16();
    }
    else if(arrayClass.equals(uint32_tArray.class)){
      return ArrayUtilsJNI.sizeOfUint32();
    }
    else if(arrayClass.equals(uint64_tArray.class)){
      return ArrayUtilsJNI.sizeOfUint64();
    }
    return -1;
  }

//	public static uint64_tArray newUint64Array(long[] array){
//		uint64_tArray ret = new uint64_tArray(array.length);
//		for (int i = 0; i < array.length; i++) {
//			ret.setitem(i, new BigInteger(array[i]+""));
//		}
//		return ret;
//	}
//	
//	public static floatArray newFloatArray(float[] array){
//		floatArray ret = new floatArray(array.length);
//		for (int i = 0; i < array.length; i++) {
//			ret.setitem(i, array[i]);
//		}
//		return ret;
//	}

//	public static charArray newCharArray(String s){
//		char[] array = s.toCharArray();
//		charArray ret = new charArray(array.length);
//		for (int i = 0; i < array.length; i++) {
//			//System.out.print(array[i]);
//			ret.setitem(i, array[i]);
//		}
//		//System.out.println();
//		return ret;
//	}


//	public static doubleArray newDoubleArray(double[] array) {
//		doubleArray ret = new doubleArray(array.length);
//		for (int i = 0; i < array.length; i++) {
//			ret.setitem(i, array[i]);
//		}
//		return ret;
//	}

  public static String substring(byte[] array, int start, int size) {
    byte[] c = new byte[size];
    for (int i = start; i < start + size; i++) {
      c[i - start] = array[i];
    }
    return new String(c);
  }

  public static String substring(charArray array, int start, int size) {
    char[] c = new char[size];
    for (int i = start; i < start + size; i++) {
      c[i - start] = array.getitem(i);
    }
    return new String(c);
  }
}
