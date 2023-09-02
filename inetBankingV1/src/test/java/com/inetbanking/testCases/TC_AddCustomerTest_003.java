package com.inetbanking.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		addcust.custName("Nishchey");
		addcust.custgender();
		addcust.custdob("10", "30", "2000");
		
		Thread.sleep(3000);
		
		addcust.custaddress("India");
		addcust.custcity("New Delhi");
		addcust.custstate("Delhi");
		addcust.custpinno("110017");
		addcust.custtelephoneno("9999999999");
		
		String email = randomString()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custsubmit();//add in copy too, is missing
		
		//validation if cust submitted successfully
		
		boolean res = driver.getPageSource().contains("");
		
	}
	
//	public String randomString() //put in BaseClass
//	{
//		
//		String generatedString = RandomStringUtils.randomAlphabetic(8);
//		return generatedString;
//	}
	
	

}
