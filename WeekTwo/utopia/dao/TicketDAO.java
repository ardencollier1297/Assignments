package com.arden.utopia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.arden.utopia.entity.Ticket;
import com.arden.utopia.menus.TicketMenu;

public class TicketDAO extends BaseDAO {
	
	public Integer addTicket(Ticket ticket) throws ClassNotFoundException, SQLException {
		return saveWithPrimary("insert into ticket (flight_id, passenger_id, seat_type) values (?, ?, ?)", new Object[] {ticket.getFlightId(), ticket.getPassengerId(), ticket.getSeatType()});
	}
	
	public void deleteTicket(Ticket ticket) throws ClassNotFoundException, SQLException {
		saveWithoutPrimary("delete from ticket where id=?", new Object[] {ticket.getId()});
	}
	
	public void changeSeat(Ticket ticket) throws ClassNotFoundException, SQLException {
		saveWithoutPrimary("update ticket set seat_type=? where id=?", new Object[] {ticket.getSeatType(), ticket.getId()});
	}
	
	public void checkForPassenger(Ticket ticket) throws SQLException, ClassNotFoundException {
		PreparedStatement sttmnt = getConnection().prepareStatement("select id from passenger where id = ?");
		sttmnt.setInt(1, ticket.getPassengerId());
		ResultSet rs = sttmnt.executeQuery();
		if (rs.next()) {
			ticket.setPassengerId(rs.getInt("id"));
		} else {
			System.out.println("Sorry, that passenger ID returned no results.");
			TicketMenu.addTicket();
		}
	}
	
	public void checkForFlight(Ticket ticket) throws SQLException, ClassNotFoundException {
		PreparedStatement sttmnt = getConnection().prepareStatement("select id from flight where id = ?");
		sttmnt.setInt(1, ticket.getFlightId());
		ResultSet rs = sttmnt.executeQuery();
		if (rs.next()) {
			ticket.setFlightId(rs.getInt("id"));
		} else {
			System.out.println("Sorry, that flight ID returned no results.");
			TicketMenu.addTicket();
		}
	}
	
	public void getPrimaryId(Ticket ticket) throws SQLException, ClassNotFoundException {
		PreparedStatement sttmnt = getConnection().prepareStatement("select id from ticket where passenger_id = ? and flight_id = ?");
		sttmnt.setInt(1, ticket.getPassengerId());
		sttmnt.setInt(2, ticket.getFlightId());
		ResultSet rs = sttmnt.executeQuery();
		while(rs.next()) {
			ticket.setId(rs.getInt("id"));
		}
	}
	
	public void viewTicket(Ticket ticket) throws ClassNotFoundException, SQLException {
		PreparedStatement sttmnt = getConnection().prepareStatement("select id,passenger_id,flight_id,seat_type from ticket where id=?");
		sttmnt.setInt(1, ticket.getId());
		ResultSet rs = sttmnt.executeQuery();
		if(!rs.next()) {
			System.out.println("Sorry, that ticket number is invalid.");
			TicketMenu.init();
		} else {
			System.out.println("Ticket " + rs.getInt("id") + ": " + rs.getString("seat_type") + " on Flight " + rs.getInt("flight_id") + " for Passenger ID: " + rs.getInt("passenger_id"));
		}
	}
	
	public List<Ticket> viewAllTickets() throws ClassNotFoundException, SQLException {
		List<Ticket> tickets = new ArrayList<>();
		PreparedStatement sttmnt = getConnection().prepareStatement("select * from ticket");
		ResultSet rs = sttmnt.executeQuery();
		while(rs.next()) {
			System.out.println("Ticket ID: " + rs.getInt("id") + "\nFlight ID: " + rs.getInt("flight_id") + "\nPassenger ID: " + rs.getInt("passenger_id") + "\nSeat type: " + rs.getString("seat_type") + "\n");
		}
		return tickets;
	}
}
