package com.masai.usecase;

import java.util.*;

import com.masai.bean.*;
import com.masai.dao.*;
import com.masai.exception.*;

public class AdministratorUsecase {
	
	public boolean LogInAdmin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------");
		System.out.println("Enter the ID here:-");
		String id = sc.nextLine();
		System.out.println("Enter the Password here:-");
		String password = sc.nextLine();
		
		AdministratorDao ad = new AdministratorDaoImp(); 
		try {
			AdministratorBean admin = ad.logInAdmin(id, password);
			System.out.println();
			System.out.println();
			System.out.println("Welcome, "+admin.getName()+"!");
			return true;
		} catch (Exception e) {
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	
	
	public void RegisterVendor() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------");
		System.out.println("Enter Id: ");
		String id = sc.nextLine();
		System.out.println("Enter Password");
		String password = sc.nextLine();
		System.out.println("Enter Name:");
		String name = sc.nextLine();
		System.out.println("Enter Email:");
		String email = sc.nextLine();
		System.out.println("Enter Address:");
		String address = sc.nextLine();
		
		AdministratorDao dao = new AdministratorDaoImp();
		
		try {
			String result = dao.registerVendor(id, password, name, email, address);
			System.out.println();
			System.out.println(result);
			System.out.println();
		} catch (VendorException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}

	
	
	
	public void ViewAllVendor() {
		AdministratorDao dao = new AdministratorDaoImp();
		
		System.out.println("--------------------------------");
		try {
			List<VendorBean> vendors = dao.viewAllVendor();
			System.out.println();
			System.out.println();
			vendors.forEach(v -> System.out.println(v));
		} catch (VendorException e) {
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	public void CreateTender() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------");
		System.out.println("Enter a id here (format : TRXXXX):-");
		String id = sc.next();
		System.out.println("Enter a name here:-");
		String name = sc.nextLine();
		System.out.println("Enter a type here:-");
		String type = sc.nextLine();
		System.out.println("Enter a price here:-");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter a location here:-");
		String location = sc.nextLine();
		
		
		AdministratorDao dao = new AdministratorDaoImp();
		
		try {
			String result = dao.createTender(id, name, type, price, location);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println(result);
		} catch (TenderException e) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
		}
	}

	
	
	
	
	public void ViewAllTender() {
		AdministratorDao dao = new AdministratorDaoImp();
		System.out.println("--------------------------------");
		try {
			List<TenderBean> vendors = dao.viewAllTender();
			System.out.println();
			System.out.println();
			System.out.println();
			vendors.forEach(v -> System.out.println(v));
		} catch (TenderException e) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	public void ViewAllBidsOfTender() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------");
		System.out.println("Enter the tender ID here (format : TRXXXX):-");
		String tid = sc.nextLine();
		AdministratorDao dao = new AdministratorDaoImp();
		try {
			List<BidderBean> bidders = dao.viewAllBidsOfTender(tid);
			System.out.println();
			System.out.println();
			System.out.println();
			bidders.forEach(b -> System.out.println(b));
			
		} catch (BidderException e) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	public void AssignTenderToVendor() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------");
		System.out.println("Enter the Vendor ID here (format : VRXXXX):-");
		String vid = sc.nextLine();
		System.out.println("Enter the Tender ID here (format : TRXXXX):-");
		String tid = sc.nextLine();
//		System.out.println("Enter the tender amount:");
//	    int tenderAmount = sc.nextInt();
//	    System.out.println("Enter the bidder amount:");
//	    int bidderAmount = sc.nextInt();

		
		AdministratorDao dao = new AdministratorDaoImp();
		
		try {
			String result = dao.assignTenderToVendor(vid, tid);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println(result);
		} catch (BidderException e) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
		}
	}
	
}
