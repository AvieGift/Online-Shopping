package com.onlineshopping.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlineshopping.beans.CustomerDetails;
import com.onlineshopping.beans.Product;

public class DBUtils {

	public static CustomerDetails findUser(Connection conn, String email, String password) throws SQLException {

		String sql = "Select a.Email, a.Password from Customer_Details a" + "where a.Email =? and a.password =?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, email);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			CustomerDetails user = new CustomerDetails();
			user.setEmail(email);
			user.setPassword(password);
			return user;
		}
		return null;
	}

	public static CustomerDetails findUser(Connection conn, String email) throws SQLException {

		String sql = "Select a.Email, a.Password from Customer_Details a" + "where a.Email =?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, email);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String password = rs.getString("Password");
			CustomerDetails user = new CustomerDetails();
			user.setEmail(email);
			user.setPassword(password);

			return user;
		}
		return null;
	}

	public static List<Product> queryProduct(Connection conn) throws SQLException {
		String sql = "Select a.Code, a.Name, a.Amount from Product a";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			String code = rs.getString("Code");
			String name = rs.getString("Name");
			float amount = rs.getFloat("Amount");
			Product product = new Product();
			product.setCode(code);
			product.setName(name);
			product.setAmount(amount);
			list.add(product);
		}
		return list;

	}

	public static Product findProduct(Connection conn, String code) throws SQLException {
		String sql = "Select a.Code, a.Name, a.Amount from Product a where a.Code=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, code);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String name = rs.getString("Name");
			float amount = rs.getFloat("Amount");
			Product product = new Product(code, name, amount);
			return product;
		}
		return null;

	}

	public static void deleteProduct(Connection conn, String code) throws SQLException {
		String sql = "Delete From Product where Code= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, code);

		pstm.executeUpdate();
	}

}
