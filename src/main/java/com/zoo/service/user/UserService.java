package com.zoo.service.user;

import com.zoo.model.User;

public interface UserService {
	User createUser(String email, String firstName, String lastName, String pass);

	void saveUser(User user);

	void removeUser(User user);

	void findUserById(String email);

	void findAllUser();

	User createAdmin(String email, String firstName, String lastName, String pass);
}
