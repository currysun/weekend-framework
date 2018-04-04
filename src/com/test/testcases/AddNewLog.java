package com.test.testcases;

import java.util.Map;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.test.base.TestBase;
import com.test.listeners.AssertionsListener;
import com.test.pages.ActionPage;
import com.test.pages.LoginPage;
import com.test.util.Assertions;

@Listeners(AssertionsListener.class)
public class AddNewLog extends TestBase{

	
	@Test(dataProvider="providerMethod")
	public void testcase01(Map<String, String> param) {	
		Assertions.verifyEquals(2,3,driver);
		ActionPage ap=new ActionPage(driver);
		ap.enterMyLogPage();
		String title=param.get("title");
		String content=param.get("content");
		ap.writeLog(title,content);
		ap.checkMylog("title curry");
		ap.deletelog();

	}

}
