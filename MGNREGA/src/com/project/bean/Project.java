package com.project.bean;

public class Project {
	
	private int proId;
	private String proName;
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(int proId, String proName) {
		super();
		this.proId = proId;
		this.proName = proName;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	@Override
	public String toString() {
		return "Project [proId=" + proId + ", proName=" + proName + "]";
	}
	
	

}
