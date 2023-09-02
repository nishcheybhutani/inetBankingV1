package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.Properties;

public class ReadConfig 
{
	    Properties pro;
	    public ReadConfig()
	    {
	   
	      File src = new File("./Configuration/config.properties");
	
	      
		  try {
			  	FileInputStream fis = new FileInputStream(src);
			  	pro = new Properties();
				pro.load(fis);
			   }
		       
		   catch (Exception e)
		     {
			// TODO Auto-generated catch block
			   System.out.println("Exception is "+e.getMessage());
	          }
	   
	    }
	    
	    //methods to read var.'s values from config.properties, store them in a var. and return the var.
	    public String getApplicationURL()
	    {
	    	String url = pro.getProperty("baseURL");
	    	return url;
	    }
	     
	    public String getUsernameL()
	    {
	    	String username = pro.getProperty("username");
	    	return username;
	    }
	    
	    public String getPassword()
	    {
	    	String password = pro.getProperty("password");
	    	return password;
	    }
	    
	    public String getChromePath()
	    {
	    	String chromepath = pro.getProperty("chromepath");
	    	return chromepath;
	    }
	    
	    public String getIEPath()
	    {
	    	String iepath = pro.getProperty("iepath");
	    	return iepath;
	    }
	    
	    public String getFirefoxPath()
	    {
	    	String firefoxpath = pro.getProperty("firefoxpath");
	    	return firefoxpath;
	    }
	    
  
}

