package com.lec.ex01;

public class Interface_TestMain {
	public static void main(String[] args) {
//		Interface ex1 = new Interface(); // �������̽��� ��ü ���� �Ұ�.
        InterfaceClass obj1 = new InterfaceClass(); //Ŭ������ ��ü ���� ����.
	    obj1.method1();
	    obj1.method2();
//	    System.out.println(obj1.CONSTANT_NUM + "/" + obj1.CONSTANT_STRING); ��ü������ static access �� ��õ���� �ʴ´�.
	    System.out.println(Interface.CONSTANT_NUM + "/" + Interface2.CONSTANT_STRING);
	    Interface obj2 = new InterfaceClass(); //Ŭ������ ��ü ���� ����.
	    obj2.method1();
	    if (obj2 instanceof InterfaceClass) {
	      ((InterfaceClass)obj2).method2();
	    }
	    Interface2 obj3 = new InterfaceClass();
	    obj3.method2();
	}

}
