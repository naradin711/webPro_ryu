package com.lec.ex01;

public class InterfaceClass implements Interface, Interface2 {

	@Override
	public String method2() {
		System.out.println("실제구현은 implments한 클래스에서 합니다. method2");
		return null;	
	}
	@Override
	public void method1() {
		System.out.println("실제구현은 implments 받은 클래스에서 합니다. method1");
	}
 
}
