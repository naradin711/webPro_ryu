package com.lec.ex01;

public class Interface_TestMain {
	public static void main(String[] args) {
//		Interface ex1 = new Interface(); // 인터페이스는 객체 생성 불가.
        InterfaceClass obj1 = new InterfaceClass(); //클래스는 객체 생성 가능.
	    obj1.method1();
	    obj1.method2();
//	    System.out.println(obj1.CONSTANT_NUM + "/" + obj1.CONSTANT_STRING); 객체변수로 static access 는 추천하지 않는다.
	    System.out.println(Interface.CONSTANT_NUM + "/" + Interface2.CONSTANT_STRING);
	    Interface obj2 = new InterfaceClass(); //클래스는 객체 생성 가능.
	    obj2.method1();
	    if (obj2 instanceof InterfaceClass) {
	      ((InterfaceClass)obj2).method2();
	    }
	    Interface2 obj3 = new InterfaceClass();
	    obj3.method2();
	}

}
