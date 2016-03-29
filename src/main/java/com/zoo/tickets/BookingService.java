package com.zoo.tickets;

public interface BookingService {
	Booking createBooking(int nbAdults, int nbChildren, int nbReduced, int nbGroup);
	void saveBooking(Booking booking);
	void removeBooking(Booking booking);
	void findBookingById(int id);
	void findAllBooking();
}
