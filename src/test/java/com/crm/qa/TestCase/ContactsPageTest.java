package com.crm.qa.TestCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.config;

public class ContactsPageTest extends TestBase {
	
	LoginPage lgnPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public ContactsPageTest() {super();}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		Thread.sleep(2000);
		lgnPage = new LoginPage();
		homePage = lgnPage.login(prop.getProperty("username"),prop.getProperty("password"));
		contactsPage = new ContactsPage();
		Thread.sleep(2000);
		
		switchToFrame("mainpanel");
		homePage.ClickOnNewContacts();
	}
	
	//@Test
	public void createNewContactTest() {
		homePage.ClickOnNewContacts();
		contactsPage.createNewContact("Mr.", "mashrafee", "mortuza", "Captain");
		
	}
	@DataProvider(name="workPressData")
	public Object [][] dataWork2() throws Exception{
		
		config conf = new config("/Users/sreejon/eclipse-workspace/pageobjectmodel/src/main/java/com/crm/qa/testdata/EXDATA.xls");
		
			int rows =conf.getRowCount(0);
		
		Object [][] data = new Object [rows][4];
		
		for (int i=0; i<rows;i++) {
			data [i][0] = conf.getData(0, i, 0);
			data [i][1] = conf.getData(0, i, 1);
		    data [i][2] = conf.getData(0, i, 2);
   		    data [i][3] = conf.getData(0, i, 3);
		}
		return data;
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
