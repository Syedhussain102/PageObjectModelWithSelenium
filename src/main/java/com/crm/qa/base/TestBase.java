package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/sreejon/eclipse-workspace/pageobjectmodel/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
	System.setProperty("webdriver.chrome.driver", "/Users/sreejon/Desktop/develop/drivers/chromedriver");
	driver = new ChromeDriver();
	
	}else if (browserName.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", "/Users/sreejon/Desktop/develop/drivers/geckodriver");
	    driver = new FirefoxDriver();
	    }
		
		e_driver =new EventFiringWebDriver(driver);
		// now create object of eventlisterhandler to register it with eventfirewebdriver
		WebEventListener eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// bring in util class info 
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitTimeOut, TimeUnit.SECONDS);
		// properties info
		driver.get(prop.getProperty("url"));
	}
	
	
	public void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
	}
	public void switchToFrame(int frameIndx) {
		driver.switchTo().frame(frameIndx);
	}

}
