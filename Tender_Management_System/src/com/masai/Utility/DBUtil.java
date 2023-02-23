package com.masai.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection provideConnection() {
		// TODO Auto-generated method stub
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url="jdbc:mysql://localhost:3306/tmsdb";
		try{
			con=DriverManager.getConnection(url,"root","Abhi1999");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
