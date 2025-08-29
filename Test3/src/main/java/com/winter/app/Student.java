package com.winter.app;


public class Student {
	private String name;
	private static String school;
	
	// 스태틱 초기화 블록
	static {
		Student.school = "0";
	}
	
	// 인스턴스 초기화 블록
	{
		this.name = "";
	}
	
	public Student() {
		name = "";
	}
	
	public Student(String name) {
		this.name = name;
	}
}
