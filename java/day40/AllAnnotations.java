package day40;

import org.testng.annotations.*;

public class AllAnnotations {
	
	@BeforeSuite
	void bs()
	{
		System.out.println("This is BeforeSuite method....");
	}
	
	@AfterSuite
	void as()
	{
		System.out.println("This is AfterSuite method....");
	}
	
	@BeforeTest
	void bt()
	{
		System.out.println("This is BeforeTest method....");
	}
	
	@AfterTest
	void at()
	{
		System.out.println("This is AfterTest method....");
	}
	
	@BeforeClass
	void bc()
	{
		System.out.println("This is BeforeClass method....");
	}
	
	@AfterClass
	void ac()
	{
		System.out.println("This is AfterClass method....");
	}
	
	@BeforeMethod
	void bm()
	{
		System.out.println("This is BeforeMethod...");
	}
	
	@AfterMethod
	void am()
	{
		System.out.println("This is AfterMethod");
	}
	
	@Test(priority=1)
	void tm1()
	{
		System.out.println("This is TestMethod1");
	}
	
	@Test(priority=2)
	void tm2()
	{
		System.out.println("This is TestMethod2");
	}
}
