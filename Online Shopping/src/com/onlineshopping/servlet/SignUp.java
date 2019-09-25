package com.onlineshopping.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineshopping.beans.CustomerDetails;
import com.onlineshopping.utils.MyUtils;

@WebServlet("/signUp")
public class SignUp extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SignUp() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("WEB-INF/views/signupView");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		String firstName = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");
		String Email = request.getParameter("Email Address");
		String Password = request.getParameter("Password");
		String confirmPassword = request.getParameter("Confirm Password");

		CustomerDetails user = null;
		boolean hasError = false;
		String errorString = null;

		if (firstName == null || firstName.length() == 0) {
			hasError = true;
			errorString = "Required FirstName!";
		}
		
		if (lastName == null || lastName.length() == 0) {
			hasError = true;
			errorString = "Required LastName!";
		}
		
		if (Email == null || Email.length() == 0) {
			hasError = true;
			errorString = "Required Email Address!";
		}
		if (Password == null || Password.length() == 0) {
			hasError = true;
			errorString = "Required Password!";
		}
		if (confirmPassword == null || confirmPassword.length() == 0) {
			hasError = true;
			errorString = "Required Confirm Password!";
		}

		if (hasError) {
			user = new CustomerDetails();
			user.setEmail(Email);
			user.setPassword(Password);
			user.setConfirmPassword(confirmPassword);
			
			request.setAttribute("errorString", errorString);
			request.setAttribute("user", user);
			
			RequestDispatcher dispatcher= this.getServletContext().getRequestDispatcher("WEB-INF/views/signupView");
			dispatcher.forward(request, response);
		}
		
		else {
			HttpSession session = request.getSession();
			MyUtils.storeSignedUpUser(session, user);
			
			response.sendRedirect(request.getContextPath()+ "/UserInfo");
		}
	}
	

}