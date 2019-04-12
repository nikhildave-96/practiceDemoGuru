package com.DemoGuru.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InsuranceProjectPage {

	WebDriver ldriver;
	
	public InsuranceProjectPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy (xpath = "//input[@id='email']")
	WebElement txtUsername;
	
	@FindBy (xpath = "//input[@id='password']")
	WebElement txtUserPwd;
	
	@FindBy (xpath = "//input[@name='submit']")
	WebElement btnLogin;
	
	@FindBy (xpath = "//a[text()='Register']")
	WebElement btnRegister;
	
	@FindBy (xpath = "//select[@id='user_title']")
	WebElement ddTitle;
	
	@FindBy (xpath = "//select[@name='year']")
	WebElement ddYear;
	
	@FindBy (xpath = "//select[@name='month']")
	WebElement ddMonth;
	
	@FindBy (xpath = "//select[@name='date']")
	WebElement ddDate;
	
	@FindBy (xpath = "//select[@name='licenceperiod']")
	WebElement ddLicensePeriod;
	
	@FindBy (xpath = "//select[@name='occupation']")
	WebElement ddOccupation;
	
	@FindBy (xpath = "//input[@value='Reset']")
	WebElement btnReset;
	
	@FindBy (xpath = "//input[@value='Create']")
	WebElement btnCreate;
	
	@FindBy (xpath = "//input[@type='radio']/following-sibling::label")
	List <WebElement> radLicensetype;
	
	@FindBy (xpath = "//input[@name='firstname']")
	WebElement txtFirstname;
	
	@FindBy (xpath = "//input[@name='lastname']")
	WebElement txtLastname;
	
	@FindBy (xpath = "//input[@name='phone']")
	WebElement txtPhone;
	
	@FindBy (xpath = "//input[@name='street']")
	WebElement txtStreet;
	
	@FindBy (xpath = "//input[@name='city']")
	WebElement txtCity;
	
	@FindBy (xpath = "//input[@name='county']")
	WebElement txtCountry;
	
	@FindBy (xpath = "//input[@name='post_code']")
	WebElement txtPin;
	
	@FindBy (xpath = "//input[@name='email']")
	WebElement txtEmail;
	
	@FindBy (xpath = "//input[@name='password']")
	WebElement txtPwd;
	
	@FindBy (xpath = "//input[@name='c_password']")
	WebElement txtConfirmPwd;
	
	
	
	public void clickonLogin()
	{
		btnLogin.click();
	}
	
	public void enterUsername(String userID)
	{
		txtUsername.sendKeys(userID);
	}
	
	public void enterUserpwd(String userPwd)
	{
		txtUserPwd.sendKeys(userPwd);
	}
	
	public void enterStreet(String addrStr)
	{
		txtStreet.sendKeys(addrStr);
	}
	
	public void entercity(String city)
	{
		txtCity.sendKeys(city);
	}
	
	public void enterCountry(String country)
	{
		txtCountry.sendKeys(country);
	}
	
	public void enterPIN(String pincode)
	{
		txtPin.sendKeys(pincode);
	}
	
	public void enterEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void clickonReg()
	{
		btnRegister.click();
	}
	
	public void enterName(String name)
	{
		txtFirstname.sendKeys(name);
	}
	
	public void entermobile(String phone)
	{
		txtPhone.sendKeys(phone);
	}
	
	public void entersurName(String lastname)
	{
		txtLastname.sendKeys(lastname);
	}
	
	public void enterpwd(String password)
	{
		txtPwd.sendKeys(password);
	}
	
	public void entercpwd(String cpassword)
	{
		txtConfirmPwd.sendKeys(cpassword);
	}
	
	public void setTitle(String title)
	{
		Select s = new Select(ddTitle);
		s.selectByValue(title);
	}
	
	public void setDOByear(String yy)
	{
		Select s = new Select(ddYear);
		s.selectByValue(yy);
	}
	
	public void setDOBmonth(String mm)
	{
		Select s = new Select(ddMonth);
		s.selectByVisibleText(mm);
	}
	
	public void setDOBday(String dd)
	{
		Select s = new Select(ddDate);
		s.selectByValue(dd);
	}
	
	public void setLicenseType(String lictype)
	{
		for (WebElement ele : radLicensetype)
		{
			if(ele.getText().trim().equalsIgnoreCase(lictype))
			{
				ele.click();
			}
		}
	}
	
	public void setlicYears(String licYear)
	{
		Select s = new Select(ddLicensePeriod);
		s.selectByValue(licYear);
	}
	
	public void setOccu(String occu)
	{
		Select s = new Select(ddOccupation);
		s.selectByVisibleText(occu);
	}
	
	public void clickonCreate()
	{
		btnCreate.click();
	}
	
	public void clickonReset()
	{
		btnReset.click();
	}
	
	
	
	
	
	
}
