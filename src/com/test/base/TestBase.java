package com.test.base;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.test.info.PropHelper;
import com.test.pages.LoginPage;

public class TestBase {
	
	protected WebDriver driver;
	
	LoginPage lp;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void navigate(String url) {
		driver.navigate().to(url);
	}
	
	@BeforeMethod
	public void initialDriver() {
		SeleniumDriver selenium=new SeleniumDriver();
		driver=selenium.getDriver();
		navigate(PropHelper.URL);	
		lp=new LoginPage(driver);
		lp.login(PropHelper.USERNAME, PropHelper.PASSWORD);
	}
	
	@DataProvider
	public Object[][] providerMethod(Method method){
		TestData testData=new TestData(this.getClass().getSimpleName());
		List<Map<String, String>> listData=testData.getTestMethodsData(method.getName());
		Object[][] obj=new Object[listData.size()][];
		for (int i = 0; i < obj.length; i++) {
			obj[i]=new Object[] {listData.get(i)};
		}
		return obj;
		
	}
	
	@AfterMethod
	public void close() {
		if(driver!=null) {
			//driver.close(); //firefox 会导致关闭游览器后报错
			driver.quit();
		}
	}
}
