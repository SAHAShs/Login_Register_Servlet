package com.Login_Register;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserValidate {
	private static String name=""; 
	private Connection con;
	private PreparedStatement pstmt;
	private static String RegQuerry="select * from User where email=?";
	private static String LogQuerry="select * from User where email=?";
	public UserValidate() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Login_Register", "root", "root");
		}catch (SQLException |ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	boolean validUser(String email, String password) {
		try {
			pstmt=con.prepareStatement(LogQuerry);
			pstmt.setString(1, email);
			ResultSet res=pstmt.executeQuery();
			
			if(res.next()) {
				setName(res.getString(1));
				String actpas=res.getString(4);
				if(password.equals(actpas)) {
					return true;
				}else {
					return false;
				}
				
			}else {
				return false;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			try {
				if(con!=null) {
					con.close();
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}
		return false;
		
	}

	boolean validUser(String email) {
		try {
			pstmt=con.prepareStatement(RegQuerry);
			pstmt.setString(1, email);
			ResultSet res=pstmt.executeQuery();
			if(res.next()) {
				return true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			try {
				if(con!=null) {
					con.close();
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}
		return false;
		
		
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		UserValidate.name = name;
	}

}
