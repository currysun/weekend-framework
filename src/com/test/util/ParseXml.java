package com.test.util;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public String getElementText(String configXml) {
		Element element=(Element) document.selectSingleNode(configXml);
		return element.getText();
	}
	
	public Element getElementObject(String elementPath) {
		Element element = null;
		try{
			element = (Element) document.selectSingleNode(elementPath);
		}catch(Exception e){
			log.info("path: " + elementPath + "不存在");
			throw new DefinedException("path: " + elementPath + "不存在");
		}
		return element;
	}	
	
	@SuppressWarnings("unchecked")
	public List<Element> getElementObjects(String elementPath) {
		return document.selectNodes(elementPath);
	}
	
	public List<Element> getChildrenElements(String elementPath){
		return this.getElementObjects(elementPath+"/*");
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, String> getChildrenInfoByElement(Element element){
		Map<String, String> map = new HashMap<String, String>();
		List<Element> children = element.elements();
		for (Element e : children) {
			map.put(e.getName(), e.getText());
		}
		return map;
	}
	
	public static void main(String[] args) {
		ParseXml px=new ParseXml("config/config.xml");
		System.out.println(px.getElementText("config/browser"));
	}
}
