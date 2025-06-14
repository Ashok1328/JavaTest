package day22;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
//		Boolean logoDisplaystatus = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/img")).isDisplayed();
//		System.out.println(logoDisplaystatus);
		
//		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("total number of images: " + images.size());
	}
}
