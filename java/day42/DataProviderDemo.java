package day42;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DataProviderDemo {
	
	WebDriver driver;
	
	@BeforeClass
	void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	void testLogin() throws InterruptedException
	{
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("ashok@1gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("ashok123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(3000);
		
		boolean status = driver.findElement(By.xpath("//span[normalize-space()='My Account']")).isDisplayed();
		if(status == true)
		{
			driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")).click();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
	}
	
	@AfterClass
	void tearDown()
	{
		driver.close();
	}

	
	@DataProvider
	String[][] loginData()
		{
			String data[][] = {
					{"abc@gmail.com", "test123"},
					{"xyz@gmail.com", "test012"},
					{"ram@gmail.com", "test@123"},
					{"ashok@1gmail.com", "ashok123"},
			};
			
			return data;
		}
	
	
	
	}
	

