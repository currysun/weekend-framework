package com.test.pages;

import org.openqa.selenium.WebDriver;

import com.test.base.Page2;

public class BDSharePage extends Page2 {

	public BDSharePage(WebDriver driver) {
		super(driver);	
	}
	
	public BDDownloadPage submitFile(String password) {
		this.getElement("share.input").sendKeys(password);
		this.getElement("share.submit").click();
		return new BDDownloadPage(driver);
	}
}
