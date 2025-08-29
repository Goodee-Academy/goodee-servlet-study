package com.winter.app;

public class LeftArm implements Arm {
	
	long bullet = 100;

	@Override
	public void attack() {
		System.out.println("총을 쏩니다.");
	}
	
}
