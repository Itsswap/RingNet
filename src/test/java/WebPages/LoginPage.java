package WebPages;

import BaseClass.Commonmethods;


public class LoginPage extends Commonmethods{


	public LoginPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void UserLoginPage() {
		WebElementSendkeys("username", "Username");
		WebElementSendkeys("password", "Password");
		WebElementClick("loginbutton");
		WebElementClick("selectcompany");
	}
}
