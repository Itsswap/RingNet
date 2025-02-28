package TestCases;

import org.testng.annotations.Test;

import WebPages.LoginPage;

public class LoginTest {

	@Test()
	public void VerifyUserLogin() throws Exception {
		LoginPage lp = new LoginPage();
		lp.UserLoginPage();
		
	}
}
