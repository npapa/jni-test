package io.tiledb.api;


public class ArrayUtilsJNI {

  public final static native int sizeOfInt();

  public final static native int sizeOfInt32();

  public final static native int sizeOfInt64();

  public final static native int sizeOfChar();

  public final static native int sizeOfFloat();

  public final static native int sizeOfDouble();

  public final static native int sizeOfInt8();

  public final static native int sizeOfUint8();

  public final static native int sizeOfInt16();

  public final static native int sizeOfUint16();

  public final static native int sizeOfUint32();

  public final static native int sizeOfUint64();

  public final static native long newIntArray(int[] array, int size);

  public final static native long newIntArraySet(int[] jarg1);

  public final static native long newInt32ArraySet(int[] jarg1);

  public final static native long newInt64ArraySet(long[] jarg1);

  public final static native long newCharArraySet(String jarg1);

  public final static native long newFloatArraySet(float[] jarg1);

  public final static native long newDoubleArraySet(double[] jarg1);

  public final static native long newInt8ArraySet(byte[] jarg1);

  public final static native long newUint8ArraySet(short[] jarg1);

  public final static native long newInt16ArraySet(short[] jarg1);

  public final static native long newUint16ArraySet(int[] jarg1);

  public final static native long newUint32ArraySet(long[] jarg1);

  public final static native long newUint64ArraySet(long[] jarg1);


  public final static native int[] intArrayGet(long array, int size);

  public final static native int[] int32ArrayGet(long array, int size);

  public final static native long[] int64ArrayGet(long array, int size);

  public final static native String charArrayGet(long array);

  public final static native float[] floatArrayGet(long array, int size);

  public final static native double[] doubleArrayGet(long array, int size);

  public final static native byte[] int8ArrayGet(long array, int size);

  public final static native short[] uint8ArrayGet(long array, int size);

  public final static native short[] int16ArrayGet(long array, int size);

  public final static native int[] uint16ArrayGet(long array, int size);

  public final static native long[] uint32ArrayGet(long array, int size);

  public final static native long[] uint64ArrayGet(long array, int size);

}
