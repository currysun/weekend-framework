package com.test.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
	
	private WebDriver driver;
	
	public Page(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean waitDisplayed(final By by) {
		WebDriverWait wait=new WebDriverWait(driver, 3);
		boolean flag=true;
		try {
			 flag=wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver d) {
					return d.findElement(by).isDisplayed();
				}
			});
			 
		} catch (Exception e) {
			flag=false;
		}
		return flag;		
	}

	
	public WebElement getElement(By by) {
		if(this.waitDisplayed(by)) {
			return driver.findElement(by);
		}
		else {
			return null;
		}
	}
	
	public void moveToElement(By by) {
		Actions action=new Actions(driver);
		action.moveToElement(this.getElement(by)).perform();
	}
	
	public void switchFrame(int index) {
		if(index==-1) {
			driver.switchTo().defaultContent();	
		}else {
			driver.switchTo().frame(index);
		}
		
	}
	
	public void executeJs(String javascript,By by) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript(javascript, this.getElement(by));
	}
}
