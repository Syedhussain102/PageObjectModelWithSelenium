package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;


import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='surname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath="//input[@class='button' and @value='Save' and @type='submit'] [1]")
	WebElement saveBtn;
	
	
	public ContactsPage () {
		PageFactory.initElements(driver, this);
	}
	
	
	public void createNewContact(String title,String ftname,String ltname,String com) {
		Select select = new Select(driver.findElement(By.xpath("//select[@name='title']")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftname);
		lastName.sendKeys(ltname);
		company.sendKeys(com);
		saveBtn.click();
	}
	@DataProvider(name="workPressData")
	public Object [][] dataWork2() throws Exception{
		
		config conf = new config("/Users/sreejon/eclipse-workspace/pageobjectmodel/src/main/java/com/crm/qa/testdata/EXDATA.xls");
		
			int rows =conf.getRowCount(0);
		
		Object [][] data = new Object [rows][3];
		
		for (int i=0; i<rows;i++) {
			data [i][0] = conf.getData(0, i, 0);
			data [i][1] = conf.getData(0, i, 1);
			data [i][2] = conf.getData(0, i, 2);
			data [i][3] = conf.getData(0, i, 3);
		}
		return data;
	}
	
	public void createNewContact2(String Title,String FirstName,String LastName,String Company) {
		Select select = new Select(driver.findElement(By.xpath("//select[@name='title']")));
		
		select.selectByVisibleText(Title);
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		company.sendKeys(Company);
		saveBtn.click();
	}
	
	
	
}
