package com.zoo.service.booking;

import java.util.Collection;

import javax.inject.Inject;

import com.zoo.model.Booking;

public class BookingWebServiceImpl implements BookingWebService {

	private static final String SUCCESS = "success";
	@Inject
	BookingService bookingService;

	@Override
	public String deleteBooking(int id) {
		bookingService.removeBooking(bookingService.findBookingById(id));
		return SUCCESS;
	}

	@Override
	public Booking findBookingById(int id) {
		return bookingService.findBookingById(id);
	}

	@Override
	public Collection<Booking> findAllBooking() {
		return bookingService.findAllBooking();
	}

	@Override
	public Booking getCurrentBooking() {
		return bookingService.getCurrentBooking();
	}

	@Override
	public String addBooking(int nbAdults, int nbChildren, int nbReduced, int nbGroups) {
		bookingService.saveBooking(bookingService.createBooking(nbAdults, nbChildren, nbReduced, nbGroups));
		return SUCCESS;
	}

}
