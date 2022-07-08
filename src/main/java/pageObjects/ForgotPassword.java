package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import resources.base;

public class ForgotPassword {

	base b= new base();
	public WebDriver driver;
	
	By email=By.cssSelector("[id='user_email']");
	By sendMeInstructions=By.cssSelector("[type='submit']");
	
	public ForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement getEmail()
	{
		b.waitForPrenceOfElement(email);
		return driver.findElement(email);
	}
	
	public WebElement sendMeInstructions()
	{
		return driver.findElement(sendMeInstructions);
	}
	
	

	
	
}
