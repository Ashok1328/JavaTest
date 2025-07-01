package day39;

import org.testng.annotations.Test;

public class TestCase {

	@Test(priority=1)
		void openApp()
		{
			System.out.println("Opening application ...");
		}
		
	@Test(priority=2)
		void login()
		{
			System.out.println("Loging to application....");
		}
		
	@Test(priority=3)
		void logout()
		{
			System.out.println("Logout from application");
		}
}
