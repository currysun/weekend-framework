package com.test.info;

import com.test.util.Log;
import com.test.util.ParseXml;

import net.bytebuddy.asm.Advice.This;

public class Config {
	
	public static String browser;
	
	public static int waitTime;
	
	public static Log log=new Log(Config.class);
	
	static {
		ParseXml px=new ParseXml("config/config.xml");
		browser =px.getElementText("config/browser");
		System.out.println(browser);
		log.info("the browser is : "+browser);
		waitTime  =Integer.valueOf(px.getElementText("config/waitTime"));
		log.info("the waitTime is : "+waitTime);
	}
	
}
