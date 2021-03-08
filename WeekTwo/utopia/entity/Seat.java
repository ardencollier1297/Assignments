package com.arden.utopia.entity;

import com.arden.utopia.dao.SeatDAO;

public class Seat extends SeatDAO {

	private Character row;
	private Integer seat;
	
	public Character getRow() {
		return row;
	}
	public void setRow(char row) {
		this.row = row;
	}
	public Integer getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	
	
}
