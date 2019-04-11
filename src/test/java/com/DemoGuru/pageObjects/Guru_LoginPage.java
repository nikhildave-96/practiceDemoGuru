package com.DemoGuru.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru_LoginPage {

	
	WebDriver ldriver;
	public Guru_LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy (xpath = "//input[@name='uid']")
	WebElement obj_edit_uname;
	
	@FindBy (xpath ="//input[@name='password']")
	WebElement obj_edit_pwd;
	
	@FindBy (xpath = "//input[@name='btnLogin']")
	WebElement obj_click_signin;
	
	@FindBy (xpath = "//a[text()='Log out']")
	WebElement obj_click_logout;
	
	
	public void enterUsername(String username)
	{
		obj_edit_uname.sendKeys(username);
	}
	
	public void enterpwd(String passwd)
	{
		obj_edit_pwd.sendKeys(passwd);
	}
	
	public void clickLogin()
	{
		obj_click_signin.click();
	}
	
	public void clicklogout()
	{
		obj_click_logout.click();
	}
	
	
}
