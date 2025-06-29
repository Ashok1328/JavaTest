package day32;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		WebElement bank = driver.findElement(By.xpath("//a[normalize-space()='BANK']"));
		WebElement account1 = driver.findElement(By.xpath("//ol[@id='bank']//li[@class='placeholder']"));
		
		act.dragAndDrop(bank, account1).perform();
		
		WebElement debit = driver.findElement(By.xpath("//section[@id='g-container-main']//li[2]//a[1]"));
		WebElement amount1 = driver.findElement(By.xpath("//ol[@id='amt7']"));
		
		act.dragAndDrop(debit, amount1).perform();
		
		WebElement sales = driver.findElement(By.xpath("//a[normalize-space()='SALES']"));
		WebElement account2 = driver.findElement(By.xpath("//ol[@id='loan']"));
		
		act.dragAndDrop(sales, account2).perform();
		
		WebElement credit = driver.findElement(By.xpath("//section[@id='g-container-main']//li[1]//a[1]"));
		WebElement amount2 = driver.findElement(By.xpath("//ol[@id='amt8']"));
		
		act.dragAndDrop(credit, amount2).perform();

	}
}
