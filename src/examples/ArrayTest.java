package examples;


import io.tiledb.api.*;

public class ArrayTest {

  static {
    System.loadLibrary("tiledb");
  }

  public static void main(String[] args) {
    testInt();
    testInt32();
    testInt64();
    testchar();
    testfloat();
    testdouble();
    testint8();
    testuint8();
    testint16();
    testuint16();
    testuint32();
    testuint64();

    System.out.println(UtilsJNI.sizeOfInt());
    System.out.println(UtilsJNI.sizeOfInt32());
    System.out.println(UtilsJNI.sizeOfInt64());
    System.out.println(UtilsJNI.sizeOfChar());
    System.out.println(UtilsJNI.sizeOfFloat());
    System.out.println(UtilsJNI.sizeOfDouble());
    System.out.println(UtilsJNI.sizeOfInt8());
    System.out.println(UtilsJNI.sizeOfUint8());
    System.out.println(UtilsJNI.sizeOfInt16());
    System.out.println(UtilsJNI.sizeOfUint16());
    System.out.println(UtilsJNI.sizeOfUint32());
    System.out.println(UtilsJNI.sizeOfUint64());
  }


  public static void testInt() {
    System.out.println("Test int");
    int[] a_ = {Integer.MIN_VALUE, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, Integer.MAX_VALUE};
    intArray a1 = Utils.newIntArray(a_);
    int[] res = Utils.intArrayGet(a1, a_.length);
    for (int i = 0; i < res.length; i++) {
//			System.out.println(a_[i]+" -> "+res[i]);
      if (a_[i] != res[i])
        System.out.println("Error: " + a_[i] + " -> " + res[i]);
    }
  }

  public static void testInt32() {
    System.out.println("Test int32");
    int[] a_ = {Integer.MIN_VALUE, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, Integer.MAX_VALUE};
    int32_tArray a1 = Utils.newInt32_tArray(a_);
    int[] res = Utils.int32ArrayGet(a1, a_.length);
    for (int i = 0; i < res.length; i++) {
//			System.out.println(a_[i]+" -> "+res[i]);
      if (a_[i] != res[i])
        System.out.println("Error: " + a_[i] + " -> " + res[i]);
    }
  }

  public static void testInt64() {
    System.out.println("Test int64");
    long[] a_ = {Long.MIN_VALUE, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, Long.MAX_VALUE};
    int64_tArray a1 = Utils.newInt64_tArray(a_);
    long[] res = Utils.int64ArrayGet(a1, a_.length);
    for (int i = 0; i < res.length; i++) {
//			System.out.println(a_[i]+" -> "+res[i]);
      if (a_[i] != res[i])
        System.out.println("Error: " + a_[i] + " -> " + res[i]);
    }
  }

  public static void testchar() {
    System.out.println("Test char");
    String a_ = "abcdefg" + "αβγδεζη";
    charArray a1 = Utils.newCharArray(a_);
    String res = Utils.charArrayGet(a1);
    for (int i = 0; i < res.length(); i++) {
//			System.out.println(a_.charAt(i)+" -> "+res.charAt(i));
      if (a_.charAt(i) != res.charAt(i))
        System.out.println("Error: " + a_.charAt(i) + " -> " + res.charAt(i));
    }
  }

  public static void testfloat() {
    System.out.println("Test float");
    float[] a_ = {Float.MIN_VALUE, (float) -5.1, (float) -4.1, (float) -3.1, (float) -2.1,
        (float) -1.1, (float) 0.1, (float) 1.1, (float) 2.1, (float) 3.1, (float) 4.1, Float.MAX_VALUE};
    floatArray a1 = Utils.newFloatArray(a_);
    float[] res = Utils.floatArrayGet(a1, a_.length);
    for (int i = 0; i < res.length; i++) {
//			System.out.println(a_[i]+" -> "+res[i]);
      if (a_[i] != res[i])
        System.out.println("Error: " + a_[i] + " -> " + res[i]);
    }
  }

