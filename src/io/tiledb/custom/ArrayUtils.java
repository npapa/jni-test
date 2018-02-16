package io.tiledb.custom;

import java.math.BigInteger;

import io.tiledb.api.*;

public class ArrayUtils {
	public static intArray newIntArray(int[] array){
		intArray ret = new intArray(array.length);
		for (int i = 0; i < array.length; i++) {
			ret.setitem(i, array[i]);
		}
		return ret;
	}

	public static uint64_tArray newUint64Array(long[] array){
		uint64_tArray ret = new uint64_tArray(array.length);
		for (int i = 0; i < array.length; i++) {
			ret.setitem(i, new BigInteger(array[i]+""));
		}
		return ret;
	}
	
	public static floatArray newFloatArray(float[] array){
		floatArray ret = new floatArray(array.length);
		for (int i = 0; i < array.length; i++) {
			ret.setitem(i, array[i]);
		}
		return ret;
	}

	public static charArray newCharArray(String s){
		char[] array = s.toCharArray();
		charArray ret = new charArray(array.length);
		for (int i = 0; i < array.length; i++) {
			//System.out.print(array[i]);
			ret.setitem(i, array[i]);
		}
		//System.out.println();
		return ret;
	}
	
	public static String substring(charArray array, int start, int size){
		char[] c = new char[size];
		for (int i = start; i < start+size; i++) {
			c[i-start]=array.getitem(i);
		}
		return new String(c);
	}

	public static doubleArray newDoubleArray(double[] array) {
		doubleArray ret = new doubleArray(array.length);
		for (int i = 0; i < array.length; i++) {
			ret.setitem(i, array[i]);
		}
		return ret;
	}
	
}
