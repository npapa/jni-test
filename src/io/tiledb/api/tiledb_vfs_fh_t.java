/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.tiledb.api;

public class tiledb_vfs_fh_t {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected tiledb_vfs_fh_t(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(tiledb_vfs_fh_t obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        tiledbJNI.delete_tiledb_vfs_fh_t(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setUri_(SWIGTYPE_p_tiledb__URI value) {
    tiledbJNI.tiledb_vfs_fh_t_uri__set(swigCPtr, this, SWIGTYPE_p_tiledb__URI.getCPtr(value));
  }

  public SWIGTYPE_p_tiledb__URI getUri_() {
    return new SWIGTYPE_p_tiledb__URI(tiledbJNI.tiledb_vfs_fh_t_uri__get(swigCPtr, this), true);
  }

  public void setIs_closed_(boolean value) {
    tiledbJNI.tiledb_vfs_fh_t_is_closed__set(swigCPtr, this, value);
  }

  public boolean getIs_closed_() {
    return tiledbJNI.tiledb_vfs_fh_t_is_closed__get(swigCPtr, this);
  }

  public void setVfs_(SWIGTYPE_p_tiledb__VFS value) {
    tiledbJNI.tiledb_vfs_fh_t_vfs__set(swigCPtr, this, SWIGTYPE_p_tiledb__VFS.getCPtr(value));
  }

  public SWIGTYPE_p_tiledb__VFS getVfs_() {
    long cPtr = tiledbJNI.tiledb_vfs_fh_t_vfs__get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_tiledb__VFS(cPtr, false);
  }

  public void setMode_(SWIGTYPE_p_tiledb__VFSMode value) {
    tiledbJNI.tiledb_vfs_fh_t_mode__set(swigCPtr, this, SWIGTYPE_p_tiledb__VFSMode.getCPtr(value));
  }

  public SWIGTYPE_p_tiledb__VFSMode getMode_() {
    return new SWIGTYPE_p_tiledb__VFSMode(tiledbJNI.tiledb_vfs_fh_t_mode__get(swigCPtr, this), true);
  }

  public tiledb_vfs_fh_t() {
    this(tiledbJNI.new_tiledb_vfs_fh_t(), true);
  }

}
