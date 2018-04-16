package com.test.testcases;

import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.pages.BDDownloadPage;
import com.test.pages.BDSharePage;

public class TestBaiduClould extends TestBase{

	@Test
	public void testBaiduCloud() {
		String password="0pwt";
		BDSharePage sharePage=new BDSharePage(driver);
		BDDownloadPage download=sharePage.submitFile(password);
		download.saveToCloud();
		download.listAllFile();
		
	}
}
