 package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	//PageFactory - OR
	
	@FindBy(xpath="//input[@name='username']")
	
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[@class='btn']")
	WebElement signUp;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	// initialize page object with the help of page factory by creating constructor 
	//you can you 'LoginPage.class' instead of 'this'
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validateCrmImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un,String ps) {
		username.sendKeys(un);
		password.sendKeys(ps);
		loginBtn.click();
		return new HomePage();
	}

}
