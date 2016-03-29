package com.zoo.service.user;

import javax.inject.Inject;

import com.zoo.data.user.UserDao;
import com.zoo.model.User;

public class UserServiceImpl implements UserService {

	private static final String ADMIN_AUTHORITY = "admin";
	private static final String USER_AUTHORITY = "user";

	@Inject
	private UserDao userDao;

	@Override
	public User createUser(String email, String firstName, String lastName, String pass) {
		User user = new User();
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPass(pass);
		user.setAuthority(USER_AUTHORITY);
		return user;
	}

	@Override
	public User createAdmin(String email, String firstName, String lastName, String pass) {
		User user = new User();
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPass(pass);
		user.setAuthority(ADMIN_AUTHORITY);
		return user;
	}

	@Override
	public void saveUser(User user) {
		userDao.persist(user);
	}

	@Override
	public void removeUser(User user) {
		userDao.remove(user);

	}

	@Override
	public void findUserById(String email) {
		userDao.findById(email);

	}

	@Override
	public void findAllUser() {
		userDao.findAll();

	}

}
