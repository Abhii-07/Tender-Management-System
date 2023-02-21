package com.project.Bean;

public class Vendor {

	private String vid;
	private String vpassword;
	private String vname;
	private String vemail;
	private String vmob;
	private String company;
	private String address;

	public Vendor() {
	}

	public Vendor(String vid, String vpassword) {
		this.vid = vid;
		this.vpassword = vpassword;
	}

	public Vendor(String vid, String vpassword, String vname, String vemail, String vmob, String company,
			String address) {
		this.vid = vid;
		this.vpassword = vpassword;
		this.vname = vname;
		this.vemail = vemail;
		this.vmob = vmob;
		this.company = company;
		this.address = address;
	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public String getVpassword() {
		return vpassword;
	}

	public void setVpassword(String vpassword) {
		this.vpassword = vpassword;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getVemail() {
		return vemail;
	}

	public void setVemail(String vemail) {
		this.vemail = vemail;
	}

	public String getVmob() {
		return vmob;
	}

	public void setVmob(String vmob) {
		this.vmob = vmob;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Vendor [vid=" + vid + ", vpassword=" + vpassword + ", vname=" + vname + ", vemail=" + vemail + ", vmob="
				+ vmob + ", company=" + company + ", address=" + address + "]";
	}

}
