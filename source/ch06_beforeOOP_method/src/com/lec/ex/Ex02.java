package com.lec.ex;
// 1~10���� ������ ���� ����ϰ� �� ���� ¦������ Ȧ������ ����ϱ�
public class Ex02 {
   public static void main(String[] args) {
	  int tot = sum(10);
	  System.out.println("1~10���� ������ ���� "+tot+" �Դϴ�.");
	  System.out.println(evenOdd(tot));
	  
	  // from~to���� �����ϴ� ����
	  // ¦Ȧ�� �Ǻ��ϴ� ���� �ҷ� sysout
	  
	  tot = sum(10, 100);
	 System.out.println("10~100���� ������ ���� "+tot+" �Դϴ�.");
	 System.out.println(evenOdd(tot));
	 
   }
   private static String evenOdd(int vaule) {
       // return vaule%2 ==0 ? "¦���Դϴ�." : "Ȧ���Դϴ�."    
	       String result = null;
	       if(vaule%2 == 0) {
	  		  return "¦���Դϴ�.";
	  	   } else {
	  		 return "Ȧ���Դϴ�.";  
	       }
	   }
   private static int sum(int to) {
	   int result = 0 ;
	   for(int i=1; i<=to ; i++) {
	       result += i;
	   }
	   return result;
   }
   private static int sum(int from, int to) { // from ~ to ���� ������ ����� return
       int result = 0 ;
	   for(int i=from; i<=to ; i++) {
	       result += i;
       }
	   return result;
   }
}
