package com.lec.ex02;

public class TestMain2 {
   public static void main (String [] args) {
//    SuperClass sc = new SuperClass(); �߻�Ŭ������ �̿��� ��ü �����Ұ�.
//    ChildClass2 cc2 = new ChildClass2();   
	  ChildClass2 gc = new GrandChild();
	  gc.method1();
	  gc.method2();
   }
}
