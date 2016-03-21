package zoo;

import javax.ejb.Stateless;

@Stateless
public class UserAS implements UserAuthentificationServiceInterface{

	@Override
	public boolean isValid(String login, String pass) {
		return login.equals(pass);
	}

}
