package com.lec.method;

public class Arithmetic {
	  public int abs(int value) {
		  int result = (value>=0) ? value : -value ;
		  return result;
//		 int result;
//		 if(value >=0) {
//			 result = value;
//		 }else {
//			 result = -value;
//		 } 
	  }
	  public static String evenOdd(int vaule) {
	       // return vaule%2 ==0 ? "짝수입니다." : "홀수입니다."    
		       String result = null;
		       if(vaule%2 == 0) {
		  		  return " 짝수입니다.";
		  	   } else {
		  		 return " 홀수입니다.";  
		       }
		   }
	  public static int sum(int to) { // 함수의 오버로딩 // 아무것도 안 쓰면 동일 패키지에만 적용 가능.
		   int result = 0 ;
		   for(int i=1; i<=to ; i++) {
		       result += i;
		   }
		   return result;
	   }
	   public static int sum(int from, int to) { // from ~ to 까지 누적한 결과를 return
	       int result = 0 ;
		   for(int i=from; i<=to ; i++) {
		       result += i;
	       }
		   return result;
	   }
}
