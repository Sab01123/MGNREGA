package com.project.bean;

public class EmployeeWedeges {
	
	
	
	private int empid;
	private String empName;
	private String empAddress;
	private int wedges;
	
	public EmployeeWedeges() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeWedeges(int empid, String empName, String empAddress, int wedges) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.empAddress = empAddress;
		this.wedges = wedges;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public int getWedges() {
		return wedges;
	}

	public void setWedges(int wedges) {
		this.wedges = wedges;
	}

	@Override
	public String toString() {
		return "EmployeeWedeges [empid=" + empid + ", empName=" + empName + ", empAddress=" + empAddress + ", wedges="
				+ wedges + "]";
	}
	
	
	

}
