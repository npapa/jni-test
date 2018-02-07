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

	public static uint64_tArray newUint64Array(int[] array){
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
			ret.setitem(i, array[i]);
		}
		return ret;
	}
	
}
