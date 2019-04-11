package com.DemoGuru.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	static FileInputStream fis;
	public Properties pro;
	
	public ReadConfig()
	{
		try
		{
			fis = new FileInputStream("./src/test/java/com/DemoGuru/Configuration/guru.properties");
			pro = new Properties();
			pro.load(fis);
		
		}
		catch(Exception e )
		{
			System.out.println("Exception is : "+e.getMessage());
		}
	}
	
	
	public String getURL() 
	{
		String url = pro.getProperty("URL");
		return url;
	}
	
	public String getUname() 
	{
		String user = pro.getProperty("username");
		return user;
	}
	
	public String getPWD() 
	{
		String passwd = pro.getProperty("password");
		return passwd;
	}
	
	public String getBrowser() 
	{
		String br = pro.getProperty("browser");
		return br;
	}
	
	
	
}
