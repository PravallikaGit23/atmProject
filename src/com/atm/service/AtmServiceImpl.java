package com.atm.service;

import java.sql.Connection;
import java.sql.Statement;

import com.atm.datasource.DbConnection;

public class AtmServiceImpl implements AtmService {

	@Override
	public int withDrawl(int accNo, double withdrawlAmount) {
		int result = 0;

		try {
			Connection con = DbConnection.getConnection();
			Statement st = con.createStatement();
			result = st.executeUpdate("update  accountHolders set balance = balance -'" + withdrawlAmount
					+ "' where AccountNo = '" + accNo + "'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int deposit(int accNo, double deposit) {
		int result = 0;
		try {
			Connection con = DbConnection.getConnection();
			Statement st = con.createStatement();
			result = st.executeUpdate(
					"update  accountHolders set balance= balance+'" + deposit + "'  where AccountNo = '" + accNo + "'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
