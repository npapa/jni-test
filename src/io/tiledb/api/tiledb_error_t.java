/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.tiledb.api;

public class tiledb_error_t {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected tiledb_error_t(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(tiledb_error_t obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        tiledbJNI.delete_tiledb_error_t(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setStatus_(SWIGTYPE_p_tiledb__Status value) {
    tiledbJNI.tiledb_error_t_status__set(swigCPtr, this, SWIGTYPE_p_tiledb__Status.getCPtr(value));
  }

  public SWIGTYPE_p_tiledb__Status getStatus_() {
    long cPtr = tiledbJNI.tiledb_error_t_status__get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_tiledb__Status(cPtr, false);
  }

  public void setErrmsg_(SWIGTYPE_p_std__string value) {
    tiledbJNI.tiledb_error_t_errmsg__set(swigCPtr, this, SWIGTYPE_p_std__string.getCPtr(value));
  }

  public SWIGTYPE_p_std__string getErrmsg_() {
    long cPtr = tiledbJNI.tiledb_error_t_errmsg__get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_std__string(cPtr, false);
  }

  public tiledb_error_t() {
    this(tiledbJNI.new_tiledb_error_t(), true);
  }

}
