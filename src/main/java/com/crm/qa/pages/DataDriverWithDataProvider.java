package com.crm.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

public class DataDriverWithDataProvider extends TestBase{
	
	DataDriverWithDataProvider pc;

	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='surname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement title;
	
	@FindBy(xpath="//input[@class='button' and @value='Save' and @type='submit'] [1]")
	WebElement saveBtn;
	
	
	public DataDriverWithDataProvider () {
		PageFactory.initElements(driver, this);
	}
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		Thread.sleep(2000);
		LoginPage lgnPage = new LoginPage();
		HomePage homePage = new HomePage();
		 pc = new DataDriverWithDataProvider();
		homePage = lgnPage.login(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(2000);
		switchToFrame("mainpanel");
		homePage.ClickOnNewContacts();
		
	}
	//@DataProvider(name="wordpressData")
	public Object [][] passData(){
	Object [][] data =new Object [2][2] ;
	
	data [0][0] = "admin1";
	data [0][1] = "aaa";
	
	data [1][0] = "admin2";
	data [1][1] = "aaa";
	return data;
	}
	
	
	//@Test(dataProvider="wordpressData")
	public void test41(String ft, String lt) {
		
       driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(ft);
       driver.findElement(By.xpath("//input[@name='surname']")).sendKeys(lt);
		
	}
		
	@DataProvider(name="wordpressData")
	public Object [][] dataWork2() throws Exception{
		
		config conf = new config("/Users/sreejon/eclipse-workspace/pageobjectmodel/src/main/java/com/crm/qa/testdata/EXDATA.xls");
		
		int rows =conf.getRowCount(0);
		
   	Object [][] data = new Object [rows][3];
		
		for (int i=0; i<rows;i++) {
			data [i][0] = conf.getData(0, i, 0);	
			data [i][1] = conf.getData(0, i, 1);	
			data [i][2] = conf.getData(0, i, 2);
  		    
		}
	return data;
	}
	
	@Test(dataProvider="wordpressData")
	public void test412(String ft, String lt,String com) {
		
       driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(ft);
       driver.findElement(By.xpath("//input[@name='surname']")).sendKeys(lt);
       driver.findElement(By.xpath("//input[@name='client_lookup']")).sendKeys(com);
		
	}
	
		
		
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@DataProvider
//	public Object [][] dataWork2() throws Exception{
//		
//		config conf = new config("/Users/sreejon/eclipse-workspace/pageobjectmodel/src/main/java/com/crm/qa/testdata/EXDATA.xls");
//		
//			int rows =conf.getRowCount(0);
//		
//		Object [][] data = new Object [rows][3];
//		
//		for (int i=0; i<rows;i++) {
//			data [i][0] = conf.getData(0, i, 0);
//			data [i][1] = conf.getData(0, i, 1);
//		    data [i][2] = conf.getData(0, i, 2);
//   		    
//		}
//		return data;
//	}
//	
//	@Test(dataProvider="dataWork2")
//	public void createNewContact2(String FirstName,String LastName,String Company) throws InterruptedException {
//		//title.click();
//		
//		Thread.sleep(4000);
//		firstName.sendKeys(FirstName);
//		Thread.sleep(4000);
//		lastName.sendKeys(LastName);
//		Thread.sleep(4000);
//		company.sendKeys(Company);
//		Thread.sleep(4000);
//		saveBtn.click();
//	}


