package com.test.util;



public enum TestEnum {
	
	success(200,"success."),
	failed(300,"failure.");
	
	
	private int k;
	private String v;
	
	
	private TestEnum(int k,String v) {
		this.k=k;
		this.v=v;
	}
	
	
	public int getK() {
		return k;
	}
	public void setK(int k) {
		this.k = k;
	}
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	
	public String toString() {
		return k+" "+v;
		
	}
	
	public void getMsg(String s) {
		System.out.println("retCode : "+TestEnum.valueOf(s));
		System.out.println("retMsseage : "+TestEnum.valueOf(s));
	}

	
	public static void main(String[] args) {
		System.out.println(TestEnum.success);
		System.out.println(TestEnum.valueOf("success"));
		System.out.println(TestEnum.success.getK());
		System.out.println(TestEnum.success.getV());
		TestEnum testEnum=TestEnum.success;
		testEnum.getMsg("failed");
	}
	
}
