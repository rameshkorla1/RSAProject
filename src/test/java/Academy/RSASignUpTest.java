package Academy;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ExcelUtilities.Constants;
import ExcelUtilities.ExcelUtils;
import pageObjects.RSARegister;
import resources.base;

public class RSASignUpTest extends base{
	
	//creating object of ExcelUtils class
    static ExcelUtils excelUtils = new ExcelUtils();    
    //using the Constants class values for excel file path 
    static String excelFilePath =Constants.Path_TestData+Constants.File_TestData;
	
	RSARegister register;
	@BeforeTest
	public void browserSetUp() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("AppURL"));
	}
	
	@Test
	public void validateUserRegister() throws IOException, Exception
	{
		register = new RSARegister(driver);
		register.Register().click();
		excelUtils.setExcelFile(excelFilePath, "Sheet1");
		for(int i=1;i<=excelUtils.getRowCountInSheet();i++)
		{
			register.FullName().sendKeys(excelUtils.getCellData(i, 0));
			Thread.sleep(2000);
			register.Email().sendKeys(excelUtils.getCellData(i, 1));
			Thread.sleep(2000);
			register.Password().sendKeys(excelUtils.getCellData(i, 2));
			Thread.sleep(2000);
			register.SignUp().click();
			Thread.sleep(2000);
		}
		
	}
	
	@AfterTest
	public void quitBrowser()
	{
		driver.quit();
	}
	

}
