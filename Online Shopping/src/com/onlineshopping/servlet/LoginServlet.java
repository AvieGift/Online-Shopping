package com.onlineshopping.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineshopping.beans.CustomerDetails;
import com.onlineshopping.utils.DBUtils;
import com.onlineshopping.utils.MyUtils;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");

		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("passwordd");
		String rememberMeStr = request.getParameter("rememberMe");
		boolean remember = "Y".equals(rememberMeStr);

		CustomerDetails user = null;
		boolean hasError = false;
		String errorString = null;

		if (email == null || password == null || email.length() == 0 || password.length() == 0) {
			hasError = true;
			errorString = "Required email and password!";
		} else {
			Connection conn = MyUtils.getStoredConnection(request);
			try {
				user = DBUtils.findUser(conn, email, password);

				if (user == null) {
					hasError = true;
					errorString = "Email or Password invalid";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}
		}

		if (hasError) {
			user = new CustomerDetails();
			user.setEmail(email);
			user.setPassword(password);

			request.setAttribute("errorString", errorString);
			request.setAttribute("user", user);

			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("WEB-INF/views/loginView.jsp");

			dispatcher.forward(request, response);
		}

		else {
			HttpSession session = request.getSession();
			MyUtils.storeLoginedUser(session, user);

			if (remember) {
				MyUtils.storeUserCookie(response, user);
			}

			else {
				MyUtils.deleteUserCookie(response);
			}

			response.sendRedirect(request.getContextPath() + "/userInfo");
		}
	}
}
