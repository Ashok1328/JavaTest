package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLoginPage extends BasePage {
	
	public AccountLoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	public void EmailAddress(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void Password(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void ClickLogin()
	{
		btnLogin.click();
	}
}
