package day32;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.findElement(By.xpath("https://testautomationpractice.blogspot.com/"));
		driver.manage().window().maximize();
		
		WebElement demo = driver.findElement(By.xpath("//button[normalize-space()='Point Me']"));
		WebElement mobile = driver.findElement(By.xpath("//a[normalize-space()='Mobiles']"));
		
		Actions act = new Actions(driver);
		
		//mouse hover 
		act.moveToElement(demo).moveToElement(mobile).build().perform();
		
	}
}
