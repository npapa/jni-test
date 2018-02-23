package examples;

//import io.tiledb.api.Domain;

import io.tiledb.api.*;
import io.tiledb.custom.Version;

public class TiledbVersion {

  static {
    System.loadLibrary("tiledb");
  }

  public static void main(String[] args) {
    SWIGTYPE_p_int major = tiledb.new_intp(), minor = tiledb.new_intp(), rev = tiledb
        .new_intp();
    tiledb.tiledb_version(major, minor, rev);

    // Print version
    System.out.printf("TileDB v%d.%d.%d\n", tiledb.intp_value(major),
        tiledb.intp_value(minor), tiledb.intp_value(rev));
  }

}
