package com.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.Impl.Implementation;

@WebServlet(name="login" , urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("LoginServlet called");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println("Username = "+username );
		System.out.println("password = "+password );
		
		Implementation loginDetails = new Implementation();
		Boolean isPresent = loginDetails.isPresent(username, password);
		
		if(isPresent) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/home.html");
			dispatcher.forward(req, resp); 
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/error.html");
			dispatcher.forward(req, resp); 
		}
		
	}

	
	
}
