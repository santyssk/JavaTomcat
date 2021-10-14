package testapp;

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
		
		if(username == null || password == null) {
			//response.sendError(1,"Enter Credentials");
			response.sendRedirect("login.jsp");
		}
		else if(password.equals("123")) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("username", username);
			response.sendRedirect("home.jsp");
		}
		else {
			//response.sendError(2,"Invalid Credentials");
			response.sendRedirect("login.jsp");
		}
	}

}
