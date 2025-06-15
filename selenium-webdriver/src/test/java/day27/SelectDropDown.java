package day27;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		WebElement drpCountryEle = driver.findElement(By.xpath("//select[@id='country']"));
		Select drpCountry = new Select(drpCountryEle);

		// select option from dropdown
		// drpCountry.selectByVisibleText("Germany");
		// drpCountry.selectByValue("canada");
		// drpCountry.selectByIndex(1);

		// capture the option from the dropdown
		List<WebElement> option = drpCountry.getOptions();
		System.out.println("Number of option in a dropdown: " + option.size());

		// printing the options
	/*	for (int i = 0; i < option.size(); i++) {
			System.out.println(option.get(i).getText());
		}
		*/
		
		
		//select multiple options
		for(WebElement op:option) {
			String options = op.getTagName();
			
			if(option.equals("Java") || option.equals("Python") || option.equals("MySql"));
			{
				op.click();
			}
			System.out.println(op.getText());
		}
	}
}
