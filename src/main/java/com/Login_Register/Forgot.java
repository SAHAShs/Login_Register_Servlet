package com.Login_Register;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Forgot
 */
public class Forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pstmt;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Forgot() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String querry = "Select * from User where email=?";
		if (email == "") {
			String emsg = "please provide required fields";
			request.setAttribute("errormsg", emsg);
			RequestDispatcher rd = request.getRequestDispatcher("forgot1.jsp");
			rd.include(request, response);
		} else {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login_Register", "root", "root");
				pstmt = con.prepareStatement(querry);
				pstmt.setString(1, email);
				ResultSet res = pstmt.executeQuery();
				if (res.next()) {
					request.setAttribute("e", email);
					RequestDispatcher rd = request.getRequestDispatcher("forgot2.jsp");
					rd.include(request, response);
				} else {
					String emsg = "Incorrect username";
					request.setAttribute("errormsg", emsg);
					RequestDispatcher rd = request.getRequestDispatcher("forgot1.jsp");
					rd.include(request, response);
				}

			} catch (SQLException | ClassNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null) {
						pstmt.close();
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				try {
					if (con != null) {
						con.close();
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}
}
