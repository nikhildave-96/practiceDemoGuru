package com.DemoGuru.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{

	public ExtentHtmlReporter htmlreporter;
	public ExtentTest extest;
	public ExtentReports exreport; 
	
	public void onStart(ITestContext context) 
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY__hh.mm.ss aa");
		String timestamp = sdf.format(d);
		String reportname = "Test-Report-Demo "+timestamp+".html";
	
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\"+reportname);
		htmlreporter.loadConfig(System.getProperty("user.dir")+"\\extent-config.xml\\");
		
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setDocumentTitle("Demo Site Automation Testing Report");
		htmlreporter.config().setReportName("Functional Testing Report");
		
		
		exreport = new ExtentReports();
		exreport.attachReporter(htmlreporter);
		exreport.setSystemInfo("Host", "http://demo.guru99.com/v4/");
		exreport.setSystemInfo("User", "Nikhil Dave");
		exreport.setSystemInfo("Environment", "QA");
		exreport.setSystemInfo("OS", "Windows");
		exreport.setSystemInfo("Platform", "Web");
		
	}
	
	public void onFinish(ITestContext context)
	{
		exreport.flush();
	}
	
	public void onTestSuccess(ITestResult result)
	{	
		extest = exreport.createTest(result.getName());
		extest.log(Status.PASS,MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	}
	
	public void onTestSkipped(ITestResult result)
	{
		extest = exreport.createTest(result.getName());
		extest.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
	}
	
	public void onTestFailure(ITestResult result)
	{
		extest = exreport.createTest(result.getName());
		extest.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		
		String scrshotpath = System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
		
		File f = new File(scrshotpath);
		
		if(f.exists())
		{
			try 
			{
				extest.fail("Screenshot is captured and attached below :" + extest.addScreenCaptureFromPath(scrshotpath));
			}
			catch(Exception e )
			{
				System.out.println("Exception is : "+e.getMessage());
			}
			
		}
			
	}
	
	

}
