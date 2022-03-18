package com.lec.ex03_access;

public class AccessTestMain {
   public static void main(String[] args) {
	  AccessTest obj = new AccessTest();
	  System.out.println(obj.defaultMember);
	  System.out.println(obj.protectedMember);
	  System.out.println(obj.publicMember);

	  obj.defaultMethod();
	  obj.protectedMethod();
	  obj.publicMethod();
   }
  
}
