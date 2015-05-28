package com.iprosonic.cmms.modules.job.transactions.job.service;


import java.sql.Connection; 
import java.sql.DriverManager;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class DatabaseConnection {
	private static Connection con = null;
	public static Connection getConnection() {
		String driver = null;
		String url = null;
		String user = null;
		String password = null;
		
		ResourceBundle rb = ResourceBundle.getBundle("com.iprosonic.cmms.modules.job.transactions.job.service.mysqlconninfo");
		driver = rb.getString("driver");
		url = rb.getString("urlstring");
		user = rb.getString("user");
		password = rb.getString("password");
		

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return con;

	}

}
