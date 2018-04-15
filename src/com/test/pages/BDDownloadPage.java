package com.test.pages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.base.Page2;

public class BDDownloadPage extends Page2{

	public BDDownloadPage(WebDriver driver) {
		super(driver);	
	}
	
	public void saveToCloud() {		
		this.getElement("download.login").click();
		this.getElement("download.loginSelect").click();
		this.getElement("download.username").sendKeys("rookiesx");;
		this.getElement("download.password").sendKeys("sx19900820");
		this.getElement("download.submit").click();
		this.getElement("download.closetemp").click();
		this.getElement("download.save").click();
	}
	
	public void listAllFile() {
		List<WebElement> lists=this.getElements("download.subdir");
		int nodes=this.getElements("download.subdir").size();
		for(int i=1;i<=nodes;i++) {
			lists.get(i).click();
			if(isDirectory()) {
				listAllFile();
			
			}else {
				System.out.println(lists.get(i).getText());
			}
				
		}
		//System.out.println(nodes);
	}
	public void subdir() {
		int nodes=this.getElements("download.subdir").size();
		for (int i = 0; i < nodes; i++) {
			
		}
	}
	
	private boolean isDirectory() {
		String flag=this.getElement("download.minus").getAttribute("class");
		if("minus".contains(flag)) {
			return true;
		}
		return false;
	}
	
	public static void listFiles(File dir) {	
		File[] files=dir.listFiles();
		for(File file: files) {
			if(file.isFile()) {
				System.out.println(file);
			}else {
				System.out.println(file);
				listFiles(file);
			}
			
		}
	}

}
