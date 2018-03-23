package com.test.base;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;


import com.test.util.ParseXml;

public class TestData {
	
	private String fileName;
	
	private ParseXml px;
	
	
	
	public TestData(String fileName) {
		//super();
		this.fileName = fileName;
		px= new ParseXml("testdata"+File.separator+this.fileName+".xml");
	}



	public  List<Map<String,String>> getTestMethodsData(String methodName){
		List<Element> elements=px.getElementObjects("/*/"+methodName);
		List<Map<String,String>> listData=new ArrayList<Map<String,String>>();
		for (Element element : elements) {
			Map<String, String> datamap=px.getChildrenInfoByElement(element);
			listData.add(datamap);
		}
		return listData;
	
	}
	
	public static void main(String[] args) {
		TestData td=new TestData("AddNewLog");
		System.out.println(td.getTestMethodsData("testcase01"));
	}
}
