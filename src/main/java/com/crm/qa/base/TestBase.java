package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.browser.Browser;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;


public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() 
	{
		try {
		
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\Shri\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(ip);
		
		}
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	public static void initialization()
	{
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
		} else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\Softwares\\chromedriver_win32\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT1, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT1, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
