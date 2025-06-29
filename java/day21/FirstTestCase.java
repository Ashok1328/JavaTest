package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String act_title = driver.getTitle();
		if (act_title.equals("OrangeHRM")) 
		{
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
			driver.quit();
		}
	}
}
