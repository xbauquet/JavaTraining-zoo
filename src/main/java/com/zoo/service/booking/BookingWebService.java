package com.zoo.service.booking;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.zoo.model.Booking;

@Path("/booking/")
public interface BookingWebService {

	@GET
	@Path("/delete/")
	@Produces(MediaType.TEXT_PLAIN)
	String deleteBooking(int id);

	@GET
	@Path("/bookingatid/id={id}")
	@Produces(MediaType.APPLICATION_JSON)
	Booking findBookingById(@PathParam("id") int id);

	@GET
	@Path("/list/")
	@Produces(MediaType.APPLICATION_JSON)
	Collection<Booking> findAllBooking();

	@GET
	@Path("/current/")
	@Produces(MediaType.APPLICATION_JSON)
	Booking getCurrentBooking();
	
	@POST
	@Path("/add/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	String addBooking(@FormParam("nbAdults") int nbAdults,
			@FormParam("nbChildren") int nbChildren,
			@FormParam("nbReduced") int nbReduced,
			@FormParam("nbGroups") int nbGroups);

}
