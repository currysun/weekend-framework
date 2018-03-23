package com.test.annotations;

public class DemoAnnotation {
	
	@TestAnnotations(description="success!")
	public static String success="200";
	
	@TestAnnotations(description="failure!")
	public static String failure="300";
	
	public static void getMessage(String s) {
		System.out.println(TestDemo.getDescription(DemoAnnotation.class, s));
		System.out.println(s);
	}
	
	public static void main(String[] args) {
	
		String s = DemoAnnotation.success;
		String s2 = DemoAnnotation.failure;
		getMessage(s);
		getMessage(s2);
	}
	
}
