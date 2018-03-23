package com.test.interfaces;

import javax.tools.Diagnostic;

public class TestInterface {
	
	public void testInterface() {
		try {
			DefinedInterface di=(DefinedInterface)Class.forName("com.test.interfaces.ImpInterface2").newInstance();
			di.test(30,"curry");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		TestInterface t=new TestInterface();
		t.testInterface();
	}
}
