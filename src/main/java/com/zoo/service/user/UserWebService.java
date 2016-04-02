package com.zoo.service.user;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.zoo.model.User;

@Path("/user/")
public interface UserWebService {

	@POST
	@Path("/add/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	String addNewAdmin(@FormParam("email") String email, @FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName, @FormParam("pass") String pass);

	@POST
	@Path("/addAdmin/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	String addNewUser(@FormParam("email") String email, @FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName, @FormParam("pass") String pass);

	@POST
	@Path("/connection/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	String connection(@FormParam("email") String email, @FormParam("pass") String pass);

	@POST
	@Path("/delete/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	String deleteUser(@FormParam("email") String email);

	@GET
	@Path("/useratid/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	User findUserById(@PathParam("email") String email);

	@GET
	@Path("/userlist/")
	@Produces(MediaType.APPLICATION_JSON)
	Collection<User> findAllUser();

	@GET
	@Path("/currentuser/")
	@Produces(MediaType.APPLICATION_JSON)
	User getCurrentUser();

	@GET
	@Path("/logout/")
	@Produces(MediaType.TEXT_PLAIN)
	String logout();

}
