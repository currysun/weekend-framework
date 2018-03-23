package com.test.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.sound.midi.MidiDevice.Info;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.ho.yaml.Yaml;
import org.openqa.selenium.By;


import com.test.util.DefinedException;
import com.test.util.Log;


public class Locator {

	protected Log log=new Log(this.getClass());
	
	private String yamlFile;
	
	private Map<String, Map<String,String>>  locators;
	
	public Locator() {
		
		yamlFile=this.getClass().getSimpleName();
		locators=this.loadYamlFile(yamlFile);
	}
	
	private Map<String, Map<String,String>> loadYamlFile(String filename) {
		File file=new File("locator"+File.separator+filename+".yaml");
		try {
			return Yaml.loadType(file, HashMap.class);
		} catch (FileNotFoundException e) {
			throw new DefinedException("File does not exist :"+file.getName());
			}
	}
	
	private By getBy(String type,String value) {
		By by=null;
		
		if("id".equals(type)) {
			return by=By.id(value);
		}
		else if("className".equals(type)) {
			return by=By.className(value);
		}
		else if("cssSelector".equals(type)) {
			return by=By.cssSelector(value);
		}	
		else if("tagName".equals(type)) {
			return by=By.tagName(value);
		}
		else if("xpath".equals(type)) {
			return by=By.xpath(value);
		}else {
			throw new DefinedException("this type"+type+" exist in this file"+yamlFile);
		}
		
	}
	
	public By getBy(String key,String... replacement) {
		return this.getBy(this.getTypeByKey(key),this.getValueByKey(key,replacement));
	}
	
	protected String getTypeByKey(String key) {
		String type =locators.get(key).get("type");
		if(type==null) {
			throw new DefinedException("this type "+key+"must to have");
		}
		return type;
	}
	
	protected String getValueByKey(String key,String... replacement) {
		String value =locators.get(key).get("value");
		if(value==null) {
			throw new DefinedException("this value "+key+"must to have");
		}
		if(replacement!=null) {
			value=this.getLocatorString(value, replacement);
		}
		return value;
	}
	
	public String getLocatorString(String locatorString ,String... ss) {
		for(String s:ss) {
			locatorString=locatorString.replaceFirst("\\?", s);
		}
		return locatorString;
	}
	
	public void setLocatorVariableValue(String variable,String value) {
		Set<String> keys=locators.keySet();
		for (String key : keys) {
			String v=locators.get(key).get("value").replaceAll("\\?"+variable+"\\?", value);
			locators.get(key).put("value", v);
		}
		
	}
	
	//这个方法 还未搞清楚
	public void loadExtendLocator(String filename) {
		locators.putAll(this.loadYamlFile(filename));
	}
	
	
	public static void main(String[] args) {
		Locator l=new Locator();
		By myLog1=l.getBy("id", "td_mymenu");
		//System.out.println(l.locators);
		l.setLocatorVariableValue("sku", "123456");
		
		System.out.println(l.locators.get("密码").get("type"));
		//通过Locator 中的 loadYamlFile方法，可以从yaml文件中的titile 名 得到它的键值对
		System.out.println(l.getLocatorString(l.locators.get("密码").get("value"),"test"));
		String ls="//table//tr[?]//td[?]";
		String[] ss=new String[] {"1","4"};
		String s1="1";
		String s2="4";
		
		System.out.println();
	}
	
}
