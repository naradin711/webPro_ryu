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
	       // return vaule%2 ==0 ? "¦���Դϴ�." : "Ȧ���Դϴ�."    
		       String result = null;
		       if(vaule%2 == 0) {
		  		  return " ¦���Դϴ�.";
		  	   } else {
		  		 return " Ȧ���Դϴ�.";  
		       }
		   }
	  public static int sum(int to) { // �Լ��� �����ε� // �ƹ��͵� �� ���� ���� ��Ű������ ���� ����.
		   int result = 0 ;
		   for(int i=1; i<=to ; i++) {
		       result += i;
		   }
		   return result;
	   }
	   public static int sum(int from, int to) { // from ~ to ���� ������ ����� return
	       int result = 0 ;
		   for(int i=from; i<=to ; i++) {
		       result += i;
	       }
		   return result;
	   }
}
