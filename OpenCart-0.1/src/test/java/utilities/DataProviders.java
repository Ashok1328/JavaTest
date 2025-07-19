package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// DataProvide 1

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException 
	{
		String path = ".\\testData\\OpenCart_LoginData.xlsx"; // taking xl file from data

		ExcelUtility xlUtil = new ExcelUtility(path); // creating an object for XLUtility

		int totalRows = xlUtil.getRowCount("Sheet1");
		int totalCols = xlUtil.getCellCount("Sheet1", 1);

		String loginData[][] = new String[totalRows][totalCols]; // created for two dimension array which can store

		for (int i = 1; i <= totalRows; i++) // 1 read data from xl storing in two dimensional array
		{
			for (int j = 0; j < totalCols; j++) // 0 i os row j is col
			{
				loginData[i-1][j] = xlUtil.getCellData("Sheet1", i, j); // 1,0
			}
		}
		return loginData; // returning two dimensional data
	}
}
