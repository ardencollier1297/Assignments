package com.arden.utopia.entity;

import com.arden.utopia.dao.BookingDAO;

public class Booking extends BookingDAO {
	private Integer id;
	private Integer isActive;
	private Integer confirmationCode;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public Integer getConfirmationCode() {
		return confirmationCode;
	}
	public void setConfirmationCode(Integer confirmationCode) {
		this.confirmationCode = confirmationCode;
	}

	
}
