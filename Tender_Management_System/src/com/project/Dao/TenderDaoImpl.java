package com.project.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Bean.Tender;
import com.project.Utility.DBUtil;

public class TenderDaoImpl implements TenderDao {

	@Override
	public List<Tender> getAllTenders() {
		// TODO Auto-generated method stub
	List<Tender> tenderList = new ArrayList<Tender>();
	
	try(Connection con=DBUtil.provideConnection()) {
		PreparedStatement ps = con.prepareStatement("select * from tender");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Tender tender = new Tender();
			tender.setTid(rs.getInt("tid"));
			tender.setTname(rs.getString("tname"));
			tender.setTtype(rs.getString("ttype"));
			tender.setTprice(rs.getInt("tprice"));
			tender.setTdesc(rs.getString("tdesc"));
			tender.setTstatus(rs.getString("tstatus"));
			tenderList.add(tender);
		}
	
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	return tenderList;
	}

	@Override
	public String createTender(Tender tender) {
		// TODO Auto-generated method stub
		String status = "Tender Addition Failed!";

		try (Connection con=DBUtil.provideConnection()) {
			PreparedStatement ps = con.prepareStatement("select * from tender where tname=? AND ttype=? AND tprice=? AND tdesc=?");

			ps.setString(1, tender.getTname());
			ps.setString(2, tender.getTtype());
			ps.setInt(3, tender.getTprice());
			ps.setString(4, tender.getTdesc());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				status = "Tender Declined! \nTender already Exists with ID: " + rs.getInt("tid");
			} else {
				try {
					PreparedStatement pst = con.prepareStatement("insert into tender(tname,ttype,tprice,tdesc,tstatus) values(?,?,?,?,?)");
	
					pst.setString(1, tender.getTname());
					pst.setString(2, tender.getTtype());
					pst.setInt(3, tender.getTprice());
					pst.setString(4, tender.getTdesc());
					pst.setString(5, tender.getTstatus());

					int x = pst.executeUpdate();
					if (x > 0)
						status = "New Tender Inserted \nYour Tender ID: " + getTenderId(tender);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public String updateTender(Tender tender) {
		// TODO Auto-generated method stub
		String status = "Tender Updation Failed...";

		try (Connection con=DBUtil.provideConnection()) {
			PreparedStatement pst = con.prepareStatement(
					"UPDATE tender SET tname=?,ttype=?,tprice=?,tdesc=?, tstatus=? where tid=?");

			pst.setString(1, tender.getTname());
			pst.setString(2, tender.getTtype());
			pst.setInt(3, tender.getTprice());
			pst.setString(4, tender.getTdesc());
			pst.setString(5, tender.getTstatus());
			
			pst.setInt(6, tender.getTid());
			
			int x = pst.executeUpdate();
			if (x > 0)
				status = "Tender Details Updated...";

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public Tender getTenderDataById(int tid) {
		// TODO Auto-generated method stub
		Tender tender = null;

		try (Connection con=DBUtil.provideConnection()){

			PreparedStatement ps = con.prepareStatement("select * from tender where tid=?");

			ps.setInt(1, tid);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String type = rs.getString(3);
				int price = rs.getInt(4);
				String desc = rs.getString(5);
				String status = rs.getString(6);

				tender = new Tender(id, name, type, price, desc, status);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tender;
	}

	@Override
	public String getTenderStatus(int tenderId) {
		// TODO Auto-generated method stub
		String status = "Not Assigned";

		try (Connection con=DBUtil.provideConnection()){
			PreparedStatement ps = con.prepareStatement("select * from tender where tid=?");

			ps.setInt(1, tenderId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				status = rs.getString("tstatus");
			} else {
				status = "Tendor Id Not Found: " + tenderId;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return status;
	}

	@Override
	public String assignTender(int tenderId) {
		// TODO Auto-generated method stub
		String status = "Tender Assigning failed";

		try (Connection con=DBUtil.provideConnection()) {
			PreparedStatement ps = con.prepareStatement("update tender set tstatus='Assigned' where tid=?");
			ps.setInt(1, tenderId);

			int k = ps.executeUpdate();
			if (k > 0) {
				status = "Tender: " + tenderId + " has been Assigned";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public List<Tender> getAllAssignedTenders() {
		// TODO Auto-generated method stub
		List<Tender> statusList = new ArrayList<Tender>();

		try (Connection con=DBUtil.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from tender where tstatus='Assigned'");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Tender tender = new Tender();

				tender.setTid(rs.getInt("tid"));
				tender.setTname(rs.getString("tname"));
				tender.setTtype(rs.getString("ttype"));
				tender.setTprice(rs.getInt("tprice"));
				tender.setTdesc(rs.getString("tdesc"));
				tender.setTstatus(rs.getString("tstatus"));

				statusList.add(tender);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}


		return statusList;
	}

	@Override
	public int getTenderId(Tender tender) {
		// TODO Auto-generated method stub
		int tid = -1;

		try (Connection con=DBUtil.provideConnection()){
			PreparedStatement ps = con.prepareStatement("select * from tender where tname=? AND ttype=? AND tprice=? AND tdesc=?");

			ps.setString(1, tender.getTname());
			ps.setString(2, tender.getTtype());
			ps.setInt(3, tender.getTprice());
			ps.setString(4, tender.getTdesc());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				tid = rs.getInt("tid");
			} 

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return tid;
	}

	

}
