package com.project.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.project.Bean.Bidder;
import com.project.Utility.DBUtil;


public class BidderDaoImpl implements BidderDAO {

	@Override
	public String acceptBid(int tenderId) {
		// TODO Auto-generated method stub
		String status = "Bid Assignment Failed";

		try(Connection con=DBUtil.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from tender where tid=? AND tstatus='Assigned'");
			ps.setInt(1, tenderId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = "Tender Already Assigned";
			} else {
				
				Bidder bid = bestBids(tenderId);
				
				if(bid==null) {
					status = "No Bids for the Tendor is Found";
				}else {
					PreparedStatement pst = con.prepareStatement("update bidder set status = ? where bid=? and status=?");

					pst.setString(1, "Accepted");
					pst.setInt(2, bid.getBid());
					pst.setString(3, "Pending");

					int x = pst.executeUpdate();
					if (x > 0) {
						status = "Bid Has Been Accepted Successfully!";
						TenderDao dao = new TenderDaoImpl();
						status = status + "\n" + dao.assignTender(tenderId);
					}
				}
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String rejectBid(int tendorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String bidTender(Bidder bidder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bidder> getAllBidsOfaTender(int tenderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bidder> getAllBidsOfaVendor(String vendorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStatusOfABid(int tid, String vendorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bidder bestBids(int tendorId) {
		// TODO Auto-generated method stub
		return null;
	}

}
