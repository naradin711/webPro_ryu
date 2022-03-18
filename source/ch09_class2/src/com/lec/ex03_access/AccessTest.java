package com.lec.ex03_access;

public class AccessTest {
	private   int privateMember; // ���� Ŭ���� �������� ��밡��
              int defaultMember; // ���� ��Ű�� �������� ��밡��
    protected int protectedMember;// ���� ��Ű���� ��ӹ��� ����Ŭ���� ������ ��밡��
    public    int publicMember; // �ƹ������� �� ��밡��.
    
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
