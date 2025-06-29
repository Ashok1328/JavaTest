package day30;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethod {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
//		System.out.println(driver.getTitle());
//		
//		System.out.println(driver.getCurrentUrl());
//		
//		System.out.println(driver.getPageSource());
		
		String windowId = driver.getWindowHandle();
		System.out.println("Window ID: " + windowId);
		
		
	}
}
