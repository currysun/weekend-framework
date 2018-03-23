package com.test.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.test.base.TestBase;
import com.test.util.Assertions;
import com.test.util.ScreenShot;

public class AssertionsListener extends TestListenerAdapter {
	private static ScreenShot ss;
	
	@Override
	public void onTestStart(ITestResult result) {
		Assertions.begin();
	}
	

	@Override
	public void onTestFailure(ITestResult tr) {
		this.handleAssertion(tr);
		this.handleScreenShot(tr);
	
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		this.handleAssertion(tr);
	}
	
	@Override
	public void onTestSuccess(ITestResult tr) {
		this.handleAssertion(tr);
		this.handleScreenShot(tr);
	}


	public  void handleAssertion(ITestResult tr) {
		if(!Assertions.flag) {
			tr.setStatus(ITestResult.FAILURE);
		}
		
	} 
	
	public void handleScreenShot(ITestResult tr) {
		TestBase tb=(TestBase)tr.getInstance();
		WebDriver driver=tb.getDriver();
		ss=new ScreenShot(driver);
		ss.taskScreenshot();
	}


	
	
}
