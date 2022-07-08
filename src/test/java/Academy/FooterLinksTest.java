package Academy;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.FooterLinks;
import resources.base;

public class FooterLinksTest extends base  {
	
	FooterLinks fl;	
	@BeforeTest
	public void BrowserSetUp() throws IOException
	{
		driver =initializeDriver();
		driver.get(prop.getProperty("url1"));
	}
	@Test
	public void footerLinksvalidation() throws InterruptedException
	{
		fl = new FooterLinks(driver);
		fl.getWindowHandler();
	}
}
