
package com.project.bean;

public class Employee {

	private int empId;
	private String empName;
	private String empAddress;

	
	public Employee() {
		// TODO Auto-generated constructor stub
	}


	public Employee(int empId, String empName, String empAddress) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + "]";
	}


	
	
	
}
