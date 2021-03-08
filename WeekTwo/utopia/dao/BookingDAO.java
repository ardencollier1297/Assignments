package com.arden.utopia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.arden.utopia.entity.Booking;


public class BookingDAO extends BaseDAO {
	public void getPrimaryId(Booking booking) throws SQLException, ClassNotFoundException {
		PreparedStatement sttmnt = getConnection().prepareStatement("select id from booking where confirmation_code = ?");
		sttmnt.setInt(1, booking.getConfirmationCode());
		ResultSet rs = sttmnt.executeQuery();
		while(rs.next()) {
			booking.setId(rs.getInt("id"));
		}
	}
	
	public Integer addBooking(Booking booking) throws ClassNotFoundException, SQLException {
		return saveWithPrimary("insert into booking (is_active, confirmation_code) values (?, ?)", new Object[] {booking.getIsActive(), booking.getConfirmationCode()});
	}
	
	public void deleteRoute(Booking booking) throws ClassNotFoundException, SQLException {
		saveWithoutPrimary("delete from route where id=?", new Object[] {booking.getId()});
	}
}
