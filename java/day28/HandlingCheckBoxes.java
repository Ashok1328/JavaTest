package day28;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		// select one checkbox
		// driver.findElement(By.xpath("//label[normalize-space()='Sunday']")).click();

		// select all checkboxes
		List<WebElement> checkBoxes = driver
				.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));

		/*
		 * for(int i=0; i<checkBoxes.size();i++) { checkBoxes.get(i).click(); }
		 */

		/*
		 * for(WebElement checkbox:checkBoxes) { checkbox.click(); }
		 */

		// select last three checkboxes
		// total no of checkboxes - how many checkboxes you want to select = starting
		// index
		/*
		 * for(int i=4; i<checkBoxes.size(); i++) { checkBoxes.get(i).click(); }
		 */

		// unselect checkboxes if they are already selected
		for (int i = 0; i < 3; i++) {
			checkBoxes.get(i).click();
		}

		Thread.sleep(5000);

		for (int i = 0; i < checkBoxes.size(); i++) {
			if (checkBoxes.get(i).isSelected()) {
				checkBoxes.get(i).click();
			}
		}
	}
}
