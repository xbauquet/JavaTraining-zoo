package com.zoo.tickets;

import javax.ejb.Stateless;

@Stateless
public class BookingServiceImpl implements BookingService {

	@Override
	public Booking createBooking(int nbAdults, int nbChildren) {
		Booking booking = new Booking();
		booking.setNbAdults(nbAdults);
		booking.setNbChildren(nbChildren);
		// booking.setNbReduced(reduced);
		// booking.setNbGroups(group);
		booking.calculatePrice();
		return booking;
	}
}
