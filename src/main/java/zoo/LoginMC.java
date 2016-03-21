package zoo;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginMC {
	private static final String GOOD_LOGIN = "toto";
	private static final String GOOD_PASS = "toto";

	private String login;
	private String pass;

	public LoginMC() {
	}

	public String check() {

		if (login.equals(GOOD_LOGIN) && pass.equals(GOOD_PASS)) {
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

