package day28;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {
	
	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		//Normal alert with ok button
		
	/*	driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	*/
		
		//alert with ok and cancel button
	//	driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
	//	Thread.sleep(5000);
		
	//	driver.switchTo().alert().accept(); close alert using ok button
	//	driver.switchTo().alert().dismiss(); //close alert using cancel button
		
		//Prompt alert input box 
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Welcom to JavaScript alert prompt");
		alert.accept();
		
	}
}
