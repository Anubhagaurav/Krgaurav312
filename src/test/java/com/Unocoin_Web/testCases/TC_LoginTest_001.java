package com.Unocoin_Web.testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.Unocoin_Web.pageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass
{

@Test
public void loginTest() 
{
try {



logger.info("URL is opened");
Thread.sleep(9000);
LoginPage lp = new LoginPage(driver);
lp.setUserName(username);
logger.info("Entered User name");
lp.setPassword(password);
logger.info("Entered Password");
lp.clickLogin();
logger.info("Clicked on signin");
Thread.sleep(4000);
lp.setLoginOTP(OTP);
logger.info("Entered OTP");
lp.clickSubmit();
logger.info("OTP submited");
Thread.sleep(13000);



 /*if(driver.getTitle().equals("Dashboard|Unocoin"))
{
Assert.assertTrue(true);
//logger.info("Title test passed");
System.out.println("Title test is passed");
}else
{
	
	captureScreen(driver,"loginTest");
Assert.assertTrue(false);
//logger.info("Title test failed");
System.out.println("Title test is failed"+driver.getTitle());

}*/

}catch(Exception e){

System.out.println(e);

}

}
}


