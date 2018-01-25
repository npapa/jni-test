all:
	rm -r src/io/tiledb/api/*
	swig -java -c++ -package io.tiledb.api -outdir src/io/tiledb/api -o tiledb_wrap.cxx swig/tiledb.i
	g++ -std=c++11 -c tiledb_wrap.cxx -Iswig/ -I/System/Library/Frameworks/JavaVM.framework/Versions/Current/Headers/ -I/System/Library/Frameworks/JavaVM.framework/Versions/A/Headers/
	g++ -std=c++11 -c tiledb_wrap_custom.cxx -I/Users/npapa/Desktop/tiledb/jni-test-cpp/TileDB/core/include/cpp_api/ -I/Users/npapa/Desktop/tiledb/jni-test-cpp/TileDB/core/include/c_api -I/System/Library/Frameworks/JavaVM.framework/Versions/Current/Headers/ -I/System/Library/Frameworks/JavaVM.framework/Versions/A/Headers/
	g++ -dynamiclib -o libtiledb.jnilib tiledb_wrap.o tiledb_wrap_custom.o swig/libtiledb.dylib
