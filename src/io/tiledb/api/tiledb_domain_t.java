/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.tiledb.api;

public class tiledb_domain_t {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected tiledb_domain_t(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(tiledb_domain_t obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        tiledbJNI.delete_tiledb_domain_t(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setDomain_(SWIGTYPE_p_tiledb__Domain value) {
    tiledbJNI.tiledb_domain_t_domain__set(swigCPtr, this, SWIGTYPE_p_tiledb__Domain.getCPtr(value));
  }

  public SWIGTYPE_p_tiledb__Domain getDomain_() {
    long cPtr = tiledbJNI.tiledb_domain_t_domain__get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_tiledb__Domain(cPtr, false);
  }

  public tiledb_domain_t() {
    this(tiledbJNI.new_tiledb_domain_t(), true);
  }

}
