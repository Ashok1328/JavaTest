package day37;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel File ---> Workbook ----> Sheets ---> Rows ---> Cells

public class ReadingDataFromExcel {
	
	public static void main(String[] args) throws IOException{
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\Testdata\\test.xlsx");
		
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workBook.getSheet("Sheet1");  //getSheetAt: Index call garxa
		
		int totalRows = sheet.getLastRowNum(); 
		
		int totalCells = sheet.getRow(1).getLastCellNum();
		
		System.out.println("numer of rows: " + totalRows);
		System.out.println("numer of cells: " + totalCells);
		
		for(int r=0; r<=totalRows; r++)
		{
			
			XSSFRow currentRow = sheet.getRow(r);
			
			for(int c=0; c<totalCells; c++)
			{
				XSSFCell cell = currentRow.getCell(c);
				System.out.print(cell.toString() + "\t");
			}
			System.out.println();
		}
		workBook.close();
		file.close();
	}
}
