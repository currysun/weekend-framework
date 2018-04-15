package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.base.Locator;
import com.test.base.Page;
import com.test.base.Page2;

public class LoginBDPage extends Page2 {

	public LoginBDPage(WebDriver driver) {
		super(driver);
	}

	
	public void login(String username,String password) {
		this.getElement("login").click();
		this.getElement("usename").sendKeys(username);
		this.getElement("pwd").sendKeys(password);
		this.getElement("submit").click();
	}
	

}
