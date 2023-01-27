package com.atm.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.atm.datasource.DbConnection;
import com.atm.dto.LoginDTO;
import com.atm.dto.UserDTO;

public class LoginService {
	public static UserDTO authenticateUser(LoginDTO loginDTO) {
		UserDTO  user = new UserDTO();
		try {
			Connection con = DbConnection.getConnection();
			Statement st = con.createStatement();
			String sql = "select * from accountHolders where AccountHolderName= '" + loginDTO.getUserName()
					+ "' and Userpassword='" + loginDTO.getPassWord() + "' ";
			ResultSet rs = st.executeQuery(sql);
			
			if (rs.next()) {
				user.setUserName(rs.getString(2));
				user.setAccNumber(rs.getInt(3));
				user.setPhone(rs.getString(4));
				user.setAccBalance(rs.getDouble(5));
				user.setEmail(rs.getString(6));
				user.setBankName(rs.getString(7));
				user.setBankAddress(rs.getString(8));
				user.setPassWord(rs.getString(9));
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		return user;
	}
	
	
}
