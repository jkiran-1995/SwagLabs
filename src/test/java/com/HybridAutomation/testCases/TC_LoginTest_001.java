package com.HybridAutomation.testCases;

import org.testng.annotations.Test;

import com.HybridAutomation.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() {
		driver.get(BaseURL);
		logger.info("URL is Opened");
		LoginPage Lp = new LoginPage(driver);
		Lp.setUserName(Username);
		logger.info("Username is Entered");
		Lp.setPassword(Password);
		logger.info("Password is Entered");
		Lp.ClickSubmit();
		logger.info("Clicked on Login button");
	}

}
