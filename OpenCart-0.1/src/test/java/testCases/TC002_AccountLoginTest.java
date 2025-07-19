package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_AccountLoginTest extends BaseClass {
	
	@Test
	public void verify_account_Login()
	{
		logger.info("***** Starting TC_002_LoginTest *****");
		
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link.....");
		
		hp.clickLogin();
		logger.info("Clicked on Login Link ....");
		
		AccountLoginPage lp = new AccountLoginPage(driver);
		
		logger.info("Providing Login Details...");
		lp.EmailAddress(p.getProperty("email"));
		lp.Password(p.getProperty("password"));
		lp.ClickLogin();
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();
		
		// Assert.assertEquals(targetPage, true);
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("******** Finished TC002_LoginTest ***");
	}

}
