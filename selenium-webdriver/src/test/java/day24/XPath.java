package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();	
		
		//driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]")).sendKeys("Computers");
		driver.findElement(By.xpath("//input[@name='q'][@placeholder='Search store']")).sendKeys("Desktops");
	}
}
