package com.test.testcases;

import static org.testng.Assert.assertEquals;

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
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.pages.ActionPage;
import com.test.pages.LoginPage;

public class AssignmentDemo1 extends TestBase{

	
	@Test
	public void loginTest() {
		String url="http://localhost/phpwind/index.php";
		navigate(url);
		LoginPage lp=new LoginPage(driver);
		lp.login("currysun", "sx65641633");
		ActionPage ap=new ActionPage(driver);
		ap.enterMyLogPage();
		ap.writeLog("title curry","1234");
		ap.checkMylog("title curry");
		ap.deletelog();
	}

}
