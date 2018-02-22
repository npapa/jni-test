package io.tiledb.api;


public class custom {

	  public static int[] intArrayGet(intArray array, int size) {
	    return customJNI.intArrayGet(intArray.getCPtr(array), size);
	  }

	  public static int[] int32ArrayGet(int32_tArray array, int size) {
	    return customJNI.int32ArrayGet(int32_tArray.getCPtr(array), size);
	  }

	  public static long[] int64ArrayGet(int64_tArray array, int size) {
	    return customJNI.int64ArrayGet(int64_tArray.getCPtr(array), size);
	  }

	  public static String charArrayGet(charArray array) {
	    return customJNI.charArrayGet(charArray.getCPtr(array));
	  }

	  public static float[] floatArrayGet(floatArray array, int size) {
	    return customJNI.floatArrayGet(floatArray.getCPtr(array), size);
	  }

	  public static double[] doubleArrayGet(doubleArray array, int size) {
	    return customJNI.doubleArrayGet(doubleArray.getCPtr(array), size);
	  }

	  public static byte[] int8ArrayGet(int8_tArray array, int size) {
	    return customJNI.int8ArrayGet(int8_tArray.getCPtr(array), size);
	  }

	  public static short[] uint8ArrayGet(uint8_tArray array, int size) {
	    return customJNI.uint8ArrayGet(uint8_tArray.getCPtr(array), size);
	  }

	  public static short[] int16ArrayGet(int16_tArray array, int size) {
	    return customJNI.int16ArrayGet(int16_tArray.getCPtr(array), size);
	  }
	  
	  public static int[] uint16ArrayGet(uint16_tArray array, int size) {
		return customJNI.uint16ArrayGet(uint16_tArray.getCPtr(array), size);
	  }
	  
	  public static long[] uint32ArrayGet(uint32_tArray array, int size) {
		return customJNI.uint32ArrayGet(uint32_tArray.getCPtr(array), size);
	  }
	  
	  public static long[] uint64ArrayGet(uint64_tArray array, int size) {
		return customJNI.uint64ArrayGet(uint64_tArray.getCPtr(array), size);
	  }
}
