package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class) // getting data provider from different
																				// class
	public void verify_loginDDT(String email, String pwd, String exp) {
		logger.info("**** Starting TC003_LoginDDT ***");
		
		try
		{
		// HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();

		// Login
		AccountLoginPage lp = new AccountLoginPage(driver);
		lp.EmailAddress(email);
		lp.Password(pwd);
		lp.ClickLogin();

		// MyAccount
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();

		/*
		 * Data is valid - login success - test pass -logout login failed - test fail
		 * 
		 * Data is invalid - login success - test fail - logout login failed - test pass
		 */

		if (exp.equalsIgnoreCase("Valid")) {
			if (targetPage == true) {
				macc.clickLogout();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}
		if (exp.equalsIgnoreCase("InValid")) {
			if (targetPage == true) {
				macc.clickLogout();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(false);
			}
		}
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("**** Finished TC003_LoginTest ***");
	}
}
