package com.arden.utopia.entity;

import java.util.List;

import com.arden.utopia.dao.RouteDAO;

public class Route extends RouteDAO {

	private Integer id;
	private String originId;
	private String destId;
	List<Airport> airports;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOriginId() {
		return originId;
	}
	public void setOriginId(String originId) {
		this.originId = originId;
	}
	public String getDestId() {
		return destId;
	}
	public void setDestId(String destId) {
		this.destId = destId;
	}
	public List<Airport> getAirports() {
		return airports;
	}
	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}
	
	
}
