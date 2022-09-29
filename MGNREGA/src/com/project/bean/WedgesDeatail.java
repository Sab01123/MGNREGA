package com.project.bean;

public class WedgesDeatail {

	private int wId;
	private int NOD;
	private int Wedges;
	
	public WedgesDeatail() {
		// TODO Auto-generated constructor stub
	}

	public WedgesDeatail(int wId, int nOD, int wedges) {
		super();
		this.wId = wId;
		NOD = nOD;
		Wedges = wedges;
	}

	public int getwId() {
		return wId;
	}

	public void setwId(int wId) {
		this.wId = wId;
	}

	public int getNOD() {
		return NOD;
	}

	public void setNOD(int nOD) {
		NOD = nOD;
	}

	public int getWedges() {
		return Wedges;
	}

	public void setWedges(int wedges) {
		Wedges = wedges;
	}

	@Override
	public String toString() {
		return "WedgesDeatail [wId=" + wId + ", NOD=" + NOD + ", Wedges=" + Wedges + "]";
	}
	
}
