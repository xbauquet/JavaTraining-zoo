package com.zoo.tickets;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

@ManagedBean
public class TicketsMC {

	private int adult;
	private int child;
	private int reduced;
	private int group;

	@Inject
	BookingService bookingService;

	@Inject
	BookingHolder bookingHolder;

	// If at least one ticket is ordered return true to lead to the payment page
	public String payment() {

		if (adult > 0 || child > 0 || reduced > 0 || group > 0) {
			bookingHolder.setBooking(bookingService.createBooking(adult, child, reduced, group));
			return Boolean.TRUE.toString();
		} else {
			return Boolean.FALSE.toString();
		}
	}

	// Getters / Setters
	public int getAdult() {
		if (bookingHolder.getBooking() != null) {
			return bookingHolder.getBooking().getNbAdults();
		}
		return adult;
	}

	public void setAdult(int adult) {
		this.adult = adult;
	}

	public int getChild() {
		return child;
	}

	public void setChild(int child) {
		this.child = child;
	}

	public int getReduced() {
		return reduced;
	}

	public void setReduced(int reduced) {
		this.reduced = reduced;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}
}
