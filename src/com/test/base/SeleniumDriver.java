package com.test.base;

import javax.sound.midi.MidiDevice.Info;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.test.info.PropHelper;
import com.test.util.DefinedException;
import com.test.util.Log;

public class SeleniumDriver {
	
	private static Log log=new Log(PropHelper.class);
	
	private WebDriver driver; 
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public SeleniumDriver() {
		this.initialDriver();
	}
	
	private void initialDriver() {
		if("firefox".equals(PropHelper.browser)) {
			System.setProperty("webdriver.gecko.driver", PropHelper.FIREFOX_DRIVER);
			driver=new FirefoxDriver();
		}else if("chrome".equals(PropHelper.browser)){
			System.setProperty("webdriver.chrome.driver", PropHelper.CHROME_DRIVER);
			driver=new ChromeDriver();
		}else {
			log.info(PropHelper.browser+"does not supported");
			throw new DefinedException(PropHelper.browser+"does not supported");
		}
		log.info(PropHelper.browser+"start successfully");
		driver.manage().window().maximize();

	}
	
}
