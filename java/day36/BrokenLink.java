package day36;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		//capture all the links from the website
		
		List<WebElement> link = driver.findElements(By.tagName("a"));
		System.out.println("No of links: " + link.size());
		
		int noOfBrokenLinks = 0;
		
		for(WebElement linkElement:link)
		{
			String hrefValue = linkElement.getAttribute("href");
			
			if(hrefValue == null || hrefValue.isEmpty())
			{
				System.out.println("Href value is null or empty, So not possible to check");
				continue;
			}
				
			//hit URL to server
			
			try 
			{
				URL linkURL = new URL(hrefValue); //converted href value from string to URL format
				HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();  //open connection to the server
				conn.connect();  //connect to the server and hit the url or sent request to the server
				
				if(conn.getResponseCode()>400)
				{
					System.out.println(hrefValue + " ------> Broken Link");
					noOfBrokenLinks++;
				}
					else
				{
						System.out.println(hrefValue + " -----> Not a broken link");
				}
			}
					catch(Exception e)
			{
						
			}
		}
		System.out.println("Number of broken links:" + noOfBrokenLinks);
	}
}
