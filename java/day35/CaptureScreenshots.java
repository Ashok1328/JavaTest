package day35;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshots {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//capture full page screenshot
		
//		TakesScreenshot ts = (TakesScreenshot)driver;
//		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
//		File targetFile = new File(System.getProperty("user.dir")+"\\Screenshot\\fullpage.png");
//		sourceFile.renameTo(targetFile);  //copy source file to target file
		
		//capture the screenshot of the specific section
//		WebElement featuredProducts = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
//		File sourceFile = featuredProducts.getScreenshotAs(OutputType.FILE);
//		File targetFile = new File(System.getProperty("user.dir")+ "\\Screenshot\\featuredProducts.png");
//		sourceFile.renameTo(targetFile);
		
		//capture scrennshot of webelement
		
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File sourceFile = logo.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir")+ "\\Screenshot\\logo.png");
		sourceFile.renameTo(targetFile);
		
		
		driver.quit();
	}
}
