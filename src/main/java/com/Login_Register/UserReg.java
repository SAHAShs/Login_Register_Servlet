package com.Login_Register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserReg {
	private static final String url="jdbc:mysql://localhost:3306/Login_Register";
	private static final String uname="root";
	private static final String password="root";
	private Connection con;
	private PreparedStatement pstmt;
	private static final String querry="insert into `User`(name,email,number,password) values(?,?,?,?)";
	
	public UserReg() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,uname,password);
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	boolean saveUser(User e) {
		try {
			pstmt=con.prepareStatement(querry);
			pstmt.setString(1,e.getName());
			pstmt.setString(2, e.getEmail());
			pstmt.setString(3, e.getNumber());
			pstmt.setString(4, e.getPassword());
			int i=pstmt.executeUpdate();
			return i>0;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}
}
