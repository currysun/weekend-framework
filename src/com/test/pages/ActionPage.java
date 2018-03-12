package com.test.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.test.base.Locator;
import com.test.base.Page;


public class ActionPage extends Page{
	
	public ActionPage(WebDriver driver) {
		super(driver);
		
	}

		//loginPage
		public By loginb=By.xpath("//span/button[@name='head_login']");
		public By usename=By.xpath("//div/input[@class='input']");
		public By pwd=By.xpath("//div/input[@type='password']");
		public By submit=By.xpath("//span/button[@type='submit']");
		//homepage
		public By mymenu =By.id("td_mymenu");
		public By myLog =By.xpath("//li/a/img[@alt='日志']");
		//MyPage
		public By mylog =By.xpath("//li/a[text()='我的日志']");
		public By title =By.xpath("//dl/dt/p/a");
		public By delete =By.xpath("//div/dl[1]/dt/a[2]");
		public By confirm=By.xpath("//span/button[text()='确 定']");
		public By tit=By.className("mb10");
		//MylogPage
		public By writelog =By.xpath("//span/button[text()='写新日志']");
		public By input =By.id("atc_title");
		public By content =By.tagName("div");
		public By submit2=By.xpath("//span/button[@name='Submit']");
		
		private By close=By.id("close");
	
	//
	public void closeTemp() {
		this.getElement(close).click();
	}
	
	public void enterMyLogPage() {
		this.moveToElement(mymenu);
		this.getElement(myLog).click();
	}
	
	public void writeLog(String title,String content) {
		this.getElement(writelog).click();
		this.getElement(input).sendKeys(title);
		this.switchFrame(0);
		this.executeJs("arguments[0].innerHTML='"+content+"'",this.content);
		this.switchFrame(-1);
		this.getElement(submit).click();
	}
	
	public void checkMylog(String expectResult) {
		this.getElement(mylog).click();
		String txtTitle=this.getElement(title).getText();
		assertEquals(txtTitle, expectResult,"Verify title value");
		
	}
	
	public void deletelog() {
		boolean result=false;
		this.getElement(delete).click();
		this.getElement(confirm).click();
		WebElement title=this.getElement(tit);
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
