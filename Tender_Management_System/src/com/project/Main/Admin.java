package com.project.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.project.Bean.Bidder;
import com.project.Bean.Tender;
import com.project.Bean.UserBean;
import com.project.Bean.Vendor;
import com.project.Dao.BidderDAO;
import com.project.Dao.BidderDaoImpl;
import com.project.Dao.TenderDaoImpl;
import com.project.Dao.VendorDaoImpl;
import com.project.Utility.DBUtil;



public class Admin extends UserBean{
	public Admin() {
		super();
	}

	public Admin(String username, String password) {
		super(username, password);
	}

	public boolean loginAdmin() {

		boolean loginStatus = false;

		try (Connection con=DBUtil.provideConnection()) {
			PreparedStatement ps = con.prepareStatement("select * from admin where username = ? AND password = ? ");

			ps.setString(1, this.getUsername());
			ps.setString(2, this.getPassword());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("============================================");
				System.out.println("Login Successful");
				System.out.println("============================================");
				loginStatus = true;
			} else {
				System.out.println("============================================");
				System.out.println("Login Denied! Invalid user Details");
				System.out.println("============================================");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return loginStatus;
	}

	public void registerVendor() {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter vender Username");
			String username = sc.nextLine();

			System.out.println("Enter vender Password");
			String password = sc.nextLine();

			String status = new VendorDaoImpl().registerVendor(new Vendor(username, password));

			System.out.println("============================================");
			System.out.println(status);
			System.out.println("============================================");

		} catch (InputMismatchException e) {
			System.out.println("Invalid Input");
		}

		
	}

	public void viewAllVendors() {

		List<Vendor> vendors = new VendorDaoImpl().getAllVendors();

		if (vendors.isEmpty()) {
			System.out.println("=========================");
			System.out.println("No Vendors Found");
			System.out.println("=========================");
		} else {

			System.out.println("=================================");
			int count = 1;
			for (int i = 0; i < vendors.size(); i++) {
				Vendor v = vendors.get(i);
				System.out.println(count + " Vendor Details:");
				System.out.println("*ID: " + v.getVid());
				System.out.println("*Name: " + v.getVname());
				System.out.println("*Email: " + v.getVemail());
				System.out.println("*Mobile: " + v.getVmob());
				System.out.println("*Address: " + v.getAddress());
				System.out.println("*Company: " + v.getCompany());
				System.out.println("=================================");

				count++;
			}
		}

	}

	public void viewAllTendors() {

		List<Tender> tenders = new TenderDaoImpl().getAllTenders();

		if (tenders.isEmpty()) {
			System.out.println("============================================");
			System.out.println("No Tenders Found");
			System.out.println("============================================");
		} else {

			System.out.println("============================================");
			int count = 1;
			for (int i = 0; i < tenders.size(); i++) {
				Tender t = tenders.get(i);
				System.out.println(count + " Tender Details:");
				System.out.println("*ID: " + t.getTid());
				System.out.println("*Title: " + t.getTname());
				System.out.println("*Price: " + t.getTprice());
				System.out.println("*Type: " + t.getTtype());
				System.out.println("*Description: " + t.getTdesc());
				System.out.println("*Status: " + t.getTstatus());
				System.out.println("=================================");

				count++;
			}
		}

	}

