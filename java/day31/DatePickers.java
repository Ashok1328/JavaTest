package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickers {

	//select future date
	static void selectFutureDate(WebDriver driver, String year, String month, String date) {

		while (true) {
			String currMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (currMonth.equals(month) && currYear.equals(year)) {
				break;
			}

			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		List<WebElement> allDates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td//a"));

		for (WebElement dt : allDates) {
			
			if (dt.getText().equals(date)) 
			{
				dt.click();
				break;
			}
		}
	}
	
	//select past date
		static void selectPastDate(WebDriver driver, String year, String month, String date) {

			while (true) {
				String currMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
				String currYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

				if (currMonth.equals(month) && currYear.equals(year)) {
					break;
				}

				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //previous
			}
			List<WebElement> allDates = driver
					.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td//a"));

			for (WebElement dt : allDates) {
				
				if (dt.getText().equals(date)) 
				{
					dt.click();
					break;
				}
			}
		}


		

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://jqueryui.com/datepicker/");

		driver.manage().window().maximize();

		// switch to frame
		driver.switchTo().frame(0);

		// Method1 using sendkeys
		// driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("06/06/2025");
		// //mm/yy/yyyy

		// Method2 using datapicker
		// expected data
//		String year = "2026";
//		String month = "February";
//		String date = "10";
//		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		selectFutureDate(driver,"2025","June", "21");

	}

}
