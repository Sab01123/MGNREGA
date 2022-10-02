package com.project.bean;

public class TOD2 {

	private int nOD;
	private int wedges;
	
	public TOD2() {
		// TODO Auto-generated constructor stub
	}



	
	public TOD2(int nOD, int wedges) {
		super();
		this.nOD = nOD;
		this.wedges = wedges;
	}




	public int getnOD() {
		return nOD;
	}




	public void setnOD(int nOD) {
		this.nOD = nOD;
	}




	public int getWedges() {
		return wedges;
	}




	public void setWedges(int wedges) {
		this.wedges = wedges;
	}




	@Override
	public String toString() {
		return "TOD2 [nOD=" + nOD + ", wedges=" + wedges + "]";
	}
}
