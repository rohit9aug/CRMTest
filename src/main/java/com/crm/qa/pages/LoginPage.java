package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	//Page Factory - OR;
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[contains(text(),'Sign Up')]")
	WebElement SignUpBtn;
	
	@FindBy(xpath="//a[contains(@class,'navbar-brand')]")
	WebElement Logo1;
	
	//Initializing objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this); 
	}
	
	//Actions
	public String validateLoginPage()
	{
		return driver.getTitle();
		
	}
	
	public boolean validateCRMImage(){
		return Logo1.isDisplayed();
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	
	public HomePage login(String un, String pass)
	{
		username.sendKeys(un);
		password.sendKeys(pass);
		loginBtn.click();
		return new HomePage();
		
		
	}
	
	
	

}
