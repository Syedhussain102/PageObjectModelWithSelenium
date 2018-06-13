package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: Syed Hussain')]")
	WebElement user;

	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLable;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContacts;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String ValidateHomePageTitle() {
		return driver.getTitle();
	}
	public boolean verifyUserName() {
		return user.isDisplayed();
	}
	public ContactsPage ClickOnContacts() {
		contactsLink.click();
		return new ContactsPage();
	}
	public DealsPage ClickOnDeals() {
		dealsLink.click();
		return new DealsPage();
	}
	public tasksPage ClickOnTasks() {
		tasksLink.click();
		return new tasksPage();
	}
	public boolean verifyContactsLable1() {
		return contactsLable.isDisplayed();
	}
	public ContactsPage ClickOnNewContacts() {
		Actions action = new Actions (driver);
		action.moveToElement(contactsLink).build().perform();
		newContacts.click();
		
		return new ContactsPage();
	}
}
