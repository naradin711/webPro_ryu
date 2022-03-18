package com.lec.ex03_access;

public class AccessTest {
	private   int privateMember; // 같은 클래스 내에서만 사용가능
              int defaultMember; // 같은 패키지 내에서만 사용가능
    protected int protectedMember;// 같은 패키지나 상속받은 하위클래스 에서만 사용가능
    public    int publicMember; // 아무데서나 다 사용가능.
    
    private   void privateMethod( ) {
    	System.out.println("privateMethod");
    }
              void defaultMethod() {
        System.out.println("defaultMethod");   	
    }
    protected void protectedMethod( ) {
    	System.out.println("protectedMethod");
    }
    public    void publicMethod( ) {
    	System.out.println("publicMethod");
    }
}
