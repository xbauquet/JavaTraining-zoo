package com.zoo.service.booking;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import com.zoo.model.Booking;

@ManagedBean
@SessionScoped
public class BookingHolder implements Serializable {
	private Booking booking;

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}
