package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RSARegister {
	
	public WebDriver driver;
	
	public RSARegister(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By register = By.xpath("(//div[@class='login-btn']//a)[1]");
	
	By FullName = By.xpath("//input[@id='user_name']");
	By Email  = By.xpath("//input[@id='user_email']");
	By Password = By.xpath("//input[@id='password']");
	
	By allowEmails = By.xpath("//input[@id='allow_marketing_emails']");
	
	By SignUp = By.xpath("//input[@name='commit']");
	
	
	public WebElement Register()
	{
		return driver.findElement(register);
	}
	
	public WebElement FullName()
	{
		return driver.findElement(FullName);
	}
	
	public WebElement Email()
	{
		return driver.findElement(Email);
	}
	
	public WebElement Password()
	{
		return driver.findElement(Password);
	}
	
	public WebElement allowEmails()
	{
		return driver.findElement(allowEmails);
	}
	
	public WebElement SignUp()
	{
		return driver.findElement(SignUp);
	}
	

}
