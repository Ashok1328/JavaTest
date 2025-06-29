package day32;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement box1 = driver.findElement(By.xpath("input[@id='field1']"));
		WebElement box2 = driver.findElement(By.xpath("input[@id='field2']"));
		WebElement button = driver.findElement(By.xpath("button[normalize-space()='Copy Text']"));
		
		box1.clear();
		box1.sendKeys("Beastay!!");
		
		Thread.sleep(5000);
		
		//Double click
		Actions act = new Actions(driver);
		act.doubleClick(button).perform();
		
		//validation
		String text = box2.getAttribute("value");
		System.out.println("Captured value: " + text);
		
		if(text.equals("Beastay!!")) {
			System.out.println("Text is Copied");
		}else 
		{
			System.out.println("Text is not Copied");
		}
	}
}
