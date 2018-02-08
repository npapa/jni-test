package io.tiledb.api;

public class PointerUtils {

	public static SWIGTYPE_p_void toVoid(intArray p){
		return new SWIGTYPE_p_void(intArray.getCPtr(p),false);
	}

	public static SWIGTYPE_p_void toVoid(charArray p){
		return new SWIGTYPE_p_void(charArray.getCPtr(p),false);
	}

	public static SWIGTYPE_p_void toVoid(floatArray p){
		return new SWIGTYPE_p_void(floatArray.getCPtr(p),false);
	}

	public static SWIGTYPE_p_void toVoid(uint64_tArray p){
		return new SWIGTYPE_p_void(uint64_tArray.getCPtr(p),false);
	}
}
