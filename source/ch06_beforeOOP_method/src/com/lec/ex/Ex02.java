package com.lec.ex;
// 1~10까지 정수의 합을 출력하고 그 합이 짝수인지 홀수인지 출력하기
public class Ex02 {
   public static void main(String[] args) {
	  int tot = sum(10);
	  System.out.println("1~10까지 정수의 합은 "+tot+" 입니다.");
	  System.out.println(evenOdd(tot));
	  
	  // from~to까지 누적하는 로직
	  // 짝홀수 판별하는 로직 불러 sysout
	  
	  tot = sum(10, 100);
	 System.out.println("10~100까지 정수의 합은 "+tot+" 입니다.");
	 System.out.println(evenOdd(tot));
	 
   }
   private static String evenOdd(int vaule) {
       // return vaule%2 ==0 ? "짝수입니다." : "홀수입니다."    
	       String result = null;
	       if(vaule%2 == 0) {
	  		  return "짝수입니다.";
	  	   } else {
	  		 return "홀수입니다.";  
	       }
	   }
   private static int sum(int to) {
	   int result = 0 ;
	   for(int i=1; i<=to ; i++) {
	       result += i;
	   }
	   return result;
   }
   private static int sum(int from, int to) { // from ~ to 까지 누적한 결과를 return
       int result = 0 ;
	   for(int i=from; i<=to ; i++) {
	       result += i;
       }
	   return result;
   }
}
