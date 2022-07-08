package FlightTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.FlightHomePage;
import resources.base;

public class BookingTest extends base{

	public WebDriver driver;
	FlightHomePage FHP; //= new FlightHomePage(driver);
	@BeforeTest
	public void BrowserSetup() throws IOException
	{
		driver =initializeDriver();
		driver.get(prop.getProperty("url2"));
	}
	
	@Test
	public void booking() throws InterruptedException {
		FHP = new FlightHomePage(driver);
		FHP.SelectPassenger(1, 1, 1);
		FHP.selectCurrency("USD");
	}
}
