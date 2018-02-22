package io.tiledb.custom;

import io.tiledb.api.customJNI;

public class Version {
	public int major;
	public int minor;
	public int rev;
	
	public Version() {
		customJNI.version(this);
	}
	
	@Override
	public String toString() {
		return "TileDB v" + major + "." + minor + "." + rev;
	}
	
	public int getMajor() {
		return major;
	}

	public void setMajor(int major) {
		this.major = major;
	}
	public int getMinor() {
		return minor;
	}
	public void setMinor(int minor) {
		this.minor = minor;
	}
	public int getRev() {
		return rev;
	}
	public void setRev(int rev) {
		this.rev = rev;
	}

}
