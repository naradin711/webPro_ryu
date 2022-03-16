package com.lec.method;
// Arithmetic.sum / evenOdd (static 메소드) vs. abs (일반 메소드)
public class Ex03 {
   public static void main(String[] args) {
	   Arithmetic ar = new Arithmetic();
	   // 같은 패키지에서 static 없는 함수를 적용하기 위해서 변수를 가져오는 문장.
	   int tot = ar.sum(7);	
      // 같은 패키지일때 다른 꾸러미에서 메소드 적용시키기
      // public을 쓰지 않을 경우 아무것도 없으면 동일 패키지에만 적용 가능.
      System.out.println("1~7까지 합은 " + tot );
      System.out.println(tot +"은"+ ar.evenOdd(tot) );
      System.out.println(ar.abs(-7));
   }
}
