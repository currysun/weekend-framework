package com.test.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.info.PropHelper;

public class Page2 extends Locator {
	
	protected WebDriver driver;
	
	public Page2(WebDriver driver) {
		//super();
		this.driver=driver;
	}
	
	private WebElement getElementLocator(String key,String...replacement) {
		By by=this.getBy(key,replacement);
		if(this.waitToDisplayed(by)) {
			return driver.findElement(by);
		}else {
			return null;
		}
	}
	
	private List<WebElement> getElementLocators(String key,String...replacement) {
		By by=this.getBy(key,replacement);
		if(this.waitToDisplayed(by)) {
			return driver.findElements(by);
		}else {
			return null;
		}
	}
	
	public WebElement getElement(String key,String... replacement) {
		return this.getElementLocator(key,replacement);
	}
	
	public List<WebElement> getElements(String key,String... replacement) {
		return this.getElementLocators(key,replacement);
	}
	
	public boolean waitToDisplayed(final By by) {
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
	
	public boolean waitToNonDisappear(String key) {
		//分析情况 1.元素不存在，2 元素被影藏了 比如AR的 loading status，需要等到loading结束后才能操作页面
		boolean flag=true;
		final By by=this.getBy(key);
		WebDriverWait wait=new WebDriverWait(driver, PropHelper.waitTime);
		try {
			flag=wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver d) {
					if(d.findElements(by).isEmpty() || d.findElement(by).isDisplayed()) {
						return true;
					}				
					else {
						return false;
					}
				}
			});
			
		} catch (Exception e) {
			flag=false;
		}
		return flag;		
	}
	
	public void moveToElement(String key) {
		Actions action=new Actions(driver);
		action.moveToElement(this.getElement(key)).perform();
	}
	
	public void switchFrame(int index) {
		if(index==-1) {
			driver.switchTo().defaultContent();	
		}else {
			driver.switchTo().frame(index);
		}
		
	}
	
	public void executeJs(String javascript,String key) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript(javascript, this.getElement(key));
	}
	
	private boolean isPresent(String key,String[] replacement) {
		By by=this.getBy(key,replacement);
		return driver.findElements(by).size()>0?true:false;
	}
	
	public boolean isPresentElement(String key) {
		return this.isPresent(key, null);
	}
	public boolean isPresentElement(String key,String[] replacement) {
		return this.isPresent(key, replacement);
	}
}
