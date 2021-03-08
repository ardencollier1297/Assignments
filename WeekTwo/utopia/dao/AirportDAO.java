package com.arden.utopia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.arden.utopia.entity.Airport;

public class AirportDAO extends BaseDAO {
	public Integer addAirport(Airport airport) throws ClassNotFoundException, SQLException {
		return saveWithPrimary("insert into airport (iata_id, city) values (?, ?)", new Object[] {airport.getCode(), airport.getCity()});
	}
	
	public void editAirportCode(Airport airport) throws ClassNotFoundException, SQLException {
		saveWithoutPrimary("update airport set iata_id = ? where city = ?", new Object[] {airport.getCode(), airport.getCity()});
	}
	
	public void editAirportCity(Airport airport) throws ClassNotFoundException, SQLException {
		saveWithoutPrimary("update airport set city = ? where iata_id = ?", new Object[] {airport.getCode(), airport.getCity()});
	}
	
	public void deleteAirport(Airport airport) throws ClassNotFoundException, SQLException {
		saveWithoutPrimary("delete from airport where iata_id=?", new Object[] {airport.getCode()});
	}
	
	public List<Airport> getAllAirports() throws ClassNotFoundException, SQLException {
		List<Airport> airports = new ArrayList<>();
		PreparedStatement sttmnt = getConnection().prepareStatement("select * from airport");
		ResultSet rs = sttmnt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("iata_id") + ", " + rs.getString("city") );
		}
		return airports;
	}
}
