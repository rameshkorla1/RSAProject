package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import ExtentReports.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {
public static WebDriver driver;
public Properties prop;
public static WebDriverWait wait;
public WebDriver initializeDriver() throws IOException
{	
  prop= new Properties();
  String path = System.getProperty("user.dir")+"/src/main/java/resources/data.properties";
  FileInputStream fis=new FileInputStream(path);
  prop.load(fis);
  String browserName=prop.getProperty("browser");
  //String browserName=System.getProperty("browser");
  System.out.println(browserName);
  if(browserName.equals("chrome"))
  {
	  //execute in chrome driver	
	  WebDriverManager.chromedriver().setup();
	  driver= new ChromeDriver();	
  }
  else if (browserName.equals("firefox"))
  {
	//firefox code
	  WebDriverManager.firefoxdriver().setup();
	  driver= new FirefoxDriver();	
  }
  else if (browserName.equals("IE"))
  {
      //	IE code
  }
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.manage().window().maximize();
  return driver;
}
public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
	//String png= System.currentTimeMillis()+ ".png";
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+formater.format(calendar.getTime())+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	
	return destinationFile;
}
@SuppressWarnings("resource")
public static synchronized String takeScreenshot(String methodName) {

    DateFormat dateFormat = new SimpleDateFormat("MMM_dd_yyyy_HH_mm_ss_SSS");
    Date date = new Date();
    String dateName = dateFormat.format(date);    
    String OUTPUT_FOLDER_SCREENSHOTS = "/Screenshots/";
	String filePathExtent = OUTPUT_FOLDER_SCREENSHOTS  + "Web"+ methodName + "_" + dateName + ".png";
    String filePath = ExtentManager.getReportBaseDirectory() + filePathExtent;
    String encodedBase64=null;
    try {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileInputStream fileInputStreamReader ;
        fileInputStreamReader = new FileInputStream(screenshotFile);
        byte[] bytes = new byte[(int) screenshotFile.length()];
        fileInputStreamReader.read(bytes);
        encodedBase64 = Base64.encodeBase64String(bytes);
        FileUtils.copyFile(screenshotFile, new File(filePath));
    }catch (IOException e){
        e.getStackTrace();
        Reporter.log("Failed To Take screenshot " + e, true);
    }
    return encodedBase64;
}

public void waitForPrenceOfElement(By locator)
{
	wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
}
public String takefullScreenshot(String testCaseName) throws IOException
{
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
	Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	String path = System.getProperty("user.dir")+"\\screenshots\\"+testCaseName+formater.format(calendar.getTime())+".png";
    ImageIO.write(s.getImage(),"PNG",new File(""));
	return path;
}
public static String takefull_Screenshot(String screenShotName) throws Exception
{
    Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
    String dest = System.getProperty("user.dir") + "/screenshots/" + screenShotName + ".png";
    ImageIO.write(screenshot.getImage(),"PNG",new File(dest));
    return dest;
}
}
