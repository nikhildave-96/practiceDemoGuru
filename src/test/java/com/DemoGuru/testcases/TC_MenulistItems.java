package com.DemoGuru.testcases;

import org.testng.annotations.Test;

import com.DemoGuru.pageObjects.Guru_DashBoardPage;
import com.DemoGuru.pageObjects.Guru_LoginPage;

public class TC_MenulistItems extends Test_Base_Class {

	
	@Test
	public void getmenulist()
	{
		Guru_LoginPage glp = new Guru_LoginPage(driver);
		
		glp.enterUsername(user);
		logg.info("----- username entered !!!");
		glp.enterpwd(pwd);
		logg.info("----- password entered !!!");
		glp.clickLogin();
		logg.info("----- clicked on signIn button !!!");
		
		Guru_DashBoardPage gdp = new Guru_DashBoardPage(driver);
		gdp.menuList();
		logg.info("----- Fetched all the names present inside menu list !!!");
	}
}
