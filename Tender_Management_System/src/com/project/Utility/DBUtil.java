package com.project.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		// Step 1: Load the JDBC driver
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println("JDBC driver not found");
//            e.printStackTrace();
//            return;
//        }
//        
//        Connection con = null;
//        try {
//            String url = "jdbc:mysql://localhost:3306/tendormanagementsystem";
//            String user = "root";
//            String password = "Abhi1999";
//            con = DriverManager.getConnection(url, user, password);
//            System.out.println("Connection successful");
//        } catch (SQLException e) {
//            System.out.println("Connection failed");
//            e.printStackTrace();
//            return;
//        }
//	}

	public static Connection provideConnection() {
		// TODO Auto-generated method stub
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url="jdbc:mysql://localhost:3306/tendorManagementSystem";
		try{
			con=DriverManager.getConnection(url,"root","Abhi1999");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
