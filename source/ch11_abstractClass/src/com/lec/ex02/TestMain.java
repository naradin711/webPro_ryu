package com.lec.ex02;

public class TestMain {
   public static void main (String [] args) {
      SuperClass obj = new ChildClass();
	  obj.method1();
	  obj.method2();
//	  SuperClass spc = new SuperClass() {
//		  public void method1() {
//			  System.out.println("�͸�Ŭ���� ����");
//		  }
//	  };
//	  spc.method1();
   }
}
