package com.arden.utopia.entity;

import java.util.List;

import com.arden.utopia.dao.AirportDAO;

public class Airport extends AirportDAO {
	
	private String code;
	private String city;
	private List<Route> routes;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<Route> getRoutes() {
		return routes;
	}
	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}
}
