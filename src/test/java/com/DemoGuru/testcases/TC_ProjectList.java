package com.DemoGuru.testcases;

import org.testng.annotations.Test;

import com.DemoGuru.pageObjects.Guru_DashBoardPage;
import com.DemoGuru.pageObjects.Guru_LoginPage;

public class TC_ProjectList extends Test_Base_Class{
	
	@Test
	public void projectList()
	{
		Guru_LoginPage glp = new Guru_LoginPage(driver);
		
		glp.enterUsername(user);
		logg.info("----- username entered !!!");
		glp.enterpwd(pwd);
		logg.info("----- password entered !!!");
		glp.clickLogin();
		logg.info("----- clicked on signIn button !!!");
		
		Guru_DashBoardPage gdp = new Guru_DashBoardPage(driver);
		gdp.getprojectType();
		logg.info("----- Above are the types of projects present on dashboard !!!");
	}

	
}
