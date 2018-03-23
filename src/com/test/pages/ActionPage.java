package com.test.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.test.base.Locator;
import com.test.base.Page;
import com.test.base.Page2;


public class ActionPage extends Page2{
	
	public ActionPage(WebDriver driver) {
		super(driver);
		
	}
	
	//
	public void closeTemp() {
		this.getElement("close").click();
	}
	
	public void enterMyLogPage() {
		this.moveToElement("ap.mymenu");
		this.getElement("myLog").click();
	}
	
	public void writeLog(String title,String content) {
		this.getElement("writelog").click();
		this.getElement("input").sendKeys(title);
		this.switchFrame(0);
		this.executeJs("arguments[0].innerHTML='"+content+"'","content");
		this.switchFrame(-1);
		this.getElement("submit2").click();
	}
	
	public void checkMylog(String expectResult) {
		this.getElement("mylog").click();
		String txtTitle=this.getElement("title").getText();
		assertEquals(txtTitle, expectResult,"Verify title value");
		
	}
	
	public void deletelog() {
		boolean result=false;
		this.getElement("delete").click();
		this.getElement("confirm").click();
		WebElement title=this.getElement("tit");
		if(title==null) {
			 result=true;
			 assertEquals(result, true);
		}
		else {
			result=false; 
			assertEquals(result, false);
		}
	}
	
	
}
