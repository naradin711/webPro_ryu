package com.lec.ex06_override;
//ParentClass의 method1, method2 모두 상속받은 상태.

public class ChildClass extends ParentClass {
   public ChildClass ( ) {
	   System.out.println("매개 변수 없는 ChildClass 생성자");
   }
   public ChildClass (int i ) {
	   System.out.println("매개 변수 있는 ChildClass 생성자");
   }
   public void method3() {
	   System.out.println("ChildClass의 method3() 함수");
   }
   @Override
   public void method1() { //ParentClass의 method1 오버라이드
	   System.out.println("ChildClass의 method1() 함수");
	}
   @Override
	public boolean equals(Object obj) { // Object 클래스의 equals 오버라이드.
		return true;
	}
}
