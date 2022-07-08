package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FooterLinks {	
	public WebDriver driver;	
	public FooterLinks(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	By footerLink = By.cssSelector("div[id='gf-BIG']");
	By columnlink = By.xpath(".//*[@id='gf-BIG']/table/tbody/tr/td[1]/ul");
	
	By columnLinks = By.tagName("a");
	
	public WebElement FooterLink()
	{
		return driver.findElement(footerLink);		
	}
	public WebElement Columnlink()
	{
		return driver.findElement(columnlink);		
	}
	public int getfooterlinkSize()
	{	
		return FooterLink().findElements(columnLinks).size();		
	}
	public int getcolumnlinkSize()
	{	
		return Columnlink().findElements(columnLinks).size();		
	}	
	public void getWindowHandler() throws InterruptedException
	{
		for(int i=1;i<getcolumnlinkSize();i++)
	    {
	    String clickonlinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
	    Columnlink().findElements(columnLinks).get(i).sendKeys(clickonlinkTab);
	    Thread.sleep(5000);
	    }
	    Set<String> countwindow = driver.getWindowHandles();
	    Iterator<String> it=countwindow.iterator();
	    while(it.hasNext()){
	    driver.switchTo().window(it.next());
	    System.out.println(driver.getTitle());
	    }
	}
}
