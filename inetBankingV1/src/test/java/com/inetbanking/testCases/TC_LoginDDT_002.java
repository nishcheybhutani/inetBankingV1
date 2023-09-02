package com.inetbanking.testCases;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		
		lp.setUsername(user);
		logger.info("username provided");
		
		lp.setPassword(pwd);
		logger.info("password provided");
		
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		//negative scenario
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
		
	}
	
	
	@DataProvider(name = "LoginData")
	String[][] getData() throws Exception
	{
		String path = System.getProperty("user.dir")+"//src//test//java//com//inetbanking//testData//LoginData.xlsx";
		
		int rownum = XLUtils.getRowCount(path,"Sheet1");
		int colnum = XLUtils.getCellCount(path,"Sheet1", 1);
		
		String logindata[][] = new String[rownum][colnum];
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0;j<colnum;j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i , j);
			}
		}
		return logindata;
		
	}
	
	public boolean isAlertPresent()
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

}
