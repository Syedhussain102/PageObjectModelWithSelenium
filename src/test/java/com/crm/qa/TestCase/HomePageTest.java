package com.crm.qa.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.tasksPage;

public class HomePageTest extends TestBase{
	LoginPage lgnPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	tasksPage TasksPage;
	public HomePageTest() {super();}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		Thread.sleep(2000);
		lgnPage = new LoginPage();
		homePage = lgnPage.login(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(2000);
	}
	@Test(priority =1)
	public void verifyHomePageTitleTest() {
		String HomePageTitle = homePage.ValidateHomePageTitle();
		String HompageTitleExpcted = "CRMPRO"; 
		Assert.assertEquals(HomePageTitle,HompageTitleExpcted, "Actual Title was not Matched With Expected Title" );
	}  
	@Test()
	public void verifyUserNameTest() throws Exception {
		switchToFrame("mainpanel");
		Assert.assertTrue(homePage.verifyUserName());
	}
	@Test()
	public void ClickOnContactsTest() {
		switchToFrame("mainpanel");
		contactsPage = homePage.ClickOnContacts();
	}
	@Test()
	public void ClickOnDealsTest() {
		switchToFrame("mainpanel");
		dealsPage = homePage.ClickOnDeals();
	}
	@Test()
	public void ClickOnTasksTest() {
		switchToFrame("mainpanel");
		TasksPage = homePage.ClickOnTasks();
	}
	@Test()
	public void VerifyContactsTest() {
		switchToFrame("mainpanel");
		//Assert.assertTrue(homePage.verifyContactsLable1());
		
	}
	

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
