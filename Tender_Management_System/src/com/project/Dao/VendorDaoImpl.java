package com.project.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.project.Bean.Vendor;
import com.project.Utility.DBUtil;

public class VendorDaoImpl implements VendorDao {

	@Override
	public String registerVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		String status = "Registration Failed!";

	    try (Connection con = DBUtil.provideConnection()) {
	        // Check if vendor already exists
//	        PreparedStatement pst = con.prepareStatement("SELECT * FROM vendor WHERE vid=? AND vpassword = ?");
//	        pst.setString(1, vendor.getVid());
//	        pst.setString(2, vendor.getVpassword());
//
//	        ResultSet rs = pst.executeQuery();
//
//	        if (rs.next()) {
//	            status = "Registration Declined! Vendor Id already registered.";
//	        } else {
	            // Insert new vendor into table
	            PreparedStatement ps = con.prepareStatement("INSERT INTO vendor(vid, vpassword, vname, vmob, vemail, company, address) VALUES (?, ?, ?, ?, ?, ?, ?)");
	            ps.setString(1, vendor.getVid());
	            ps.setString(2, vendor.getVpassword());
	            ps.setString(3, vendor.getVname());
	            ps.setString(4, vendor.getVmob());
	            ps.setString(5, vendor.getVemail());
	            ps.setString(6, vendor.getCompany());
	            ps.setString(7, vendor.getAddress());

	            int k = ps.executeUpdate();

	            if (k > 0) {
	                status = "Registration Successful. \nYour Vendor id: " + vendor.getVid() + "\nThanks For Registration";
//	            }
	        }
	    } catch (SQLException e) {
	        status = "Error: " + e.getErrorCode() + " : " + e.getMessage();
	    }

	    return status;
	}

	@Override
	public List<Vendor> getAllVendors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validatePassword(String vendorId, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String updateProfile(Vendor vendor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changePassword(String vendorId, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vendor getVendorDataById(String vendorId) {
		// TODO Auto-generated method stub
		return null;
	}

}
