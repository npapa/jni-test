package io.tiledb.examples;

import io.tiledb.api.tiledb;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;


public class Test {
	static {
		System.loadLibrary("tiledb");
	}
	 
	public static void main(String[] args) {
		System.out.println("Testing ByteBuffer: ");
		testByteBuffer();
		System.out.println("\n\nTesting int array: ");
		testIntArray();
	}

	private static void testByteBuffer() {
		int[] int_buf = {0,1,2,3,4,5,6,7,8,9}; 
		
		ByteBuffer buffer = ByteBuffer.allocateDirect(10*4);
		IntBuffer intBuffer = buffer.asIntBuffer();
		intBuffer.put(int_buf);

		System.out.print("Initial Java byte value: [");
		for (int i = 0; i < buffer.capacity(); i++) {
			System.out.print(String.format("%02x", buffer.get(i))+",");
		}
		System.out.println("]");
		System.out.print("Initial Java int value: [");
		for (int i = 0; i < intBuffer.capacity(); i++) {
			System.out.print(String.format("%d", intBuffer.get(i))+",");
		}
		System.out.println("]");
		

		tiledb.testBuffer(buffer);

		System.out.print("Changed Java byte value: [");
		for (int i = 0; i < buffer.capacity(); i++) {
			System.out.print(String.format("%02x", buffer.get(i))+",");
		}
		System.out.println("]");
		System.out.print("Changed Java int value: [");
		for (int i = 0; i < intBuffer.capacity(); i++) {
			System.out.print(String.format("%d", intBuffer.get(i))+",");
		}
		System.out.println("]");
	}

	private static void testIntArray() {
		int[] array = {0,1,2,3,4,5,6,7,8,9}; 
		System.out.print("Java int value: [");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+",");
		}
		System.out.println("]");
		
		tiledb.testIntArray(array);
		
		System.out.print("Changed Java int value: [");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+",");
		}
		System.out.println("]");
	}
}
