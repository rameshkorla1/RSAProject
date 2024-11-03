package RSAFunctionalTests;

import java.io.IOException;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.JsonReader;
import pageObjects.RSARegister;
import resources.base;

public class RSASignUpJson extends base {
	
	RSARegister register;
	@BeforeTest
	public void browserSetUp() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("AppURL"));
	}
	
	@Test(dataProvider="Register")
	public void validateUserRegister(String fullName, String email, String password) throws IOException, Exception
	{
		register = new RSARegister(driver);
		register.Register().click();
		
		register.FullName().sendKeys(fullName);
		Thread.sleep(2000);
		register.Email().sendKeys(email);
		Thread.sleep(2000);
		register.Password().sendKeys(password);
		Thread.sleep(2000);
		register.SignUp().click();
		Thread.sleep(2000);
		
		
	}
	
	@DataProvider(name="Register")
	public Object[][] passData() throws IOException
	{
		//return JsonReader.getJSONdata(AppConfig.getJsonPath()+"Registration.json", "Registration Data",3);
		return JsonReader.getdata("./testData/"+"register.json", "register",2 , 3);
	}
	
	@AfterTest
	public void quitBrowser()
	{
		driver.quit();
	}
	

}
