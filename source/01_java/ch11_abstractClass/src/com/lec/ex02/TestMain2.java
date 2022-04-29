package com.lec.ex02;

public class TestMain2 {
   public static void main (String [] args) {
//    SuperClass sc = new SuperClass(); 추상클래스를 이용한 객체 생성불가.
//    ChildClass2 cc2 = new ChildClass2();   
	  ChildClass2 gc = new GrandChild();
	  gc.method1();
	  gc.method2();
   }
}
