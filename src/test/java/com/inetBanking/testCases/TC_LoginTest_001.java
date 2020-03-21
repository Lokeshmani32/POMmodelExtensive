package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	
	
		
		
		@Test
		public void loginTest() throws IOException 
		{
			
			driver.get(baseURL); 
			Logger.info("url is opened");
			
			LoginPage lp = new LoginPage(driver);
			
			lp.setUserName(username);
			Logger.info("username is done");
			lp.setPassword(password);
			Logger.info("password is done");
			lp.clickSubmit();
			Logger.info("test passed");
		    if(driver.getTitle().equals("Guru99 Bank Manager HomePage "))
			{
			Assert.assertTrue(true);
			}
			else
			{
				captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			}
	 }

}
