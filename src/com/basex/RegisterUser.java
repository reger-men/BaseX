package com.basex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.basex.examples.api.CreateExample;

public class RegisterUser extends HttpServlet { 
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("password");
		String address = request.getParameter("address");
		
		//check input
		if(username.isEmpty() ||password.isEmpty() || email.isEmpty() || address.isEmpty()){
			JOptionPane.showMessageDialog(null, "Sorry, the member name you entered couldn't be empty. Please try again", "Register: " + "Register error", JOptionPane.ERROR_MESSAGE);
		}else{
		
		
			HttpSession session = null;
			RequestDispatcher dispatcher = null;
			CreateExample db = new CreateExample();
				
			
			if (db.insertUser(username,email,password,address) == false){
				dispatcher = request.getRequestDispatcher("failure.jsp");
				JOptionPane.showMessageDialog(null, "Sorry, the member name you entered already exists. Please try again", "Register: " + "Register error", JOptionPane.ERROR_MESSAGE);
			}else{
				session = request.getSession();
				session.setAttribute("username", username);
				dispatcher = request.getRequestDispatcher("welcome.jsp");
			}
				
			dispatcher.forward(request, response);
		}

	}

}