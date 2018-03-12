package com.test.util;

import java.io.File;

import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



public class ParseXml {
		
		/*
		 * 现在做的是框架，需要时刻写log，也就是log4j。读取xml文件使用的dom4j.
		 * 读xml内容使用的技术是xpath，对应的开源工具包是jaxen.jar
		 * 
		 */
	private Log log=new Log(this.getClass());
	
	private String filePath;
	
	private Document document;
	
	public ParseXml(String filePath) {
		this.filePath=filePath;
		this.load(this.filePath);
		
	}
	
	private void load(String filePath) {
		File file=new File(filePath);
		if(file.exists()) {
			SAXReader saxReader=new SAXReader();
			try {
				 document=saxReader.read(file);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			log.info("file load error : "+filePath);
			throw new DefinedException("file load error : "+filePath);
		}
		
	}
	public void getElement() {
		Element element=(Element) document.selectSingleNode("/config/browser");
		System.out.println(element.getText());
	}
	
	public String getElementText(String configXml) {
		Element element=(Element) document.selectSingleNode(configXml);
		return element.getText();
	}
	
	public static void main(String[] args) {
		ParseXml px=new ParseXml("config/config.xml");
		px.getElement();
	}
	
}
