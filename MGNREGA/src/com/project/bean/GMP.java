
package com.project.bean;

public class GMP {

	private int gmpId;
	private String gmpName;
transient	private String gmpPassword;
	
public GMP() {
	// TODO Auto-generated constructor stub
}

public GMP(int gmpId, String gmpName, String gmpPassword) {
	super();
	this.gmpId = gmpId;
	this.gmpName = gmpName;
	this.gmpPassword = gmpPassword;
}

public int getGmpId() {
	return gmpId;
}

public void setGmpId(int gmpId) {
	this.gmpId = gmpId;
}

public String getGmpName() {
	return gmpName;
}

public void setGmpName(String gmpName) {
	this.gmpName = gmpName;
}

public String getGmpPassword() {
	return gmpPassword;
}

public void setGmpPassword(String gmpPassword) {
	this.gmpPassword = gmpPassword;
}

@Override
public String toString() {
	return "GMP [gmpId=" + gmpId + ", gmpName=" + gmpName + "]";
}	
}
