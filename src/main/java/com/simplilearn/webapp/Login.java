package com.simplilearn.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		// response.sendRedirect("login.html");
		request.getRequestDispatcher("index.jsp").include(request, response);
		request.getRequestDispatcher("login.html").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// request params
		String userEmail = request.getParameter("useremail");
		String userPassword = request.getParameter("password");
		
		request.getRequestDispatcher("index.jsp").include(request, response);
		request.getRequestDispatcher("login.html").include(request, response);
		
		if(userEmail.equals("") && userPassword.equals("")) {
			out.println("<h2 style='color:red'>Login Failed  * Required filled are missing! </h2>");
		} else {
			if(userEmail.equals("admin@gmail.com") && userPassword.equals("admin@123")) {
				out.println("<h2 style='color:green'>Login sucessfull ! for user '"+userEmail+"' </h2>");
			} else {
				out.println("<h2 style='color:red'>Login Failed * Invalid credntials </h2>");
			}
		}
	}

}
