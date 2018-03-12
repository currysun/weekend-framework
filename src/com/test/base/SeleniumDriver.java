package com.test.base;

import javax.sound.midi.MidiDevice.Info;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.test.info.Config;
import com.test.util.DefinedException;
import com.test.util.Log;

public class SeleniumDriver {
	
	private static Log log=new Log(Config.class);
	
	private WebDriver driver; 
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public SeleniumDriver() {
		this.initialDriver();
	}
	
	private void initialDriver() {
		if("firefox".equals(Config.browser)) {
			System.setProperty("webdriver.gecko.driver", "files/geckodriver.exe");
			driver=new FirefoxDriver();
		}else if("chrome".equals(Config.browser)){
			System.setProperty("webdriver.chrome.driver", "files/chromedriver.exe");
			driver=new ChromeDriver();
		}else {
			log.info(Config.browser+"does not supported");
			throw new DefinedException(Config.browser+"does not supported");
		}
		log.info(Config.browser+"start successfully");
		driver.manage().window().maximize();

	}
	
}
