package com.test.annotations;

import java.lang.reflect.Field;

import org.apache.poi.ss.formula.functions.T;

public class TestDemo {
	
	public static <T> String getDescription(Class<T> klass,String str) {
		
		Field[] f= klass.getFields();
		
		for (Field field : f) {
			String v=null;
			try {
				 v=field.get(klass).toString();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(field.isAnnotationPresent(TestAnnotations.class) &&str.equals(v)) {
				return field.getAnnotation(TestAnnotations.class).description();
			}
		}	
		return null;

	}
	
}
