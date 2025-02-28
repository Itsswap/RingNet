package TestCases;

import org.testng.annotations.Test;

import WebPages.Demander;
import WebPages.LoginPage;

public class DemanderTest {
	@Test()
	public void verifydemander() throws Exception
	{
		LoginPage lp = new LoginPage();
		lp.UserLoginPage();
		Demander de= new Demander();
		de.ToVerifyDemanderTabClick();
		de.ToVerifyDemanderSearch();
		
	}

}
