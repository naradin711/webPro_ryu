package com.lec.ex08_superdot;
//super.  = 내 부모 클래스의
//super() = 내 부모 클래스의 생성자 함수.
public class ChildClass extends ParentClass { // ParentClass - i, method()
    private int i = 99;
    public ChildClass() {
    	System.out.println("ChildClass 생성자");
    }
    @Override
    public void method() {	
        System.out.println("ChildClass의 method");
    	super.method(); // 나의 부모 Class에서 method를 가져옴.
    	System.out.println("ChildClass에서 super의 i= "+super.getI()+", Child 클래스의 i= "+i );
    }
    public int getI( ) {
    	return i;
    }
}
