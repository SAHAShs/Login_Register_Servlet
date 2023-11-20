package com.Login_Register;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswordManager {
	Connection con;
	PreparedStatement pstmt;
	String querry="update `User` set `password`=? where `email`=?";
	public PasswordManager() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Login_Register", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	boolean passwordMatch(String password, String confirmPassword) {
		if(password.equals(confirmPassword)){
			return true;
		}
		return false;
	}
	
	boolean checkOld(String email,String password) {
		try {
			pstmt=con.prepareStatement("select * from User where email=?");
			pstmt.setString(1, email);
			String pass="";
			ResultSet res= pstmt.executeQuery();
			if(res.next()) {
				pass=(String)res.getString(4);
			}
			if(password.equals(pass)) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;	
	}
	
	boolean updatePassword(String email,String password) {
		try {
			pstmt=con.prepareStatement(querry);
			pstmt.setString(1, password);
			pstmt.setString(2, email);
			int res=pstmt.executeUpdate();
			System.out.println(res);
			if(res==1) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
