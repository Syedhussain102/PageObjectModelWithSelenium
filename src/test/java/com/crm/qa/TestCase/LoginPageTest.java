package com.crm.qa.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage lgnPage;
	HomePage homePage;
	public LoginPageTest() {super();}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		lgnPage = new LoginPage();
		
	}
	@Test(priority=1)
	public void LoginPageTitleTest() throws Exception {
		String title = lgnPage.ValidateLoginPageTitle();
		Thread.sleep(2000);
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
	}
	@Test(priority=2)
	public void crmLogoImageTest() throws Exception {
		boolean flag =lgnPage.validateCrmImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest() {
		homePage =lgnPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
