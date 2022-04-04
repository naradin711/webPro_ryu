package com.lec.ex01_string;
// String 수정 (10만번) > StringBuffer 수정 10만번 > StringBuilder 수정 10만번
public class Ex11_SpeedCheck {
   public static void main(String[] args) {
	  System.out.println(System.currentTimeMillis());//1970년 1월 1일 부터 지금까지의 밀리세컨드
       // 스트링 변경 10만번 - 시간 체크
	   String str = "A";
	   long startTime = System.currentTimeMillis(); // 로직 시작 시점.
	   for (int i=0 ; i<100000 ; i++) { //10만번 수정
		   str = str +"a";
	   }
	   long endTime = System.currentTimeMillis();
	   System.out.println("String 10만번 수정경과시간 : "+(endTime-startTime));
	   // StringBuffer 변경 10만번 시간체크
	   StringBuffer stBuf = new StringBuffer("A") ;
	   startTime = System.currentTimeMillis();
	   for (int i=0 ; i<100000 ; i++) { //10만번 수정
		   stBuf.append("a");
	   }
	   endTime = System.currentTimeMillis();
	   System.out.println("StringBuffer 10만번 수정경과시간 : "+(endTime-startTime));
	   // StringBuilder 변경 10만번 시간체크
	   
	   StringBuilder stBud = new StringBuilder("A");
	   startTime = System.currentTimeMillis();
	   for (int i=0 ; i<100000 ; i++) { //10만번 수정
		   stBud.append("a");
	   }
	   endTime = System.currentTimeMillis();
	   System.out.println("StringBuilder 10만번 수정경과시간 : "+(endTime-startTime));
	  
	   
   }
}
