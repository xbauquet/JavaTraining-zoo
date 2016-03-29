package com.zoo.tickets;

import javax.ejb.Stateless;
import javax.inject.Inject;
import com.zoo.dao.BookingDao;

@Stateless
public class BookingServiceImpl implements BookingService {

	@Inject
	private BookingDao bookingDao;

	@Override
	public Booking createBooking(int nbAdults, int nbChildren, int nbReduced, int nbGroup) {
		Booking booking = new Booking();
		booking.setNbAdults(nbAdults);
		booking.setNbChildren(nbChildren);
		booking.setNbReduced(nbReduced);
		booking.setNbGroups(nbGroup);
		booking.calculatePrice();
		return booking;
	}

	@Override
	public void saveBooking(Booking booking) {
		bookingDao.persist(booking);
	}

	@Override
	public void removeBooking(Booking booking) {
		bookingDao.remove(booking);
	}

	@Override
	public void findBookingById(int id) {
		bookingDao.findById(id);
	}

	@Override
	public void findAllBooking() {
		bookingDao.findAll();
	}

}
