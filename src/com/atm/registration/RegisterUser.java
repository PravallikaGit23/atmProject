package com.atm.registration;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.Scanner;

import com.atm.datasource.DbConnection;

public class RegisterUser {

	public static RegisterUser registerUser() {
		try {
			Connection con = DbConnection.getConnection();
			String queryReg = "{call regAccountATM(?,?,?,?,?,?,?,?,?)} ";
			CallableStatement cs = con.prepareCall(queryReg);
			cs.registerOutParameter(9, Types.INTEGER);

			Scanner s = new Scanner(System.in);

			System.out.println("ENTER Account Holder Name :");
			String AccountHolderName = s.nextLine();

			System.out.println("ENTER Account Number :");
			int AccountNo = Integer.parseInt(s.nextLine());

			System.out.println("ENTER Phone Number :");
			String phone = s.nextLine();

			System.out.println("please enter minimum deposit of 1000 INR :");
			double balance = s.nextDouble();
			s.nextLine();
			System.out.println("ENTER email :");
			String email = s.nextLine();

			System.out.println("ENTER Bank Name :");
			String bankName = s.nextLine();

			System.out.println("ENTER Branch Address:");
			String branchAddress = s.nextLine();

			System.out.println("ENTER password :");
			String Userpassword = s.nextLine();

			int i = 1;
//			cs.setString(i++, AccountHolderName);
			cs.setString(i++, AccountHolderName);
			cs.setLong(i++, AccountNo);
			cs.setString(i++, phone);
			cs.setDouble(i++, balance);
			cs.setString(i++, email);
			cs.setString(i++, bankName);
			cs.setString(i++, branchAddress);
			cs.setString(i++, Userpassword);
			cs.execute();
			
				System.out.println("Registered successfully");
			

		} catch (Exception e) {
			System.out.println("please enter the details accordingly....");
		}
		return null;
	}
}
