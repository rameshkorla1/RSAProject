package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FlightHomePage {

	public WebDriver driver;

	 By Departure = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
	 By Currency = By.id("ctl00_mainContent_DropDownListCurrency");
	 By Passenger = By.id("divpaxinfo");

	 By PassengerIncAdult = By.xpath(".//*[@id='hrefIncAdt']");

	 By PassengerIncChild = By.xpath(".//*[@id='hrefIncChd']");

	 By PassengerIncInfant = By.xpath("//*[@id='hrefIncInf']");

	 By PassengerDone = By.id("btnclosepaxoption");


	public FlightHomePage(WebDriver driver) {

	    this.driver = driver;
	}

	public void SelectDeparture(String DepCity) {
		WebElement From = driver.findElement(Departure);
		From.click();
		driver.findElement(By.xpath("//a[@value= '"+DepCity+"']")).click();
		System.out.println("Selected flight is"+From.getAttribute("selectedtext"));
		Assert.assertTrue(From.getAttribute("selectedtext").contains(DepCity), "Wrong city selected Expected "+DepCity+" found "+From.getAttribute("selectedtext"));
	}
	public void SelectPassenger(int adult, int child, int infant) throws InterruptedException {

		driver.findElement(By.xpath(".//*[@id='divpaxinfo']")).click();
		Thread.sleep(3000);
		for(int i=0;i<driver.findElements(PassengerIncAdult).size();i++ )
	    {
	      driver.findElement(PassengerIncAdult).click();        
	    }
	    int j=0;
	    for(j=0;j<driver.findElements(PassengerIncChild).size();j++ )
	    {
	      driver.findElement(PassengerIncChild).click();           
	    }
	    if(j==3)
	    {
	      driver.findElement(By.xpath(".//*[@id='hrefIncChd']")).click();
	    }
	    for(int k =0; k<driver.findElements(PassengerIncInfant).size();k++) {
	    	driver.findElement(PassengerIncInfant).click();
	    	}
	    int k=0;
	    if(k==4)
	    {
	    	driver.findElement(PassengerIncInfant).click();
	    }
	    	driver.findElement(PassengerDone).click();
	    Thread.sleep(4000);
	}
	
	public void selectCurrency(String currency) throws InterruptedException
	{
		Thread.sleep(4000);
		WebElement Curr = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select Currency = new Select(Curr);
		Currency.selectByValue(currency);
		
	}
}
