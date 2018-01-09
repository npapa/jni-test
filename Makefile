all:
	g++ -c tiledb_wrap.cxx -I/System/Library/Frameworks/JavaVM.framework/Versions/Current/Headers/ -I/System/Library/Frameworks/JavaVM.framework/Versions/A/Headers/
	g++ -dynamiclib -o libtiledb.jnilib tiledb_wrap.o
