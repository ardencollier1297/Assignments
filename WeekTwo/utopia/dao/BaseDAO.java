package com.arden.utopia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class BaseDAO {

	public final String driver = "com.mysql.cj.jdbc.Driver";
	public final String url = "jdbc:mysql://localhost:3306/utopia";
	public final String user = "******";
	public final String pass = "********";
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		
		return DriverManager.getConnection(url, user, pass);
	}
	
	public Integer saveWithPrimary(String sql, Object[] vals) throws SQLException, ClassNotFoundException {
		PreparedStatement sttmnt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		int count = 1;
		for(Object o: vals) {
			sttmnt.setObject(count, o);
			count++;
		}
		sttmnt.execute();
		ResultSet rs = sttmnt.getGeneratedKeys();
		
		while(rs.next()) {
			return rs.getInt(1);
		}
		return null;
	}
	
	public void saveWithoutPrimary(String sql, Object[] vals) throws SQLException, ClassNotFoundException {
		PreparedStatement sttmnt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		int count = 1;
		for(Object o: vals) {
			sttmnt.setObject(count, o);
			count++;
		}
		sttmnt.execute();
	}
}
