package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;//local driver
	
	public LoginPage(WebDriver rdriver)//constructor
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//identifying elements
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUsername;

	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText="Log out")
	@CacheLookup
	WebElement lnkLogout;
	
	//Creating action methods for these identified elements
	public void setUsername(String uname)
	{
		txtUsername.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
}
