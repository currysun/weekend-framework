package com.test.util;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import com.gargoylesoftware.htmlunit.javascript.host.Screen;
import com.test.base.TestBase;


public class Assertions {
	
	public static ScreenShot ss;
	
	public static boolean flag=true;
	
    public static void begin(){flag =true;};
    
    public static void end(){ try {
    	Assert.assertTrue(flag);
	} catch (Exception e) {
		// TODO: handle exception
	}};
    
	public static void verifyEquals(Object actual,Object expected) {
		try {
			
			Assert.assertEquals(actual, expected);
			
		} catch (Error e) {
			e.printStackTrace();
			flag=false;
			
			
		}
	}
	
	public static void verifyEquals(Object actual,Object expected,String message) {
		try {
			
			Assert.assertEquals(actual, expected,message);
			
		} catch (Error e) {
			e.printStackTrace();
			flag=false;
			
		}
	}
	
	public static void verifyEquals(Object actual,Object expected,WebDriver driver) {
		try {
			
			Assert.assertEquals(actual, expected);
			
		} catch (Error e) {
			e.printStackTrace();
			flag=false;
			screenShot(driver);
		}
	}
	
	private static void screenShot(WebDriver driver) {
		ss=new ScreenShot(driver); 
		ss.taskScreenshot();
	}
	

}