	public void createNewTender() {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter The Tender Details");

			Tender tender = new Tender();

			System.out.println("Enter Tender Title:");
			tender.setTname(sc.nextLine());

			System.out.println("Enter Tender Type: {new/old/additonal}");
			tender.setTtype(sc.nextLine());

			System.out.println("Enter Tender Price:");
			tender.setTprice(Integer.parseInt(sc.nextLine()));

			System.out.println("Enter Tender Description:");
			tender.setTdesc(sc.nextLine());

			tender.setTstatus("Not Assigned");

			String status = new TenderDaoImpl().createTender(tender);

			System.out.println("============================================");
			System.out.println(status);
			System.out.println("============================================");
		} catch (NumberFormatException e) {
			System.out.println("Invalid Input");
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input");
		}

	}

	public void getAllAssignedTenders() {

		List<Tender> tenders = new TenderDaoImpl().getAllAssignedTenders();

		if (tenders.isEmpty()) {
			System.out.println("============================================");
			System.out.println("No Tenders Found which are Assigned");
			System.out.println("============================================");
		} else {

			System.out.println("============================================");
			int count = 1;
			for (int i = 0; i < tenders.size(); i++) {
				Tender t = tenders.get(i);
				System.out.println(count + " Tender Details:");
				System.out.println("*ID: " + t.getTid());
				System.out.println("*Title: " + t.getTname());
				System.out.println("*Price: " + t.getTprice());
				System.out.println("*Type: " + t.getTtype());
				System.out.println("*Description: " + t.getTdesc());
				System.out.println("*Status: " + t.getTstatus());
				System.out.println("=================================");

				count++;
			}
		}
	}

	public void getAllBidsOfaTender() {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter Tender Id");
			int tid = Integer.parseInt(sc.nextLine());

			List<Bidder> bids = new BidderDaoImpl().getAllBidsOfaTender(tid);

			if (bids.isEmpty()) {
				System.out.println("============================================");
				System.out.println("No Bids Found");
				System.out.println("============================================");
			} else {
				int count = 1;
				for (int i = 0; i < bids.size(); i++) {
					Bidder b = bids.get(i);
					System.out.println(count + " Bids Details:");
					System.out.println("*Bid ID: " + b.getBid());
					System.out.println("*Tender ID: " + b.getTid());
					System.out.println("*Vendor ID: " + b.getVid());
					System.out.println("*Bid Amount: " + b.getBidAmount());
					System.out.println("*Bid Status: " + b.getStatus());
					System.out.println("=================================");

					count++;
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid Input");
		}

	}

	public void assignTender() {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter Tender Id");
			int tid = Integer.parseInt(sc.nextLine());

			BidderDAO bdao = new BidderDaoImpl();

			if (bdao.getAllBidsOfaTender(tid).isEmpty()) {
				System.out.println("============================================");
				System.out.println("No Bids Filed for tender Id: " + tid);
				System.out.println("============================================");
			} else {
				String status = bdao.acceptBid(tid);
				bdao.rejectBid(tid);

				System.out.println("===============================");
				System.out.println(status);
				System.out.println("===============================");
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid Input");
		}

	}


	public void updateTender() {

		Scanner sc = new Scanner(System.in);

		Tender tender = new Tender();

		int tid = -1;
		try {
			System.out.println("Enter Tender Id");
			tid = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}

		Tender t = new TenderDaoImpl().getTenderDataById(tid);

		if (t != null) {

			tender.setTid(tid);

			System.out.println("Existing Tender Details:");
			System.out.println("*ID: " + t.getTid());
			System.out.println("*Title: " + t.getTname());
			System.out.println("*Price: " + t.getTprice());
			System.out.println("*Type: " + t.getTtype());
			System.out.println("*Description: " + t.getTdesc());
			System.out.println("*Status: " + t.getTstatus());
			System.out.println("=================================");
		} else {
			System.out.println("============================================");
			System.out.println("No Tenders Found for Tender ID: " + tid);
			System.out.println("============================================");
			return;
		}

		try {
			System.out.println("Enter The Tender Updated Details");

			System.out.println("Enter Tender Title:");
			tender.setTname(sc.nextLine());

			System.out.println("Enter Tender Type: {new/old/additonal}");
			tender.setTtype(sc.nextLine());

			System.out.println("Enter Tender Price:");
			tender.setTprice(Integer.parseInt(sc.nextLine()));

			System.out.println("Enter Tender Description:");
			tender.setTdesc(sc.nextLine());

			System.out.println("Enter Tender Status:");
			tender.setTstatus(sc.nextLine());

			String status = new TenderDaoImpl().updateTender(tender);

			System.out.println("===============================");
			System.out.println(status);
			System.out.println("===============================");
		} catch (NumberFormatException e) {
			System.out.println("Invalid Input");
		}

	}

	public void getTenderDataById() {

		Scanner sc = new Scanner(System.in);

		int tid = -1;
		try {
			System.out.println("Enter Tender Id");
			tid = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}

		Tender t = new TenderDaoImpl().getTenderDataById(tid);

		if (t != null) {
			System.out.println(" Tender Details:");
			System.out.println("*ID: " + t.getTid());
			System.out.println("*Title: " + t.getTname());
			System.out.println("*Price: " + t.getTprice());
			System.out.println("*Type: " + t.getTtype());
			System.out.println("*Description: " + t.getTdesc());
			System.out.println("*Status: " + t.getTstatus());
			System.out.println("=================================");
		} else {
			System.out.println("============================================");
			System.out.println("No Tenders Found for Tender ID: " + tid);
			System.out.println("============================================");
		}

	}
}
