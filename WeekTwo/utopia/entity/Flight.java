package com.arden.utopia.entity;

import java.time.LocalDateTime;

import com.arden.utopia.dao.FlightDAO;

public class Flight extends FlightDAO {
	private Integer id;
	private Integer routeId;
	private Integer airplaneId;
	private Integer reservedSeats;
	private float seatPrice;
	LocalDateTime departure;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRouteId() {
		return routeId;
	}
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	public Integer getAirplaneId() {
		return airplaneId;
	}
	public void setAirplaneId(Integer airplaneId) {
		this.airplaneId = airplaneId;
	}
	public Integer getReservedSeats() {
		return reservedSeats;
	}
	public void setReservedSeats(Integer reservedSeats) {
		this.reservedSeats = reservedSeats;
	}
	public float getSeatPrice() {
		return seatPrice;
	}
	public void setSeatPrice(float seatPrice) {
		this.seatPrice = seatPrice;
	}
	
	public void setDeparture(LocalDateTime departure) {
		this.departure = departure;
	}
	
	public LocalDateTime getDeparture() {
		return departure;
	}
		
}
