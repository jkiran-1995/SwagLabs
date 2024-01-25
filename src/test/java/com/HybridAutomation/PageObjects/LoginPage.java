package com.HybridAutomation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(name="user-name")
	WebElement txtUsername;
    @FindBy(name ="password")
    WebElement txtPassword;
    @FindBy(name = "login-button")
    WebElement ClkSubmit;
    
    public void setUserName(String uname) {
    	txtUsername.sendKeys(uname);
    }
    public void setPassword(String pwd) {
    	txtPassword.sendKeys(pwd);
    }
    public void ClickSubmit() {
    	ClkSubmit.click();
    }
}
