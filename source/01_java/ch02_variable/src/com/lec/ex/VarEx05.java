package com.lec.ex;

public class VarEx05 {
      public static void main (String[] args) {
    	 float f1, f2;
    	 f1= 10.1F; // F표시를 해서 float 함수를 인식시키자.
    	 f2= 100.1F;
    	 double d1, d2; // 실수형의 기본은 무조건 double
    	 System.out.println("f1="+f1);
    	 f1 = 10.0000017f;
    	 double d = 10.0000017;
    	 System.out.println("f1="+f1);
    	 System.out.println("d="+d);
    	 f1 = 10.1f;
    	 d = 10.1;
    	 if (f1==d)
    	     System.out.println("두 변수는 같다");
    	 else
    	    System.out.println("두 변수는 다르다");
      } 
}