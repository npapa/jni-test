/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.tiledb.api;

public enum tiledb_query_type_t {
  TILEDB_READ,
  TILEDB_WRITE;

  public final int swigValue() {
    return swigValue;
  }

  public static tiledb_query_type_t swigToEnum(int swigValue) {
    tiledb_query_type_t[] swigValues = tiledb_query_type_t.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (tiledb_query_type_t swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + tiledb_query_type_t.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private tiledb_query_type_t() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private tiledb_query_type_t(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  private tiledb_query_type_t(tiledb_query_type_t swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }

  public static class pointer{
	  tiledb_query_type_t tiledb_query_type_t;
	  public pointer(){
		  tiledb_query_type_t=null;
	  }
	  public tiledb_query_type_t get() {
		return tiledb_query_type_t;
	  }
	  public void set(tiledb_query_type_t tiledb_query_type_t) {
		this.tiledb_query_type_t = tiledb_query_type_t;
	  }
  }
}

