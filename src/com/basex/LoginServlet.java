package com.basex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.basex.examples.api.*;

import javax.swing.JOptionPane;


public class LoginServlet extends HttpServlet { 
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = null;
		RequestDispatcher dispatcher = null;
		CreateExample db = new CreateExample();
		//db.insertUser(username, "", password, "");
		
		if (db.validateUser(username,  password) == false){
			dispatcher = request.getRequestDispatcher("failure.jsp");
			JOptionPane.showMessageDialog(null, "Sorry, the member name and password you entered do not match. Please try again", "InfoBox: " + "Login error", JOptionPane.ERROR_MESSAGE);
		}else{
			session = request.getSession();
			session.setAttribute("username", username);
			dispatcher = request.getRequestDispatcher("welcome.jsp");
		}

		dispatcher.forward(request, response);

	}

}