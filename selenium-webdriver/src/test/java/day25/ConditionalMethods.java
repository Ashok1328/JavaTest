package day25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {
	public static void main(String[] args) {
		 WebDriver driver = new ChromeDriver();
			driver.get("https://demo.nopcommerce.com/register");
			driver.manage().window().maximize();
			
			// isDisplayed
	//		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
	//		System.out.println("Display Logo: " + logo.isDisplayed());
			
	//		boolean status = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
	//		System.out.println("Display status: " + status);
			
			//isEnabled
	//		boolean search = driver.findElement(By.xpath("//input[@id='small-searchterms']")).isEnabled();
	//		System.out.println("Enable Search box: " + search );
			
			//isSelected
//			WebElement  male_rd = driver.findElement(By.xpath("//label[normalize-space()='Male']"));
//			WebElement female_rd = driver.findElement(By.xpath("//span[@class='female']"));
//			
//			System.out.println("Before Selection...");
//			System.out.println(male_rd.isSelected());
//			System.out.println(female_rd.isSelected());
//			
//			System.out.println("After Selecting male...");
//			male_rd.click();
//				
//			System.out.println(male_rd.isSelected());
//			System.out.println(female_rd.isSelected());
			
			boolean status = driver.findElement(By.xpath("//input[@id='Newsletter']")).isSelected();
			System.out.println("Selected: " + status);
			
			driver.close();

	 }
}
