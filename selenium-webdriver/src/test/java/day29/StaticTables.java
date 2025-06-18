package day29;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTables {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//find total number of rows in a table 
		int rows = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr")).size();
		System.out.println("Number of rows: " + rows);
		
		//find total number of column in a table
		int column = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//th")).size();
		System.out.println("Number if column: " + column);
		
		//read data from specific data and column
	//	String bookName = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[5]//td[1]")).getText();
	//	System.out.println(bookName);
		
		//read data from all the rows and column
	//	System.out.println("BookName"+"\t"+"Author"+"\t"+"Subject"+"\t"+"Price");
	/*	for(int r=2; r<=rows; r++) {
			for(int c=1; c<=column; c++) {
				String value = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(value +"\t");
			}
			System.out.println();
		} */
		
		//print book names whose author is Mukesh
	/*	for(int r=2; r<=rows; r++) {
			String autherName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			
			if(autherName.equals("Mukesh")) {
			String	bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				System.out.println(bookName + "\t" +autherName);
			}
			
		} */
		
		//find total price of all books
		int total = 0;
		for(int r=2; r<=rows; r++) {
			String price = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td[4]")).getText();
			total = total + Integer.parseInt(price);
		}
		System.out.println("The price of total books: " + total);
	}
}
