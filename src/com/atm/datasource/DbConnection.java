package com.atm.datasource;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	public static Connection con = null;
	static String url = "jdbc:mysql://localhost:3306/atm_ui?useSSL=false";
	static String uname = "root";
	static String upass = "root";

	public static Connection getConnection() throws Exception {
		if (con != null) {
			return con;
		} else {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, uname, upass);
		}

		return con;
	}

}
