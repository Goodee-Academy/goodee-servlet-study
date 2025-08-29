package com.winter.app;

public class Robot {
	private Arm arm; // 로봇은 팔이 있어야 일을 할 수 있음 -> leftArm에 의존성(dependency)를 가짐
	
	public Robot() {
		this.arm = new LeftArm(); // 생명주기를 Robot과 공유
	}
	
	public void setLeftArm(LeftArm leftArm) {
		this.arm = leftArm; // Robot과 별도의 생명주기를 가짐
	}
	
	public void m1() {
		int a = 10;
		
		this.arm.attack();
	}
}
