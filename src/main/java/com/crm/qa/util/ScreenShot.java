package com.crm.qa.util;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot{
	
	
	
	public static void captureScreenShot(WebDriver driver,String nameOfScreenShot) {
		try {	
	
			// create a TakesScreenshot (interface) variable
	TakesScreenshot ts =(TakesScreenshot)driver;
	
	System.out.println("screenshot taken");
	        // store the screenshot  as file 
	File src =ts.getScreenshotAs(OutputType.FILE);
	        // copy the stored file into a desired file location
	FileUtils.copyFile(src, new File("./ScreenShot/"+ nameOfScreenShot +".png"));
	
		} catch (Exception e) {
		System.out.println("cant take screenshot"+e);
	}
	
	}
	public static void captureScreenShot2(WebDriver driver) {
		try {	
	
			// create a TakesScreenshot (interface) variable
	TakesScreenshot ts =(TakesScreenshot)driver;
	
	System.out.println("screenshot taken");
	        // store the screenshot  as file 
	File src =ts.getScreenshotAs(OutputType.FILE);
	        // copy the stored file into a desired file location
	FileUtils.copyFile(src, new File("./ScreenShot/"+ System.currentTimeMillis() +".png"));
	
		} catch (Exception e) {
		System.out.println("cant take screenshot"+e);
	}
	
	}
}
