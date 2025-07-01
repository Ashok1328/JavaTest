package day38;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CitCalculator {
	
	public static void main(String[] args) throws IOException{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().window().maximize();
		
		String filePath = System.getProperty("user.dir") + "\\Testdata\\curr.xlsx";
		
		int rows = ExcelUtils.getRowCount(filePath, "Depo1");
		
		for(int i=0; i<=rows; i++)
		{
			String dpAmount = ExcelUtils.getCellData(filePath, "Depo1", i, 0);
			String IRate = ExcelUtils.getCellData(filePath, "Depo1", i, 1);
			String months = ExcelUtils.getCellData(filePath, "Depo1", i, 2);
			String cpm = ExcelUtils.getCellData(filePath, "Depo1", i, 3);
			
			String exp_tvalue = ExcelUtils.getCellData(filePath, "Depo1", i, 4);
			
			WebElement dp =  driver.findElement(By.xpath("//input[@id='mat-input-0']"));
			dp.clear();
			dp.sendKeys(dpAmount);
			
			WebElement month = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
			month.clear();
			month.sendKeys(months);
			
			WebElement IR = driver.findElement(By.xpath("//input[@id='mat-input-2']"));
			IR.clear();
			IR.sendKeys(IRate);
			
			Select CmDrp = new Select(driver.findElement(By.xpath("//span[normalize-space()='Compounded Monthly']")));
			CmDrp.selectByVisibleText(cpm);
			
			driver.findElement(By.xpath("//button[@id='CIT-chart-submit']//div[@class='mdc-button__ripple']")).click();
		
			String act_tvalue = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
			
			if(Double.parseDouble(exp_tvalue) == Double.parseDouble(act_tvalue))
					{
						System.out.println("Test Passed");
						ExcelUtils.setCellData(filePath, "Depo1", i, 6, "Passed");
						ExcelUtils.fillGreenColor(filePath, "Depo1", i, 6);
					}
			else
			{
				System.out.println("Test Failed");
				ExcelUtils.setCellData(filePath, "Depo1", i, 6, "Failed");
				ExcelUtils.fillRedColor(filePath, "Depo1", i, 6);
			}
			
		}
		driver.quit();
		
	}
}
