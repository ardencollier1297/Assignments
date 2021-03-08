package com.arden.utopia.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.arden.utopia.entity.Flight;
import com.arden.utopia.entity.Route;

public class RouteDAO extends BaseDAO {
	
	
	public Integer addRoute(Route route) throws ClassNotFoundException, SQLException {
		return saveWithPrimary("insert into route (origin_id, destination_id) values (?, ?)", new Object[] {route.getOriginId(), route.getDestId()});
	}
	
	public void getPrimaryId(Route route) throws SQLException, ClassNotFoundException {
		PreparedStatement sttmnt = getConnection().prepareStatement("select id from route where origin_id = ? and destination_id = ?");
		sttmnt.setString(1, route.getOriginId());
		sttmnt.setString(2, route.getDestId());
		ResultSet rs = sttmnt.executeQuery();
		while(rs.next()) {
			route.setId(rs.getInt("id"));
		}
	}
	
	public void editOriginByPk(Route route, Flight flight) throws ClassNotFoundException, SQLException {
		saveWithoutPrimary("update route r inner join flight f on r.id = f.route_id and f.id = ? set r.origin_id = ?", new Object[] {flight.getId(), route.getOriginId()});
	}
	
	public void editDestinationByPk(Route route, Flight flight) throws ClassNotFoundException, SQLException {
		saveWithoutPrimary("update route r inner join flight f on r.id = f.route_id and f.id = ? set r.destination_id = ?", new Object[] {flight.getId(), route.getDestId()});
	}
	
	public void deleteRoute(Route route) throws ClassNotFoundException, SQLException {
		saveWithoutPrimary("delete from route where id=?", new Object[] {route.getId()});
	}
	
	public List<Route> getAllRoutes() throws ClassNotFoundException, SQLException {
		List<Route> routes = new ArrayList<>();
		PreparedStatement sttmnt = getConnection().prepareStatement("select * from route where origin_id = ? OR destination_id = ?");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Airport Code to search");
		String airportId = scan.nextLine();
		sttmnt.setString(1, airportId);
		sttmnt.setString(2, airportId);
		ResultSet rs = sttmnt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("origin_id") + "->" + rs.getString("destination_id"));
		}
		scan.close();
		return routes;
	}
}
