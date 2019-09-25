package com.onlineshopping.utils;

import java.sql.Connection;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineshopping.beans.CustomerDetails;

public class MyUtils {

	public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
	public static final String ATT_NAME_EMAIL = "ATTRIBUTE_FOR_EMAIL_IN_CONNECTION";

	public static void storeConnection(ServletRequest request, Connection conn) {
		request.setAttribute(ATT_NAME_CONNECTION, conn);
	}

	public static Connection getStoredConnection(ServletRequest request) {
		Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
		return conn;
	}
	
	public static void storeLoginedUser(HttpSession session, CustomerDetails loginedUser) {
		session.setAttribute("signedUpUser", loginedUser);
	}

	public static CustomerDetails getLoginedUser(HttpSession session) {
		CustomerDetails loginedUser = (CustomerDetails) session.getAttribute("loginedUser");
		return loginedUser;
	}

	public static void storeSignedUpUser(HttpSession session, CustomerDetails signedUpUser) {
		session.setAttribute("signedUpUser", signedUpUser);
	}

	public static CustomerDetails getSignedUpUser(HttpSession session) {
		CustomerDetails signedUpUser = (CustomerDetails) session.getAttribute("signedUpUser");
		return signedUpUser;
	}

	public static void storeUserCookie(HttpServletResponse response, CustomerDetails user) {
		System.out.println("Store User cookie");
		Cookie cookieEmail = new Cookie(ATT_NAME_EMAIL, user.getEmail());
		cookieEmail.setMaxAge(24 * 60 * 60);
		response.addCookie(cookieEmail);
	}

	public static String getEmailInCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (ATT_NAME_EMAIL.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	public static void deleteUserCookie(HttpServletResponse response) {
		Cookie cookieEmail = new Cookie(ATT_NAME_EMAIL, null);
		cookieEmail.setMaxAge(0);
		response.addCookie(cookieEmail);
	}
}
