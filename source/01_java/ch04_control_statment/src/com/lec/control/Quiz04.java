package com.lec.control;
// ���������� ���� �� ���� ����غ���
import java.util.Scanner;

public class Quiz04 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
	      System.out.print("����! ����! ��! : ");
	      int num1 = sc.nextInt();
	      if (num1 ==0) {
	    	  System.out.print("\n����");
	      }
	      else if (num1 ==1) {
	    	  System.out.print("\n����");
	      }
	      else if (num1 ==2) {
	    	  System.out.print("\n��");
	      }
	      else 
	    	  System.out.print("\n�峭���� ������!");
	      
	      sc.close();
}
}