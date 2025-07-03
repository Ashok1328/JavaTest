package day40;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AnnotationDemo2 {
	
	@BeforeClass
	void login()
	{
		System.out.println("This is login...");
	}
	
	@AfterClass
	void logout()
	{
		System.out.println("This is logout");
	}
	
	@Test(priority=1)
	void search()
	{
		System.out.println("This is search");
	}
	
	@Test(priority=2)
	void advSearch()
	{
		System.out.println("This is advanced search");
	}
}

