package day40;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertion {
	
//	@Test
	void hardAssertion()
	{
		System.out.println("testign....");
		System.out.println("testign....");
		
		Assert.assertEquals(1, 2);
		
		System.out.println("testign....");
		System.out.println("testign....");
	}
	
	@Test
	void softAssertion()
	{
		System.out.println("testign....");
		System.out.println("testign....");
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(1, 2);
		
		System.out.println("testign....");
		System.out.println("testign....");
		
		sa.assertAll();  //mandatory while executing soft assertion
	}
}
