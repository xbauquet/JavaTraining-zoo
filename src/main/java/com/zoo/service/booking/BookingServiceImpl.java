package com.zoo.service.booking;

import javax.ejb.Stateless;
import javax.inject.Inject;
import com.zoo.data.booking.BookingDao;
import com.zoo.model.Booking;
import com.zoo.service.user.UserHolder;

@Stateless
public class BookingServiceImpl implements BookingService {

	@Inject
	private BookingDao bookingDao;

	@Inject
	private UserHolder userHolder;

	@Override
	public Booking createBooking(int nbAdults, int nbChildren, int nbReduced, int nbGroup) {
		Booking booking = new Booking();
		booking.setNbAdults(nbAdults);
		booking.setNbChildren(nbChildren);
		booking.setNbReduced(nbReduced);
		booking.setNbGroups(nbGroup);
		if (userHolder.getUser() != null) {
			booking.setEmail(userHolder.getUser().getEmail());
		}
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
