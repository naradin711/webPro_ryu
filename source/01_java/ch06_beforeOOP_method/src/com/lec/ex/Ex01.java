package com.lec.ex;
// 1~10���� ������ ���� ����ϰ� �� ���� ¦������ Ȧ������ ����ϱ�
public class Ex01 {
   public static void main(String[] args) {
	  int tot = 0;
	  for (int i=1 ; i<=10 ; i++) {
		  tot += i; // tot = tot + i
	  }
	 System.out.println("1~10���� ������ ����"+tot+"�Դϴ�.");
	 if(tot%2 == 0) {
		 System.out.println("¦���Դϴ�.");
	 }
	 else {
		 System.out.println("Ȧ���Դϴ�.");
	 }
}
}
