package com.arden.utopia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.arden.utopia.entity.Employee;

public class EmployeeDAO extends BaseDAO {

	public void getPrimaryId(Employee employee) throws SQLException, ClassNotFoundException {
		PreparedStatement sttmnt = getConnection().prepareStatement("select id from user where username = ?");
		sttmnt.setString(1, employee.getUsername());
		ResultSet rs = sttmnt.executeQuery();
		while(rs.next()) {
			employee.setId(rs.getInt("id"));
		}
	}
	
	public void viewEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		PreparedStatement sttmnt = getConnection().prepareStatement("select id,given_name,username,email,phone,family_name from user where id=?");
		sttmnt.setInt(1, employee.getId());
		ResultSet rs = sttmnt.executeQuery();
		while(rs.next()) {
			System.out.println("Employee ID: " + rs.getInt("id") + ": " + rs.getString("given_name") + " " + rs.getString("family_name") + "\nUsername: " + (rs.getString("username")) + "\nEmail: " + rs.getString("email") + "\nPhone number: " + rs.getString("phone"));	
		}
		
	}
	
	public Integer addEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		return saveWithPrimary("insert into user (role_id, given_name, family_name, username, email, password, phone) values (?, ?, ?, ?, ?, ?, ?)", new Object[] {employee.getRoleId(), employee.getFirstName(), employee.getLastName(), employee.getUsername(), employee.getEmail(), employee.getPassword(), employee.getPhoneNumber()});	
	}
	
	public List<Employee> viewAllEmployees() throws ClassNotFoundException, SQLException {
		List<Employee> employees = new ArrayList<>();
		PreparedStatement sttmnt = getConnection().prepareStatement("select * from user");
		ResultSet rs = sttmnt.executeQuery();
		while(rs.next()) {
			System.out.println("Employee ID: " + rs.getInt("id") + ": " + rs.getString("given_name") + " " + rs.getString("family_name") + "\nEmail: " + rs.getString("email") + "\nUsername: " + (rs.getString("username")) + "\nPhone number: " + rs.getString("phone") + "\n");
		}
		return employees;
	}
	
	public void deleteEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		saveWithoutPrimary("delete from employee where booking_id=?", new Object[] {employee.getId()});
	}
}
