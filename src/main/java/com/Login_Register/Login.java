package com.Login_Register;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
//	int chance=3;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		response.setContentType("text/html");
		UserValidate uv=new UserValidate();
		boolean result=uv.validUser(email,password);

		if(password==""||email=="") {
			String emsg="Please provide all fields required";
			request.setAttribute("errormsg", emsg);
			RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
		else if(result) {
			request.setAttribute("name", UserValidate.getName());
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			rd.include(request, response);
		}else {
			String emsg="Incorrect username or password";
			request.setAttribute("errormsg", emsg);
			RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
	}
}
