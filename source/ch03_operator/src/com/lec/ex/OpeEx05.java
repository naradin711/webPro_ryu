package com.lec.ex;
// 삼항연산자 : (조건) ? (참일 경우 취할 값이나 식) : (거짓일 경우 취할 값이나 식)
public class OpeEx05 {
       public static void main (String[] args) {
       int h= 100;
       String result;
       result = (h%2==0) ? "짝수" : "홀수" ;
//       if (h%2==0) {
//    	   result = "짝수";}
//       else
//           {result = "홀수";}
       System.out.println("삼항연산 결과 h는 "+result+" 입니다.");
}
}