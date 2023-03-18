package com.Unocoin_Web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

WebDriver ldriver;
public LoginPage(WebDriver rdriver)
{
ldriver = rdriver;
PageFactory.initElements(rdriver, this);
}


@FindBy(xpath="/html/body/div/div[1]/div[2]/div/div[2]/div/div[1]/label/div/div/div/input")

@CacheLookup

WebElement txtUserName;

@FindBy (xpath="/html/body/div/div[1]/div[2]/div/div[2]/div/div[2]/label/div/div/div[1]/input")
    @CacheLookup

WebElement txtPassword;

@FindBy (xpath="//button[contains(text(),'Sign in')]")
    @CacheLookup

WebElement btnLogin;

@FindBy (xpath="/html/body/div/div[1]/div[2]/div/div/div/div[2]/label/div/div/div/input")
    @CacheLookup

WebElement loginOTP;

@FindBy (xpath="/html/body/div/div[1]/div[2]/div/div/div/div[3]/button[1]")
    @CacheLookup

WebElement btnSubmit;

public void setUserName(String uname)
{
txtUserName.sendKeys(uname);
}
public void setPassword(String pwd)
{
txtPassword.sendKeys(pwd);
}
public void clickLogin()
{

            btnLogin.click();
}
public void setLoginOTP(String OTP)
{
loginOTP.sendKeys(OTP);
}

public void clickSubmit()
{
btnSubmit.click();
}
}