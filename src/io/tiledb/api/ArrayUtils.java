package io.tiledb.api;

import java.math.BigInteger;

import io.tiledb.api.*;

public class ArrayUtils {
	public static intArray newIntArray(int[] array){
		intArray ret = new intArray(customJNI.newIntArraySet(array),true);
		return ret;
	}
	
	public static int32_tArray newInt32_tArray(int[] array){
		int32_tArray ret = new int32_tArray(customJNI.newInt32ArraySet(array),true);
		return ret;
	}
	
	public static int64_tArray newInt64_tArray(long[] array){
		int64_tArray ret = new int64_tArray(customJNI.newInt64ArraySet(array),true);
		return ret;
	}

	public static charArray newCharArray(String array){
		charArray ret = new charArray(customJNI.newCharArraySet(array),true);
		return ret;
	}
	
	public static floatArray newFloatArray(float[] array){
		floatArray ret = new floatArray(customJNI.newFloatArraySet(array),true);
		return ret;
	}
	
	public static doubleArray newDoubleArray(double[] array){
		doubleArray ret = new doubleArray(customJNI.newDoubleArraySet(array),true);
		return ret;
	}
	
	public static int8_tArray newInt8_tArray(byte[] array){
		int8_tArray ret = new int8_tArray(customJNI.newInt8ArraySet(array),true);
		return ret;
	}

	public static uint8_tArray newUint8_tArray(short[] array){
		uint8_tArray ret = new uint8_tArray(customJNI.newUint8ArraySet(array),true);
		return ret;
	}
	
	public static int16_tArray newInt16_tArray(short[] array){
		int16_tArray ret = new int16_tArray(customJNI.newInt16ArraySet(array),true);
		return ret;
	}

	public static uint16_tArray newUint16_tArray(int[] array){
		uint16_tArray ret = new uint16_tArray(customJNI.newUint16ArraySet(array),true);
		return ret;
	}

	public static uint32_tArray newUint32_tArray(long[] array){
		uint32_tArray ret = new uint32_tArray(customJNI.newUint32ArraySet(array),true);
		return ret;
	}

	public static uint64_tArray newUint64Array(long[] array){
		uint64_tArray ret = new uint64_tArray(customJNI.newUint64ArraySet(array),true);
		return ret;
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
	

	public static String substring(charArray array, int start, int size){
		char[] c = new char[size];
		for (int i = start; i < start+size; i++) {
			c[i-start]=array.getitem(i);
		}
		return new String(c);
	}
}
