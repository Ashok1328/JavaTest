package day41;

import org.testng.annotations.Test;

public class PaymentTest {
	
	@Test(priority=1, groups= {"sanity", "regression","functional"})
	void paymentInRupees()
	{
		System.out.println("This is payment in rupees");
	}
	
	@Test(priority=2, groups= {"sanity", "regression","functional"})
	void paymentInDollars()
	{
		System.out.println("This is payment in dollars");
	}
}
