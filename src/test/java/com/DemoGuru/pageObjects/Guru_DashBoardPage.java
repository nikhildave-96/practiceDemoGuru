package com.DemoGuru.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru_DashBoardPage {

	WebDriver ldriver;
	
	public Guru_DashBoardPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy (xpath = "//ul[@class='menusubnav']/li")
	List <WebElement> menuLinks;
	
	
	public void menuList()
	{
		System.out.println("Menu has following options as hyperlinks : ");
		for (WebElement ele : menuLinks) 
		{
			System.out.println(" ----- "+ele.getText());
		}
		
	}
}
