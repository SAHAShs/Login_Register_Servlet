package com.Login_Register;

import java.io.IOException;
//import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Reset
 */
public class Reset extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Reset() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String email = (String) request.getParameter("email");
		String pass = (String) request.getParameter("password");
		String cnfpass = (String) request.getParameter("cnfpassword");
		if (pass == "" || cnfpass == "") {
			String emsg = "Please provide required fields";
			request.setAttribute("errormsg", emsg);
			RequestDispatcher rd = request.getRequestDispatcher("forgot2.jsp");
			rd.include(request, response);
		} else {
			PasswordManager psw = new PasswordManager();
			boolean matchpass = psw.passwordMatch(pass, cnfpass);
			boolean checkold = psw.checkOld(email, pass);
			if (!matchpass) {
				String emsg = "Password and confirm password must match";
				request.setAttribute("errormsg", emsg);
				request.setAttribute("e", email);
				RequestDispatcher rd = request.getRequestDispatcher("forgot2.jsp");
				rd.include(request, response);
			} else if (matchpass && !checkold) {
				boolean updatepassword = psw.updatePassword(email, cnfpass);
				if (updatepassword) {
					String emsg = "password resetted successfully";
					request.setAttribute("errormsg", emsg);
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.include(request, response);
				} else {
					String emsg = "server error Try Again later";
					request.setAttribute("errormsg", emsg);
					request.setAttribute("e", email);
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.include(request, response);
				}
			} else if (checkold) {
				String emsg = "similar to old password enter new password again";
				request.setAttribute("errormsg", emsg);
				request.setAttribute("e", email);
				RequestDispatcher rd = request.getRequestDispatcher("forgot2.jsp");
				rd.include(request, response);
			}
		}
	}
}
