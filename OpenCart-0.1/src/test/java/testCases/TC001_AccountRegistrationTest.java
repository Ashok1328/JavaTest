package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setUp() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	
	@Test
	public void verify_account_registration()
	{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clicRegister();
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
//		
//		regpage.setFirstName(randomeString().toUpperCase());
//		regpage.setLastName(randomeString().toUpperCase());
//		regpage.setEmail(randomeString()+"@gmail.com"); //randomly generate the email
		
		regpage.setFirstName("kriti");
		regpage.setLastName("Neupane");
		regpage.setEmail("kriti22@gmail.com");
		
	//	String password = randomAlphaNumeric();
		
		regpage.setPassword("kriti2228");
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		String confmsg = regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
