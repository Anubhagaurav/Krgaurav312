package com.Unocoin_Web.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("C:\\Users\\krgau\\eclipse-workspace\\UnoWebSanity\\Configuration\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is  "+e.getMessage());
		}
	}
	
	public String getApplicationURL()
	
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
public String username()
	
	{
		String username=pro.getProperty("username");
		return username;
	}
public String password()

{
	String password=pro.getProperty("password");
	return password;
}

public String OTP()

{
	String OTP=pro.getProperty("OTP");
	return OTP;
}
	
public String chromepath()

{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
}

}
