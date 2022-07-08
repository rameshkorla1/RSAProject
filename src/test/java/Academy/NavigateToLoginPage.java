package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

@Listeners(Academy.TestListener.class)
public class NavigateToLoginPage extends base {
	 public static Logger log =LogManager.getLogger(base.class.getName());
	 @BeforeTest
	 public void initialize() throws IOException
	 {	 	
	 	 driver =initializeDriver();		
	 	 driver.get(prop.getProperty("url"));
	 }	 	
	 @Test	 	
	 public void validateAppNavBar() throws IOException
	 {
	      LandingPage l=new LandingPage(driver);
	 	  if(l.getPopUpSize()>0)
		  {
				l.getPopUp().click();
		  }
		  l.getLogin().click(); 	 		
	 }	 	
	 @AfterTest
	 public void teardown()
	 {	 		
	 	 driver.close();
	 	 driver=null;	 		
	 }
}
