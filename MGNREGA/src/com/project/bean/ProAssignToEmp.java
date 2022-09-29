package com.project.bean;

public class ProAssignToEmp {

	private int proAEId;
	private int empAId;
	
	public ProAssignToEmp() {
		// TODO Auto-generated constructor stub
	}

	public ProAssignToEmp(int proAEId, int empAId) {
		super();
		this.proAEId = proAEId;
		this.empAId = empAId;
	}

	public int getProAEId() {
		return proAEId;
	}

	public void setProAEId(int proAEId) {
		this.proAEId = proAEId;
	}

	public int getEmpAId() {
		return empAId;
	}

	public void setEmpAId(int empAId) {
		this.empAId = empAId;
	}

	@Override
	public String toString() {
		return "ProAssignToEmp [proAEId=" + proAEId + ", empAId=" + empAId + "]";
	}
	
}
