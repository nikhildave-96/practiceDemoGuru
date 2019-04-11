package com.DemoGuru.testcases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.DemoGuru.utility.ReadConfig;

/*	 -  This class contains all the common supported methods needed for our suite.
	 -  Methods of this class can be called inside any desired testcase as 
		every testcase/testcase class extends test base class. 
	   
*/
public class Test_Base_Class  {

	public WebDriver driver;
	public Logger logg;
	
	ReadConfig read = new ReadConfig();
	String appURL = read.getURL();
	String user = read.getUname();
	String pwd = read.getPWD();
	
	
	@BeforeClass
	public void setup()
	{
		logg  = Logger.getLogger("GuruDemo99");
		PropertyConfigurator.configure("log4j.properties");
		
		String Cpath = "../practice_DemoGuru99/Drivers/chromedriver.exe";
		String Fpath = "../practice_DemoGuru99/Drivers/geckodriver.exe";
		
		if(read.getBrowser().equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", Cpath);
			driver = new ChromeDriver();
		}
		
		else if(read.getBrowser().equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", Fpath);
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	driver.manage().window().maximize();
		
		driver.get(appURL);
		logg.info("----- navigated to URL !!!");
	}
	
	
	@AfterClass
	public void terminate()
	{
		driver.quit();
	}
	
	
	public void captureScreenshot(WebDriver driver, String testcaseNAME) throws Exception
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path2save = System.getProperty("user.dir")+"\\Screenshots\\"+testcaseNAME+".png";
		File destination = new File(path2save);
		FileUtils.copyFile(src, destination);
		logg.warn("----- screenshot captured !!!");
	//	System.out.println("    -----------------   Screenshot Taken   ");
		
	}
	
	
	public static String getDynEmail()
	{
		String email =RandomStringUtils.randomAlphabetic(5);
		return email;
	}
}
