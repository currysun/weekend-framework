package com.test.info;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.test.util.Log;
import com.test.util.ParseXml;



public class Config {
	
	public static String browser;
	
	public static int waitTime;
	
	public static Log log=new Log(Config.class);
	
	/*static {
		ParseXml px=new ParseXml("config/config.xml");
		browser =px.getElementText("config/browser");
		System.out.println(browser);
		log.info("the browser is : "+browser);
		waitTime  =Integer.valueOf(px.getElementText("config/waitTime"));
		log.info("the waitTime is : "+waitTime);
	}*/
	
	static {
		Properties properties=new Properties();
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("config/config.properties");
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		browser=properties.getProperty("browser");
		waitTime=Integer.parseInt(properties.getProperty("waittime"));  
	}
	
}
