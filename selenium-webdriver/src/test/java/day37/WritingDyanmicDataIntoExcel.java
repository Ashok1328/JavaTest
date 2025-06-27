package day37;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDyanmicDataIntoExcel {
	
	public static void main(String[] args) throws IOException{
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\Testdata\\test1.xlsx");
		
		XSSFWorkbook workBook = new XSSFWorkbook();
		
		XSSFSheet sheet = workBook.createSheet("Data");
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter how many rows?");
		int noOfRows = sc.nextInt();
		
		System.out.println("Enter how many cells?");
		int noOfCells = sc.nextInt();
		
		for(int r=0; r<=noOfRows; r++)
		{
			XSSFRow currentRow = sheet.createRow(r);
			
			for(int c=0; c<noOfCells; c++)
			{
				XSSFCell cell = currentRow.createCell(c);
				cell.setCellValue(sc.next());
			}
		}
		
		workBook.write(file);
		workBook.close();
		file.close();
		
		System.out.println("File is created...");
	}
}
