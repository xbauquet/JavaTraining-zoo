package com.zoo.users;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

@ManagedBean
public class LoginMC {
	private String login;
	private String pass;

	@Inject
	UserAuthentificationServiceInterface userAS;

	public String check() {
		if (userAS.isValid(login, pass)) {
			return Boolean.TRUE.toString();
		} else {
			return Boolean.FALSE.toString();
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
