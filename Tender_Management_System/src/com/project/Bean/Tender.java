package com.project.Bean;

public class Tender {

	private int tid;
	private String tname;
	private String ttype;
	private int tprice;
	private String tdesc;
	private String tstatus;

	public Tender() {
		super();
	}

	public Tender(int tid, String tname, String ttype, int tprice, String tdesc, String tstatus) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.ttype = ttype;
		this.tprice = tprice;
		this.tdesc = tdesc;
		this.tstatus = tstatus;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTtype() {
		return ttype;
	}

	public void setTtype(String ttype) {
		this.ttype = ttype;
	}

	public int getTprice() {
		return tprice;
	}

	public void setTprice(int tprice) {
		this.tprice = tprice;
	}

	public String getTdesc() {
		return tdesc;
	}

	public void setTdesc(String tdesc) {
		this.tdesc = tdesc;
	}

	public String getTstatus() {
		return tstatus;
	}

	public void setTstatus(String tstatus) {
		this.tstatus = tstatus;
	}

	@Override
	public String toString() {
		return "Tender [tid=" + tid + ", tname=" + tname + ", ttype=" + ttype + ", tprice=" + tprice + ", tdesc="
				+ tdesc + ", tstatus=" + tstatus + "]";
	}

}