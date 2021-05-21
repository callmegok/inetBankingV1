package com.inetbanking.testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass 
{

	@Test
	public void loginTest()
	{
		driver.get(baseURL);
		logger.info("URL is opened");
		
		
		LoginPage lp= new LoginPage(driver);
		ExtentTest test=extent.createTest("Login test");
		lp.setUserName(username);
		logger.info("username is entered");
		lp.setPassword(password);
		logger.info("password is entered");
		lp.clickSubmit();
		String name= driver.getTitle();
		System.out.println(name);
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login is passed");
		}
		else
			
		{
			Assert.assertTrue(false);
			logger.info("Logging failed");
		}
		
		
	}
	
	
	
	
	
	
}
