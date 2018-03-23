package com.test.testcases;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.listeners.AssertionsListener;
import com.test.listeners.ScreenshotListener;
import com.test.pages.ActionPage;
import com.test.pages.LoginPage;
import com.test.util.Assertions;

@Listeners(AssertionsListener.class)
public class AddNewLog extends TestBase{

	
	@Test(dataProvider="providerMethod")
	public void testcase01(Map<String, String> param) {	
		String url="http://localhost/phpwind/index.php";
		navigate(url);
		LoginPage lp=new LoginPage(driver);
		lp.login(param.get("username"), param.get("password"));
		Assertions.verifyEquals(2,3,driver);
		ActionPage ap=new ActionPage(driver);
		ap.enterMyLogPage();
		String title=param.get("title");
		String content=param.get("content");
		ap.writeLog(title,content);
		ap.checkMylog("title");
		ap.deletelog();
		

		
	}

}
