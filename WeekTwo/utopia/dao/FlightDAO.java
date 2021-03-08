package com.arden.utopia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.arden.utopia.entity.Flight;
import com.arden.utopia.menus.FlightMenu;

public class FlightDAO extends BaseDAO {
	
	public void viewFlight(Flight flight) throws ClassNotFoundException, SQLException {
		PreparedStatement sttmnt = getConnection().prepareStatement("select flight.id,flight.departure_time,route.origin_id,route.destination_id from flight join route on flight.route_id = route.id where flight.id = ?");
		sttmnt.setInt(1, flight.getId());
		ResultSet rs = sttmnt.executeQuery();
		if(!rs.next()) {
			System.out.println("Sorry, that flight number is invalid.");
			FlightMenu.init();
		} else {
			System.out.println("Flight " + rs.getInt("id") + ": " + rs.getString("route.origin_id") + "->" + rs.getString("route.destination_id") + " at " + rs.getDate("departure_time"));
		}
	}
	
	public void viewAirports(Flight flight) throws ClassNotFoundException, SQLException {
		PreparedStatement sttmnt = getConnection().prepareStatement("select route.origin_id,route.destination_id from route join flight where flight.id = ?");
		sttmnt.setInt(1, flight.getId());
		ResultSet rs = sttmnt.executeQuery();
		while(rs.next()) {
			rs.getString("route.origin_id");
			rs.getString("route.destination_id");
		}
	}
	
	public void cancelFlight(Flight flight) throws ClassNotFoundException, SQLException {
		saveWithoutPrimary("delete from flight where id=?", new Object[] {flight.getId()});
	}
	
	public Integer addFlight(Flight flight) throws ClassNotFoundException, SQLException {
		return saveWithPrimary("insert into flight (id, route_id, airplane_id, departure_time, reserved_seats, seat_price) values (?, ?, ?, ?, ?, ?)", new Object[] {flight.getId(), flight.getRouteId(), flight.getAirplaneId(), flight.getDeparture(), flight.getReservedSeats(), flight.getSeatPrice()});
	}
	
	public void changeAirplaneId(Flight flight) throws ClassNotFoundException, SQLException {
		saveWithoutPrimary("update flight set airplane_id = ? where id = ?", new Object[] {flight.getAirplaneId(), flight.getId()});
	}
	
	public void changeSeatPrice(Flight flight) throws ClassNotFoundException, SQLException {
		saveWithoutPrimary("update flight set seat_price = ? where id = ?", new Object[] {flight.getAirplaneId(), flight.getId()});
	}
	
	public void changeDeparture(Flight flight) throws ClassNotFoundException, SQLException {
		saveWithoutPrimary("update flight set departure_time = ? where id = ?", new Object[] {flight.getAirplaneId(), flight.getId()});
	}
	
	public List<Flight> viewAllFlights() throws ClassNotFoundException, SQLException {
		List<Flight> flights = new ArrayList<>();
		PreparedStatement sttmnt = getConnection().prepareStatement("select flight.id,flight.route_id,flight.departure_time,flight.reserved_seats,flight.seat_price,route.origin_id,route.destination_id from flight join route on route.id = flight.route_id");
		ResultSet rs = sttmnt.executeQuery();
		while(rs.next()) {
			System.out.println("Flight ID: " + rs.getString("flight.id") + "\nRoute ID: " + rs.getString("flight.route_id") + " " + rs.getString("route.origin_id") +"->" + rs.getString("route.destination_id") + "\nDeparture time: " + rs.getDate("flight.departure_time") + " " + rs.getTime("flight.departure_time") + "\nReserved seats: " + rs.getInt("flight.reserved_seats") + "\nPrice: " + rs.getFloat("flight.seat_price") + "0\n");
		}
		return flights;
	}
}
