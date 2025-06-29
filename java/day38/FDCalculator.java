package day38;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {
	
	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/state-bank-of-india-sbi/fixed-deposit-calculator");
		driver.manage().window().maximize();
		
		String filePath = System.getProperty("user.dir") + "\\Testdata\\celldata.xlsx";
		
		int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
		
		for(int i =0; i<=rows; i++)
		{
			//read data from excel
			
			String price = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
			String ROI = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
			String per1 = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
			String per2 = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
			String freq = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
			
			String exp_mvalue = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);
			
			//pass above data into application
			
			driver.findElement(By.xpath("principal ")).sendKeys(price);
			driver.findElement(By.xpath("intrest")).sendKeys(ROI);
			driver.findElement(By.xpath("tenure")).sendKeys(per1);
			
			Select perDrp = new Select(driver.findElement(By.xpath("tenurePriod")));
			perDrp.selectByVisibleText(per2);
			
			Select freqDrp = new Select(driver.findElement(By.xpath("frequency")));
			freqDrp.selectByVisibleText(freq);
			
			driver.findElement(By.xpath("cal_btn")).click();
				
			//validation
			
			String act_mvalue = driver.findElement(By.xpath("resp_matval")).getText();
			
			if(Double.parseDouble(exp_mvalue) == Double.parseDouble(act_mvalue))
			{
				System.out.println("Test Passed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Passed");
				ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
			}
			else
			{
				System.out.println("Test Failed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Failed");
				ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
			}
			driver.findElement(By.xpath("clear")).click();
		}
		driver.quit();
	}
}
