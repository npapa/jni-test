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

	public static SWIGTYPE_p_void toVoid(doubleArray p) {
		return new SWIGTYPE_p_void(doubleArray.getCPtr(p),false);
	}

	public static floatArray floatFromVoid(SWIGTYPE_p_p_void p) {
		return new floatArray(SWIGTYPE_p_void.getCPtr(tiledb.derefVoid(p)),false);
	}
	
	public static intArray intFromVoid(SWIGTYPE_p_p_void p) {
		return new intArray(SWIGTYPE_p_void.getCPtr(tiledb.derefVoid(p)),false);
	}
	
	public static charArray charFromVoid(SWIGTYPE_p_p_void p) {
		return new charArray(SWIGTYPE_p_void.getCPtr(tiledb.derefVoid(p)),false);
	}
	
}
