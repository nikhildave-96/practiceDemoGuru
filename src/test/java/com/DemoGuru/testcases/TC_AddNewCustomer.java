package com.DemoGuru.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.DemoGuru.pageObjects.AddCustomerPage;
import com.DemoGuru.pageObjects.Guru_LoginPage;

public class TC_AddNewCustomer extends Test_Base_Class {

	@Test
	public void addNewCustomer() throws Exception
	{
		Guru_LoginPage glp = new Guru_LoginPage(driver);
		glp.enterUsername(user);
		logg.info("----- username entered !!!");
		glp.enterpwd(pwd);
		logg.info("----- password entered !!!");
		glp.clickLogin();
		logg.info("----- clicked on login button !!!");
		
	//	Thread.sleep(1000);
		
		AddCustomerPage acp = new AddCustomerPage(driver);
		
		acp.clickNewCust();
		logg.info("----- clicked on AddNewCustomer link !!!");
		acp.name("Nikhil");
		logg.info("----- name entered !!!");
		acp.gender();
		logg.info("----- clicked on gender radio button !!!");
		acp.dob("09", "12", "1996");
		logg.info("----- DOB entered !!!");
		acp.addr("Pune");
		logg.info("----- address entered !!!");
		acp.city("Pune");
		logg.info("----- city entered !!!");
		acp.state("MH");
		logg.info("----- state entered !!!");
		acp.pin("411002");
		logg.info("----- pin entered !!!");
		acp.mobile("8407904638");
		logg.info("----- mobile number entered !!!");
		
		String mailID = getDynEmail()+"@gmail.com";
	//	System.out.println(mailID);
		acp.mail(mailID);
		logg.info("----- email ID entered !!!");
		
		acp.pwd("12345");
		logg.info("----- password entered !!!");
		acp.submit();
		logg.info("----- clicked on submit button !!!");
		
		
		// VERIFICATION 
		String res = driver.findElement(By.xpath("//p[text()='Customer Registered Successfully!!!']")).getText();
	//	System.out.println(res);
		if (res.equalsIgnoreCase("Customer Registered Successfully!!!"))
		{
			Assert.assertTrue(true);
			logg.info("----- addNewCustomer TestCase passed !!!");
		}
		else
		{
			captureScreenshot(driver, "addNewCustomer");
			logg.info("----- addNewCustomer TestCase Failed !!! ");
			Assert.assertTrue(false);
		}
		
		
	}
	
	
}
