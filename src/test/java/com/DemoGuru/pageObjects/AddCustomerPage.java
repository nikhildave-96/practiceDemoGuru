package com.DemoGuru.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy (xpath = "//a[contains(text(),'New Customer')]")
	WebElement obj_click_newCust;
	
	@FindBy (xpath = "//input[@name='name']")
	WebElement obj_edit_cname;
	
	@FindBy (xpath = "//input[@name='rad1' and @value='m']")
	WebElement obj_click_cgender;
	
	@FindBy (xpath = "//input[@name='dob']" )
	WebElement obj_edit_cdob;
	
	@FindBy (xpath = "//textarea[@name='addr']")
	WebElement obj_edit_caddr;
	
	@FindBy (xpath ="//input[@name='city']")
	WebElement obj_edit_ccity;
	
	@FindBy (xpath = "//input[@name='state']")
	WebElement obj_edit_cstate;
	
	@FindBy (xpath ="//input[@name='pinno']")
	WebElement obj_edit_cpinno;
	
	@FindBy (xpath = "//input[@name='telephoneno']")
	WebElement obj_edit_cmobile;
	
	@FindBy (xpath = "//input[@name='emailid']")
	WebElement obj_edit_cemail;
	
	@FindBy (xpath = "//input[@name='password']")
	WebElement obj_edit_cpass;
	
	@FindBy (xpath = "//input[@value='Submit']")
	WebElement obj_click_submit;
	
	
	public void name(String cname)
	{
		obj_edit_cname.sendKeys(cname);
	}
	
	public void gender()
	{
		obj_click_cgender.click();
	}
	
	public void dob(String dd,String mm,String yyyy)
	{
		obj_edit_cdob.sendKeys(dd);
		obj_edit_cdob.sendKeys(mm);
		obj_edit_cdob.sendKeys(yyyy);
	}
	
	public void addr(String caddr)
	{
		obj_edit_caddr.sendKeys(caddr);
	}
	
	public void city(String ccity)
	{
		obj_edit_ccity.sendKeys(ccity);
	}

	public void state(String cstate)
	{
		obj_edit_cstate.sendKeys(cstate);
	}
	
	public void pin(String cpin)
	{
		obj_edit_cpinno.sendKeys(cpin);
	}
	
	public void mobile (String cmobile)
	{
		obj_edit_cmobile.sendKeys(cmobile);
	}
	
	public void mail(String cmail)
	{
		obj_edit_cemail.sendKeys(cmail);
	}
	
	public void pwd (String passwd)
	{
		obj_edit_cpass.sendKeys(passwd);
	}
	
	public void submit()
	{
		obj_click_submit.click();
	}
	
	public void clickNewCust()
	{
		obj_click_newCust.click();
	}
	
	
	
	
	
	
}
