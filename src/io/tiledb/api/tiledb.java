package io.tiledb.api;

public class tiledb {
  public static void testBuffer(java.nio.ByteBuffer buffer) {
    tiledbJNI.testBuffer(buffer);
  }

  public static void testIntArray(int[] array) {
    tiledbJNI.testIntArray(array);
  }
}
