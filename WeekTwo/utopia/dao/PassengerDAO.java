package com.arden.utopia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.arden.utopia.entity.Passenger;


public class PassengerDAO extends BaseDAO {
	
	public void viewPassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		PreparedStatement sttmnt = getConnection().prepareStatement("select passenger.id,passenger.given_name,passenger.family_name,passenger.dob,passenger.gender,passenger.address,booking.confirmation_code from passenger join booking on passenger.booking_id = booking.id where passenger.id= ?");
		sttmnt.setInt(1, passenger.getId());
		ResultSet rs = sttmnt.executeQuery();
		if(!rs.next()) {
			System.out.println("Sorry, that passenger ID is invalid.");
		} else {
			System.out.println("Passenger ID: " + rs.getInt("passenger.id") + ": " + rs.getString("passenger.given_name") + " " + rs.getString("passenger.family_name") + "\nDOB: " + rs.getDate("passenger.dob") + "\nAddress: " + rs.getString("passenger.address"));
			System.out.println("Confirmation code: " + rs.getInt("booking.confirmation_code"));
		}
	}
	
	public void getPrimaryId(Passenger passenger) throws SQLException, ClassNotFoundException {
		PreparedStatement sttmnt = getConnection().prepareStatement("select id from passenger where booking_id=?");
		sttmnt.setInt(1, passenger.getBookingId());
		ResultSet rs = sttmnt.executeQuery();
		while(rs.next()) {
			passenger.setId(rs.getInt("id"));
		}
	}
	
	public Integer addPassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		return saveWithPrimary("insert into passenger (booking_id, given_name, family_name, dob, gender, address) values (?, ?, ?, ?, ?, ?)", new Object[] {passenger.getBookingId(), passenger.getGivenName(), passenger.getFamilyName(), passenger.getDob(), passenger.getGender(), passenger.getAddress()});	
	}
	
	public List<Passenger> viewAllPassengers() throws ClassNotFoundException, SQLException {
		List<Passenger> passengers = new ArrayList<>();
		PreparedStatement sttmnt = getConnection().prepareStatement("select * from passenger");
		Scanner scan = new Scanner(System.in);
		ResultSet rs = sttmnt.executeQuery();
		while(rs.next()) {
			System.out.println("Passenger ID: " + rs.getInt("id") + ": " + rs.getString("given_name") + " " + rs.getString("family_name") + "\nDOB: " + rs.getDate("dob") + "\nAddress: " + rs.getString("address") + "\n");
		}
		scan.close();
		return passengers;
	}
	
	public void deletePassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		saveWithoutPrimary("delete from passenger where booking_id=?", new Object[] {passenger.getBookingId()});
	}
}
