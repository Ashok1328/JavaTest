package day29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class TravelAgency {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		WebElement drpCityEle = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select drpCity = new Select(drpCityEle);
		
		
	}
}
