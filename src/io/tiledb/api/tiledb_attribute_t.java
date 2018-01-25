/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.tiledb.api;

public class tiledb_attribute_t {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected tiledb_attribute_t(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(tiledb_attribute_t obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        throw new UnsupportedOperationException("C++ destructor does not have public access");
      }
      swigCPtr = 0;
    }
  }

  /** This constructor creates the proxy which initially does not create nor own any C memory */
  public tiledb_attribute_t() {
    this(0, false);
  }

  public void setAttr_(SWIGTYPE_p_void value) {
    tiledbJNI.tiledb_attribute_t_attr__set(swigCPtr, this, SWIGTYPE_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_void getAttr_() {
    long cPtr = tiledbJNI.tiledb_attribute_t_attr__get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

}
