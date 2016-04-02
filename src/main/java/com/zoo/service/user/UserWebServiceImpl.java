package com.zoo.service.user;

import java.util.Collection;

import javax.inject.Inject;

import com.zoo.model.User;

public class UserWebServiceImpl implements UserWebService {

	private static final String SUCCESS = "success";
	@Inject
	private UserService userService;

	@Override
	public String addNewUser(String email, String firstName, String lastName, String pass) {
		userService.createUser(email, firstName, lastName, pass);
		return SUCCESS;
	}

	@Override
	public String connection(String email, String pass) {
		User user = userService.findUserById(email);
		if (user != null && user.isMyPassword(pass)) {
			userService.setCurrentUser(user);
			return userService.getCurrentUser().getAuthority();
		} else {
			return Boolean.FALSE.toString();
		}
	}

	@Override
	public User findUserById(String email) {
		return userService.findUserById(email);
	}

	@Override
	public Collection<User> findAllUser() {
		return userService.findAllUser();
	}

	@Override
	public User getCurrentUser() {
		return userService.getCurrentUser();
	}

	@Override
	public String deleteUser(String email) {
		userService.removeUser(userService.findUserById(email));
		return SUCCESS;
	}

	@Override
	public String addNewAdmin(String email, String firstName, String lastName, String pass) {
		userService.createAdmin(email, firstName, lastName, pass);
		return SUCCESS;
	}

	@Override
	public String logout() {
		userService.disconnectCurrentUser();
		return SUCCESS;
	}

}
