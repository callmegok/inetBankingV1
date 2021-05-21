package com.inetbanking.testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_2 extends BaseClass 
{

	@Test
	public void loginTest()
	{
		driver.get(baseURL);
		
		
		LoginPage lp= new LoginPage(driver);
		extent.createTest("Password test");
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		String name= driver.getTitle();
		System.out.println(name);
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
		}
		else
			
		{
			Assert.assertTrue(false);
		}
		
		
	}
	
	
	
	
	
	
}
