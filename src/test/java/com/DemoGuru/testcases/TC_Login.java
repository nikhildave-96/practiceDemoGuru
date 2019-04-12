package com.DemoGuru.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.DemoGuru.pageObjects.Guru_LoginPage;
import com.DemoGuru.utility.XL_Utility;

public class TC_Login  extends Test_Base_Class {

	
	@Test
	public void Login() throws Exception
	{
		Guru_LoginPage glp = new Guru_LoginPage(driver);
		
		glp.enterUsername(user);
		logg.info("----- username entered !!!");
		glp.enterpwd(pwd);
		logg.info("----- password entered !!!");
		glp.clickLogin();
		logg.info("----- clicked on signIn button !!!");
		
//		XL_Utility.setCellData("./src\\test\\java\\com\\DemoGuru\\testData\\DDTdata.xlsx", "Emails", 4, 4, "Hello");
		
		// Verification Part of test case
		String text = driver.findElement(By.xpath("//h2[@class='barone']")).getText();
		if(text.equalsIgnoreCase("guru99 bank"))
		{
			logg.info("----- demoLogin testcase passed !!!");
			Assert.assertTrue(true);		// can be anywhere inside the loop
		}
		else
		{
			logg.warn("----- demoLogin testcase failed !!!");
			captureScreenshot(driver,"demoLogin");
			Assert.assertTrue(false);		// should always be the last statement as flow ahead of this st does not execute
		}
		
	}
	
}
