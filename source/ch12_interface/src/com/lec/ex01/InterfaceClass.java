package com.lec.ex01;

public class InterfaceClass implements Interface, Interface2 {

	@Override
	public String method2() {
		System.out.println("���������� implments�� Ŭ�������� �մϴ�. method2");
		return null;	
	}
	@Override
	public void method1() {
		System.out.println("���������� implments ���� Ŭ�������� �մϴ�. method1");
	}
 
}
