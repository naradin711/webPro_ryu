package com.lec.loop;
// 1~100���� 3�� ����� �ո� ������ �����?
public class Ex07_for_while {
   public static void main (String[] args) {
	   int sum = 0;
	   int i=1;
	   while(i<101) {
		   if(i%3==0) {
			   sum += i;
		   }
		   ++i;
	   }
//	  int sum = 0;
//	  for (int i=3; i<100; i+=3) {
//		  sum += i;
//	  }
  System.out.println("1~100���� 3�� ����� �� ���� "+sum);
}
}