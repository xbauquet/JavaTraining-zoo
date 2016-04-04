package com.zoo.service.booking;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.zoo.model.Booking;

@Path("/booking/")
public class BookingWebService {

	private static final String SUCCESS = "success";
	@Inject
	BookingService bookingService;

	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteBooking(@QueryParam("id") int id) {
		bookingService.removeBooking(bookingService.findBookingById(id));
		return SUCCESS;
	}

	@POST
	@Path("/id")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Booking findBookingById(@QueryParam("id") int id) {
		return bookingService.findBookingById(id);
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Booking> findAllBooking() {
		return bookingService.findAllBooking();
	}

	@GET
	@Path("/getCurrent")
	@Produces(MediaType.APPLICATION_JSON)
	public Booking getCurrentBooking() {
		return bookingService.getCurrentBooking();
	}

	@POST
	@Path("/setCurrent")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String setCurrentBooking(@QueryParam("nbAdults") int nbAdults, @QueryParam("nbChildren") int nbChildren,
			@QueryParam("nbReduced") int nbReduced, @QueryParam("nbGroups") int nbGroups) {
		bookingService.setCurrentBooking(bookingService.createBooking(nbAdults, nbChildren, nbReduced, nbGroups));
		return SUCCESS;
	}

	@GET
	@Path("/saveCurrent")
	@Produces(MediaType.TEXT_PLAIN)
	public String saveCurrentBooking() {
		bookingService.saveBooking(bookingService.getCurrentBooking());
		return SUCCESS;
	}

}
