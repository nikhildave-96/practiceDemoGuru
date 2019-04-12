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
	
	@FindBy (xpath = "//li[@class='dropdown']/a")
	List <WebElement> ProjectTypes;
	
	@FindBy (xpath = "//a[contains(text(),'Selenium')]/following-sibling::ul//li//a")
	List <WebElement> dropdownContents;
	
	@FindBy (xpath = "//b[@class='caret']/parent::a")
	List <WebElement> ProjectDD;
	
	@FindBy (xpath = "//b[@class='caret']/parent::a/following-sibling::ul/li/a")
	List <WebElement> AlldropdownContents;
	
	
	public void getmenuList()
	{
		System.out.println("Menu has following options as hyperlinks : ");
		for (WebElement ele : menuLinks) 
		{
			System.out.println(" ----- "+ele.getText());
		}	
	}
	
	public void getprojectType()
	{
		System.out.println("Types of Project offered are as below  : ");
		for (WebElement project : ProjectTypes) 
		{
			System.out.println(" ----- "+project.getText());
		}
	}
	
	public void getDDcontent()
	{
		System.out.println("Below are the dropdown topics : ");
		for (WebElement DD : dropdownContents) 
		{
			System.out.println(" - "+DD.getText());
		}
	}
	
	public void getDDprojects()
	{
		System.out.println("Below Projects have dropdown topics : ");
		for (WebElement projectdd : ProjectDD) 
		{
			System.out.println(" - "+projectdd.getText());
		}
	}
	
	
}
