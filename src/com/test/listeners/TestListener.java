package com.test.listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.util.Assertions;

@Listeners({AssertionsListener.class})
public class TestListener extends TestBase{
	
	public WebDriver driver =new FirefoxDriver();
	
	@Test
	public void test() {
		//Assert.assertFalse(true);
		Assertions.verifyEquals(2, 3);
	}
}
