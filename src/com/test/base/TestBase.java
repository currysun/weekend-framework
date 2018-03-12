package com.test.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
	
	protected WebDriver driver;
	
	public void navigate(String url) {
		driver.navigate().to(url);
	}
	
	@BeforeClass
	public void initialDriver() {
		SeleniumDriver selenium=new SeleniumDriver();
		driver=selenium.getDriver();
	}
	
	@AfterClass
	public void close() {
		if(driver!=null) {
			driver.close();
			
		}
	}
}
