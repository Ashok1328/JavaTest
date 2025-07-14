package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPolicy;
	
	@FindBy(xpath="//button[normalize-space()='continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Creatd!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void setPrivacyPolicy()
	{
		chkPolicy.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
//	sol2
//	btnContinue.submit();
//	
//	sol3
//	Actions act = new Actions(driver);
//	act.moveToElement(btnContinue).click().perform();
//	
//	sol4
//	JavascriptExecutor js= (JavasriptExecutor)driver;
//	js.executorScript("arguments[0].click();",btnContinue);
//	
//	sol5
//	btnContinue.sendKeys(Keys.RETURN);
//	
//	sol6
//	WebDriverWait mywait = new WebDriverWait(Driver, Duration.OfSeconds(10));
//	mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	
	public String getConfirmationMsg()
	{
		try
		{
			return(msgConfirmation.getText());
		} catch (Exception e)
		{
			return(e.getMessage());
		}
	}
	
}
