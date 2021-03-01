package com.arden;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FixSingleton {

	// Weekend 1 Assignment 6
	private static Connection conn = null;
	private static FixSingleton instance = null;
	
	public static FixSingleton getInstance() {
		return instance;
	}
	
	// The error was that you can not simply multiply a BigDecimal by using "*"
	// The x was not needed, so I changed the code to use "BigDecimal.multiply" on the
	// input and rs - I also changed rs to ".getBigDecimal" rather than "getInt"
	public static void databaseQuery(BigDecimal input) throws SQLException {
		conn = DriverManager.getConnection("url of database");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select id from table");
		while(rs.next()) {
			input.multiply(rs.getBigDecimal(1));
		}
	}
}
