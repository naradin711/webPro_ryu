package com.lec.control;

import java.util.Scanner;

// ����ڷκ��� ������ �Է¹޾� ���� ���
public class Ex04_switch_hakjum {
   public static void main (String []args) {
	  Scanner sc = new Scanner(System.in); 
	  System.out.print(" ���� : ");
	  int score = sc.nextInt();
	  int temp = score==100 ? score-1 : score;
	  // temp = (-9<=temp && temp<0)? -10 :temp;
	  switch ( temp / 10){
	  case 9 : System.out.println("A����"); break;
	  case 8 : System.out.println("B����"); break;
	  case 7 : System.out.println("C����"); break;
	  case 6 : System.out.println("D����"); break;
	  case 5 : case 4 : case 3 : case 2 : case 1 : case 0 :
		     System.out.println("F����"); break;
	  default :
		     System.out.println("��ȿ���� �ʴ� ������ �Է��ϼ̽��ϴ�.");
	  }
	  sc.close();
   }
}