package com.Login_Register;

import java.io.IOException;
//import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class register
 */
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public register() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("fullName");
		String password = request.getParameter("password");
		String number = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		response.setContentType("text/html");
		UserValidate uv = new UserValidate();
		if (name == "" || password == "" || email == "") {
			String emsg = "Please provide all fields required";
			request.setAttribute("errormsg", emsg);
			RequestDispatcher ed = request.getRequestDispatcher("register.jsp");
			ed.include(request, response);
		} else if (!uv.validUser(email)) {
			User u = new User(name, password, number, email);
			UserReg ur = new UserReg();
			boolean save = ur.saveUser(u);
			if (save) {
				String emsg = "Registered Successfully Please Login";
				request.setAttribute("errormsg", emsg);
				RequestDispatcher ed = request.getRequestDispatcher("index.jsp");
				ed.include(request, response);
			}
		} else {
			String emsg = "User found please Login";
			request.setAttribute("errormsg", emsg);
			RequestDispatcher ed = request.getRequestDispatcher("index.jsp");
			ed.include(request, response);
		}
	}
}