  public static void testdouble() {
    System.out.println("Test double");
    double[] a_ = {Double.MIN_VALUE, -5.1, -4.1, -3.1, -2.1,
        -1.1, 0.1, 1.1, 2.1, 3.1, 4.1, Double.MAX_VALUE};
    doubleArray a1 = Utils.newDoubleArray(a_);
    double[] res = Utils.doubleArrayGet(a1, a_.length);
    for (int i = 0; i < res.length; i++) {
//			System.out.println(a_[i]+" -> "+res[i]);
      if (a_[i] != res[i])
        System.out.println("Error: " + a_[i] + " -> " + res[i]);
    }
  }

  public static void testint8() {
    System.out.println("Test int8");
    byte[] a_ = {Byte.MIN_VALUE, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, Byte.MAX_VALUE};
    int8_tArray a1 = Utils.newInt8_tArray(a_);
    byte[] res = Utils.int8ArrayGet(a1, a_.length);
    for (int i = 0; i < res.length; i++) {
//			System.out.println(a_[i]+" -> "+res[i]);
      if (a_[i] != res[i])
        System.out.println("Error: " + a_[i] + " -> " + res[i]);
    }
  }

  public static void testuint8() {
    System.out.println("Test uint8");
    short[] a_ = {0, 1, 2, 3, 4, 128, 255};
    uint8_tArray a1 = Utils.newUint8_tArray(a_);
    short[] res = Utils.uint8ArrayGet(a1, a_.length);
    for (int i = 0; i < res.length; i++) {
//			System.out.println(a_[i]+" -> "+res[i]);
      if (a_[i] != res[i])
        System.out.println("Error: " + a_[i] + " -> " + res[i]);
    }
  }

  public static void testint16() {
    System.out.println("Test int16");
    short[] a_ = {Short.MIN_VALUE, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, Short.MAX_VALUE};
    int16_tArray a1 = Utils.newInt16_tArray(a_);
    short[] res = Utils.int16ArrayGet(a1, a_.length);
    for (int i = 0; i < res.length; i++) {
//			System.out.println(a_[i]+" -> "+res[i]);
      if (a_[i] != res[i])
        System.out.println("Error: " + a_[i] + " -> " + res[i]);
    }
  }

  public static void testuint16() {
    System.out.println("Test uint16");
    int[] a_ = {0, 1, 2, 3, 4, 128, Short.MAX_VALUE, 2 * Short.MAX_VALUE};
    uint16_tArray a1 = Utils.newUint16_tArray(a_);
    int[] res = Utils.uint16ArrayGet(a1, a_.length);
    for (int i = 0; i < res.length; i++) {
//			System.out.println(a_[i]+" -> "+res[i]);
      if (a_[i] != res[i])
        System.out.println("Error: " + a_[i] + " -> " + res[i]);
    }
  }

  public static void testuint32() {
    System.out.println("Test uint32");
    long[] a_ = {0, 1, 2, 3, 4, 128, Integer.MAX_VALUE, (long) 2 * (long) Integer.MAX_VALUE};
    uint32_tArray a1 = Utils.newUint32_tArray(a_);
    long[] res = Utils.uint32ArrayGet(a1, a_.length);
    for (int i = 0; i < res.length; i++) {
//			System.out.println(a_[i]+" -> "+res[i]);
      if (a_[i] != res[i])
        System.out.println("Error: " + a_[i] + " -> " + res[i]);
    }
  }

  public static void testuint64() {
    System.out.println("Test uint64");
    long[] a_ = {0, 1, 2, 3, 4, 128, Long.MAX_VALUE};
    uint64_tArray a1 = Utils.newUint64Array(a_);
    long[] res = Utils.uint64ArrayGet(a1, a_.length);
    for (int i = 0; i < res.length; i++) {
//			System.out.println(a_[i]+" -> "+res[i]);
      if (a_[i] != res[i])
        System.out.println("Error: " + a_[i] + " -> " + res[i]);
    }
  }
}
