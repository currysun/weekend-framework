package com.test.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.util.ScreenShot;

public class ScreenshotListener extends TestListenerAdapter {
	
	private ScreenShot ss;
	
	@Override
	public void onTestFailure(ITestResult tr) {
		TestBase tb=(TestBase)tr.getInstance();
		WebDriver driver=tb.getDriver();
		if(ss==null) {
			ss=new ScreenShot(driver);
		}
		ss.taskScreenshot();
		
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		TestBase tb=(TestBase)tr.getInstance();
		WebDriver driver=tb.getDriver();
		if(ss==null) {
			ss=new ScreenShot(driver);
		}
		ss.taskScreenshot();
	}
	
	
	
}
