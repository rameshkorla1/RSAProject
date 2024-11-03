package RSAFunctionalTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;
import static reportmanager.ExtentTestManager.reporterLog;

@Listeners(CustomerListeners.RSAListener.class)
public class NavigateToLoginPage extends base {
	 public static Logger log =LogManager.getLogger(base.class.getName());
	 @BeforeTest
	 public void initialize() throws IOException
	 {	 	
	 	 driver =initializeDriver();
	 	 reporterLog("Initialize the Driver:" +driver);
	 	 driver.get(prop.getProperty("url"));
	 	 reporterLog("Launching the URL:" +prop.getProperty("url"));
	 }	 	
	 @Test	 	
	 public void validateAppNavBar() throws IOException
	 {
	      LandingPage l=new LandingPage(driver);
	 	  if(l.getPopUpSize()>0)
		  {
	 		 reporterLog("Popup is displayed");
				l.getPopUp().click();
				reporterLog("Popup window is clicked");
		  }
		  l.getLogin().click(); 
		  reporterLog("Click on the Login button");
	 }	 	
	 @AfterTest
	 public void teardown()
	 {	 		
	 	 driver.close();
	 	reporterLog("Driver is closed");
	 	 driver=null;	 		
	 }
}
