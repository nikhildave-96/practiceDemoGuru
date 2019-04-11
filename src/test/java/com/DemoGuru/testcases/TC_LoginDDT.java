package com.DemoGuru.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.DemoGuru.pageObjects.Guru_LoginPage;
import com.DemoGuru.utility.XL_Utility;

public class TC_LoginDDT extends Test_Base_Class {

	/* data from excel file is stored in an array and we provide it to test method 
	   using 'dataProvider' as a parameter with its specific name
	 
	   data is stored and kept inside an array inside a method having '@DataProvider' 
	   as an annotation---- This method returns data in array
	 */
	
	@Test (dataProvider="LoginData")		// dataProvider as a parameter 
	public void testing(String u,String p) throws Exception
	{
		Guru_LoginPage glp = new Guru_LoginPage(driver);
		glp.enterUsername(u);
		logg.info("----- username entered !!!");
		glp.enterpwd(p);
		logg.info("----- password entered !!!");
		glp.clickLogin();
		logg.info("----- clicked on login button !!!");
		
		Thread.sleep(3000);
		if(alertInfo()==true)
		{
			
			driver.switchTo().alert().accept();		// Login fail alert ---- invalid data case
			driver.switchTo().defaultContent();
			
			logg.warn("----- testing testcase failed !!!");
			captureScreenshot(driver, "testing");
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			logg.info("----- testing testcase passed !!!");
			glp.clicklogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();		// Logout alert post successful login ---- valid data case
			driver.switchTo().defaultContent();
		}
	}
	
	
	public boolean alertInfo()
	{
		try 
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	@DataProvider(name ="LoginData")		// DataProvider as an annotation 
	public String [][] sendData() throws Exception
	{
		String filepath = "../practice_DemoGuru99/src/test/java/com/DemoGuru/testData/DDTdata.xlsx";
		
		int rc = XL_Utility.getrowcount(filepath, "TestData");		// method is public and static so can be called anywhere with syntax as >>>> classname.methodname
		
		int cc = XL_Utility.getColcount(filepath, "TestData", 1); 	// method is public and static so can be called anywhere with syntax as >>>> classname.methodname
		
		String [][] data = new String [rc][cc];
		for (int i =1 ;i<=rc;i++)
		{
			for(int j =0;j<cc;j++)
			{
				data[i-1][j] = XL_Utility.getCellData(filepath, "TestData", i, j);		// method is public and static so can be called anywhere with syntax as >>>> classname.methodname
			}
		}
		return data;
	}
	
}
