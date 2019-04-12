package com.DemoGuru.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.DemoGuru.pageObjects.Guru_DashBoardPage;
import com.DemoGuru.pageObjects.Guru_LoginPage;
import com.DemoGuru.pageObjects.InsuranceProjectPage;

public class TC_InsuranceProjectRegister extends Test_Base_Class{

	
	@Test
	public void InsuranceRegisterTest()
	{
		Guru_LoginPage glp = new Guru_LoginPage(driver);
		glp.enterUsername(user);
		logg.info("----- username entered !!!");
		glp.enterpwd(pwd);
		logg.info("----- password entered !!!");
		glp.clickLogin();
		logg.info("----- clicked on signIn button !!!");
		
		Guru_DashBoardPage gdp = new Guru_DashBoardPage(driver);
		gdp.clickInsurance();
		logg.info("----- clicked on Insurance Project !!!");
		
		InsuranceProjectPage ip = new InsuranceProjectPage(driver);
		ip.clickonReg();
		logg.info("----- clicked on Register button !!!");
		ip.setTitle("Doctor");
		logg.info("----- Title value set !!!");
		ip.enterName("Nikhil");
		logg.info("----- name entered !!!");
		ip.entersurName("Dave");
		logg.info("----- surname entered !!!");
		ip.entermobile("8208005459");
		logg.info("----- phone entered !!!");
		ip.setDOBday("9");
		logg.info("----- DOB day value set !!!");
		ip.setDOBmonth("December");
		logg.info("----- DOB month value set !!!");
		ip.setDOByear("1993");
		logg.info("----- DOB year value set !!!");
		ip.setLicenseType("Provisional");
		logg.info("----- License value set !!!");
		ip.setlicYears("12");
		logg.info("----- License period value set !!!");
		ip.setOccu("Statistician");
		logg.info("----- Occupation value set !!!");
		ip.enterStreet("257, Shukrawar Peth");
		logg.info("----- Street address entered !!!");
		ip.entercity("Pune");
		logg.info("----- City address entered !!!");
		ip.enterCountry("India");
		logg.info("----- Country address entered !!!");
		ip.enterPIN("411002");
		logg.info("----- pin code entered !!!");
		
		String mailID = getDynEmail();
		ip.enterEmail(mailID);
		logg.info("----- "+"' "+mailID+" '"+" email entered !!!");
		
		ip.enterpwd("Demo@12345");
		logg.info("----- password entered !!!");
		ip.entercpwd("Demo@12345");
		logg.info("----- password re-entered !!!");
		ip.clickonCreate();
		logg.info("----- clicked on create button !!!");
		
		
		
		// Verification part of testcase
		if(driver.findElement(By.xpath("//h3[text()='Login']")).getText().equalsIgnoreCase("login"))
		{
			logg.info("----- text verified, New profile registered !!!");
			logg.info("----- trying sign in with new profile .....");
			ip.enterUsername(mailID);
			logg.info("----- UserID entered !!!");
			ip.enterUserpwd("Demo@12345");
			logg.info("----- Userpassword entered !!!");
			ip.clickonLogin();
			logg.info("----- clicked on login button !!!");
			
			boolean lnk = driver.findElement(By.linkText("Request Quotation")).isDisplayed();
			if(lnk == true)
			{
				Assert.assertTrue(true);
				logg.info("----- successfully signed in with new profile credentials, testcase passed !!!");
			}
			else
			{
				logg.warn("----- Profile registered, Login with new profile Failed !!!");
				Assert.assertTrue(false);
			}
		}
		else 
		{
			logg.warn("----- Profile not registered, InsuranceRegisterTest testcase failed !!!");
			Assert.assertTrue(false);
		}
		
		
	
	}
}
