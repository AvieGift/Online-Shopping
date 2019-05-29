package com.onlineshopping.conn;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		return OracleConnUtils.getOracleConnection();
	}

	public static void closeQuietly(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}

	public static void rollbakQuietly(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}
}
