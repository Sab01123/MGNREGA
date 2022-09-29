package com.project.bean;

public class GMPPRO {
	
	private int proAId;
	private int gmpAId;
	
	public GMPPRO() {
		// TODO Auto-generated constructor stub
	}

	public GMPPRO(int proAId, int gmpAId) {
		super();
		this.proAId = proAId;
		this.gmpAId = gmpAId;
	}

	public int getProAId() {
		return proAId;
	}

	public void setProAId(int proAId) {
		this.proAId = proAId;
	}

	public int getGmpAId() {
		return gmpAId;
	}

	public void setGmpAId(int gmpAId) {
		this.gmpAId = gmpAId;
	}

	@Override
	public String toString() {
		return "GMPPRO [proAId=" + proAId + ", gmpAId=" + gmpAId + "]";
	}
	
	

}
