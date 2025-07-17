package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test
	public void verify_account_registration() {
		logger.info("******** Starting TC001_AccountRegistrationTest ******");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount link....");

			hp.clickRegister();
			logger.info("Cicked in Register link.....");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			logger.info("Providing customer details....");
			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());
			regpage.setEmail(randomString() + "@gmail.com"); // randomly generate the email

//		regpage.setFirstName("kriti");
//		regpage.setLastName("Neupane");
//		regpage.setEmail("kriti22@gmail.com");

			String password = randomAlphaNumeric();

			regpage.setPassword(password);

			regpage.setPrivacyPolicy();
			regpage.clickContinue();

			logger.info("Validating expected message....");
			String confmsg = regpage.getConfirmationMsg();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		} catch (Exception e) {
			logger.error("Test failed....");
			logger.debug("Debug logs...");
			Assert.fail();
		}
		logger.info("****** Finished TC001_AccountRegistrationTest ****");
	}

}
