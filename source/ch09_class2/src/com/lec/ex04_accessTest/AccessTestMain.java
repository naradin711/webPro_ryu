package com.lec.ex04_accessTest;
import com.lec.ex03_access.AccessTest;
public class AccessTestMain {
   public static void main(String[] args) {
	AccessTest obj = new AccessTest();
	//System.out.println(obj.privateMember);
	//System.out.println(obj.defaultMember);
	//System.out.println(obj.protectedMember);
	System.out.println(obj.publicMember);
	
	//obj.privateMethod(); 인식 못함
	//obj.defaultMethod(); 인식 못함
	//obj.protectedMethod(); 인식 못함
	obj.publicMethod();
}
}
