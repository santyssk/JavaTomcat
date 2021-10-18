package com.groupTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username == null || password == null || username.length() == 0) {
			request.setAttribute("errorMessage", "Enter Credentials");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else if(password.equals("123")) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("username", username);
			response.sendRedirect("home.jsp");
		}
		else {
			request.setAttribute("errorMessage", "Invalid Credentials");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
