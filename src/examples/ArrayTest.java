package examples;


import io.tiledb.api.ArrayUtils;
import io.tiledb.api.charArray;
import io.tiledb.api.custom;
import io.tiledb.api.doubleArray;
import io.tiledb.api.floatArray;
import io.tiledb.api.int16_tArray;
import io.tiledb.api.int32_tArray;
import io.tiledb.api.int64_tArray;
import io.tiledb.api.int8_tArray;
import io.tiledb.api.intArray;
import io.tiledb.api.uint16_tArray;
import io.tiledb.api.uint32_tArray;
import io.tiledb.api.uint64_tArray;
import io.tiledb.api.uint8_tArray;

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
	}
	
	
	public static void testInt(){
		System.out.println("Test int");
		int[] a_ = {Integer.MIN_VALUE,-5,-4,-3,-2,-1,0,1,2,3,4,Integer.MAX_VALUE};
		intArray a1 = ArrayUtils.newIntArray(a_);
		int[] res = custom.intArrayGet(a1, a_.length);
		for (int i = 0; i < res.length; i++) {
//			System.out.println(a_[i]+" -> "+res[i]);
			if(a_[i]!=res[i])
				System.out.println("Error: "+a_[i]+" -> "+res[i]);
		}
	}

	public static void testInt32(){
		System.out.println("Test int32");
		int[] a_ = {Integer.MIN_VALUE,-5,-4,-3,-2,-1,0,1,2,3,4,Integer.MAX_VALUE};
		int32_tArray a1 = ArrayUtils.newInt32_tArray(a_);
		int[] res = custom.int32ArrayGet(a1, a_.length);
		for (int i = 0; i < res.length; i++) {
//			System.out.println(a_[i]+" -> "+res[i]);
			if(a_[i]!=res[i])
				System.out.println("Error: "+a_[i]+" -> "+res[i]);
		}
	}

	public static void testInt64(){
		System.out.println("Test int64");
		long[] a_ = {Long.MIN_VALUE,-5,-4,-3,-2,-1,0,1,2,3,4,Long.MAX_VALUE};
		int64_tArray a1 = ArrayUtils.newInt64_tArray(a_);
		long[] res = custom.int64ArrayGet(a1, a_.length);
		for (int i = 0; i < res.length; i++) {
//			System.out.println(a_[i]+" -> "+res[i]);
			if(a_[i]!=res[i])
				System.out.println("Error: "+a_[i]+" -> "+res[i]);
		}
	}

	public static void testchar(){
		System.out.println("Test char");
		String a_ = "abcdefg"+"αβγδεζη";
		charArray a1 = ArrayUtils.newCharArray(a_);
		String res = custom.charArrayGet(a1);
		for (int i = 0; i < res.length(); i++) {
//			System.out.println(a_.charAt(i)+" -> "+res.charAt(i));
			if(a_.charAt(i)!=res.charAt(i))
				System.out.println("Error: "+a_.charAt(i)+" -> "+res.charAt(i));
		}
	}
	
	public static void testfloat(){
		System.out.println("Test float");
		float[] a_ = {Float.MIN_VALUE,(float)-5.1,(float)-4.1,(float)-3.1,(float)-2.1,
				(float)-1.1,(float)0.1,(float)1.1,(float)2.1,(float)3.1,(float)4.1,Float.MAX_VALUE};
		floatArray a1 = ArrayUtils.newFloatArray(a_);
		float[] res = custom.floatArrayGet(a1, a_.length);
		for (int i = 0; i < res.length; i++) {
//			System.out.println(a_[i]+" -> "+res[i]);
			if(a_[i]!=res[i])
				System.out.println("Error: "+a_[i]+" -> "+res[i]);
		}
	}
	
	public static void testdouble(){
		System.out.println("Test double");
		double[] a_ = {Double.MIN_VALUE,-5.1,-4.1,-3.1,-2.1,
				-1.1,0.1,1.1,2.1,3.1,4.1,Double.MAX_VALUE};
		doubleArray a1 = ArrayUtils.newDoubleArray(a_);
		double[] res = custom.doubleArrayGet(a1, a_.length);
		for (int i = 0; i < res.length; i++) {
//			System.out.println(a_[i]+" -> "+res[i]);
			if(a_[i]!=res[i])
				System.out.println("Error: "+a_[i]+" -> "+res[i]);
		}
	}
	
	public static void testint8(){
		System.out.println("Test int8");
		byte[] a_ = {Byte.MIN_VALUE,-5,-4,-3,-2,-1,0,1,2,3,4,Byte.MAX_VALUE};
		int8_tArray a1 = ArrayUtils.newInt8_tArray(a_);
		byte[] res = custom.int8ArrayGet(a1, a_.length);
		for (int i = 0; i < res.length; i++) {
//			System.out.println(a_[i]+" -> "+res[i]);
			if(a_[i]!=res[i])
				System.out.println("Error: "+a_[i]+" -> "+res[i]);
		}
	}
	
	public static void testuint8(){
		System.out.println("Test uint8");
		short[] a_ = {0,1,2,3,4,128,255};
		uint8_tArray a1 = ArrayUtils.newUint8_tArray(a_);
		short[] res = custom.uint8ArrayGet(a1, a_.length);
		for (int i = 0; i < res.length; i++) {
//			System.out.println(a_[i]+" -> "+res[i]);
			if(a_[i]!=res[i])
				System.out.println("Error: "+a_[i]+" -> "+res[i]);
		}
	}
	
	public static void testint16(){
		System.out.println("Test int16");
		short[] a_ = {Short.MIN_VALUE,-5,-4,-3,-2,-1,0,1,2,3,4,Short.MAX_VALUE};
		int16_tArray a1 = ArrayUtils.newInt16_tArray(a_);
		short[] res = custom.int16ArrayGet(a1, a_.length);
		for (int i = 0; i < res.length; i++) {
//			System.out.println(a_[i]+" -> "+res[i]);
			if(a_[i]!=res[i])
				System.out.println("Error: "+a_[i]+" -> "+res[i]);
		}
	}
	
	public static void testuint16(){
		System.out.println("Test uint16");
		int[] a_ = {0,1,2,3,4,128,Short.MAX_VALUE,2*Short.MAX_VALUE};
		uint16_tArray a1 = ArrayUtils.newUint16_tArray(a_);
		int[] res = custom.uint16ArrayGet(a1, a_.length);
		for (int i = 0; i < res.length; i++) {
//			System.out.println(a_[i]+" -> "+res[i]);
			if(a_[i]!=res[i])
				System.out.println("Error: "+a_[i]+" -> "+res[i]);
		}
	}
	
	public static void testuint32(){
		System.out.println("Test uint32");
		long[] a_ = {0,1,2,3,4,128,Integer.MAX_VALUE, (long)2*(long)Integer.MAX_VALUE};
		uint32_tArray a1 = ArrayUtils.newUint32_tArray(a_);
		long[] res = custom.uint32ArrayGet(a1, a_.length);
		for (int i = 0; i < res.length; i++) {
//			System.out.println(a_[i]+" -> "+res[i]);
			if(a_[i]!=res[i])
				System.out.println("Error: "+a_[i]+" -> "+res[i]);
		}
	}
	
	public static void testuint64(){
		System.out.println("Test uint64");
		long[] a_ = {0,1,2,3,4,128,Long.MAX_VALUE};
		uint64_tArray a1 = ArrayUtils.newUint64Array(a_);
		long[] res = custom.uint64ArrayGet(a1, a_.length);
		for (int i = 0; i < res.length; i++) {
//			System.out.println(a_[i]+" -> "+res[i]);
			if(a_[i]!=res[i])
				System.out.println("Error: "+a_[i]+" -> "+res[i]);
		}
	}
}