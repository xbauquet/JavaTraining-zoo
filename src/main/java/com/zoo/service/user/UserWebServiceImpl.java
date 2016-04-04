package com.zoo.service.user;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.zoo.model.User;

@Path("/user")
public class UserWebServiceImpl {

	private static final String SUCCESS = "success";
	@Inject
	private UserService userService;

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String addNewUser(@QueryParam("email") String email, @QueryParam("firstName") String firstName,
			@QueryParam("lastName") String lastName, @QueryParam("pass") String pass) {
		userService.saveUser(userService.createUser(email, firstName, lastName, pass));
		return SUCCESS;
	}

	@POST
	@Path("/connection")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String connection(@QueryParam("email") String email, @QueryParam("pass") String pass) {
		User user = userService.findUserById(email);
		if (user != null && user.isMyPassword(pass)) {
			userService.setCurrentUser(user);
			return userService.getCurrentUser().getAuthority();
		} else {
			return Boolean.FALSE.toString();
		}
	}

	@GET
	@Path("/id/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public User findUserById(@PathParam("email") String email) {
		return userService.findUserById(email);
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<User> findAllUser() {
		return userService.findAllUser();
	}

	@GET
	@Path("/current")
	@Produces(MediaType.APPLICATION_JSON)
	public User getCurrentUser() {
		return userService.getCurrentUser();
	}

	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUser(@QueryParam("email") String email) {
		userService.removeUser(userService.findUserById(email));
		return SUCCESS;
	}

	@POST
	@Path("/addAdmin")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String addNewAdmin(@QueryParam("email") String email, @QueryParam("firstName") String firstName,
			@QueryParam("lastName") String lastName, @QueryParam("pass") String pass) {
		userService.saveUser(userService.createAdmin(email, firstName, lastName, pass));
		return SUCCESS;
	}

	@GET
	@Path("/logout")
	@Produces(MediaType.TEXT_PLAIN)
	public String logout() {
		userService.disconnectCurrentUser();
		return SUCCESS;
	}

}
