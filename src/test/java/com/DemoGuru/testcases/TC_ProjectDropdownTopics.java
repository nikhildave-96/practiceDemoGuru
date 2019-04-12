package com.DemoGuru.testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.DemoGuru.pageObjects.Guru_LoginPage;
import com.DemoGuru.utility.XL_Utility;

public class TC_ProjectDropdownTopics extends Test_Base_Class {

	// try this using dataprovider annotation and excel manipulation
	// try this using array instead of list for fetching project names
	
	@Test
	public void dropdownProjects() throws Exception
	{
		Guru_LoginPage glp = new Guru_LoginPage(driver);
		glp.enterUsername(user);
		logg.info("----- username entered !!!");
		glp.enterpwd(pwd);
		logg.info("----- password entered !!!");
		glp.clickLogin();
		logg.info("----- clicked on signIn button !!!");
		
		List <WebElement> ProjectDD = driver.findElements(By.xpath("//b[@class='caret']/parent::a"));
		List<String> s = new ArrayList<String>();
	
		System.out.println("Below Projects have dropdown topics : ");
		for (WebElement projectdd : ProjectDD) 
		{
			System.out.println(" --- "+projectdd.getText());
			String word = projectdd.getText();
			s.add(word);	
		}
		
		System.out.println();
		System.out.println("Topics in above dropdown projects are  : ");
		for(int i=0;i<s.size();i++)
		{
			System.out.println(" --> "+"'"+s.get(i)+"'"+" section list is as below - ");
			List <WebElement> dropdownContents = driver.findElements(By.xpath("//a[contains(text(),'"+s.get(i)+"')]/following-sibling::ul//li//a"));
			driver.findElement(By.xpath("//b[@class='caret']/parent::a[contains(text(),'"+s.get(i)+"')]")).click();
			for (WebElement DD : dropdownContents) 
			{
				System.out.println(" - "+DD.getText());
			}
			System.out.println();
		}
		
		
		
		
	}
}
