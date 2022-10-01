package com.project.Dao;

public class EmployeeWedeges {
	
	
	
	private int empid;
	private String empNameString;
	private String empAddressString;
	private int wedges;
	public EmployeeWedeges(int empid, String empNameString, String empAddressString, int wedges) {
		super();
		this.empid = empid;
		this.empNameString = empNameString;
		this.empAddressString = empAddressString;
		this.wedges = wedges;
	}
	
	public EmployeeWedeges() {
		// TODO Auto-generated constructor stub
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpNameString() {
		return empNameString;
	}

	public void setEmpNameString(String empNameString) {
		this.empNameString = empNameString;
	}

	public String getEmpAddressString() {
		return empAddressString;
	}

	public void setEmpAddressString(String empAddressString) {
		this.empAddressString = empAddressString;
	}

	public int getWedges() {
		return wedges;
	}

	public void setWedges(int wedges) {
		this.wedges = wedges;
	}

	@Override
	public String toString() {
		return "EmployeeWedeges [empid=" + empid + ", empNameString=" + empNameString + ", empAddressString="
				+ empAddressString + ", wedges=" + wedges + "]";
	}
	
	
	
	
	

}
