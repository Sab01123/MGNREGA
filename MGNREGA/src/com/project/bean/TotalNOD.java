package com.project.bean;

public class TotalNOD {

	private int NOD;
	private int wedges;
	private String empName;
	private String proName;
	
	public TotalNOD() {
		
	}

	public TotalNOD(int nOD, int wedges, String empName, String proName) {
		super();
		NOD = nOD;
		this.wedges = wedges;
		this.empName = empName;
		this.proName = proName;
	}

	public int getNOD() {
		return NOD;
	}

	public void setNOD(int nOD) {
		NOD = nOD;
	}

	public int getWedges() {
		return wedges;
	}

	public void setWedges(int wedges) {
		this.wedges = wedges;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	@Override
	public String toString() {
		return "TotalNOD [NOD=" + NOD + ", wedges=" + wedges + ", empName=" + empName + ", proName=" + proName + "]";
	}
	
	
}
