package com.lec.control;
// ����,����,���� ������ �Է¹޾Ƽ� �� ���� ������ ��� �̻����� �������� ����ϼ���.
import java.util.Scanner;
public class Quiz03 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
	      System.out.print("���� ������ �Է��ϼ���. : ");
	      int num1 = sc.nextInt();
	      System.out.print("���� ������ �Է��ϼ���. : ");
	      int num2 = sc.nextInt();
	      System.out.print("���� ������ �Է��ϼ���. : ");
	      int num3 = sc.nextInt();
	      int avg = (num1 + num2 + num3)/3 ;
	      if (num1>avg) 
	      { System.out.println("���������� ��� �̻��Դϴ�.");
	      }
	      else {System.out.println("���������� ��� �����Դϴ�.");}
	      if (num2>avg) 
	      { System.out.println("���������� ��� �̻��Դϴ�.");
	      }
	      else {System.out.println("���������� ��� �����Դϴ�.");}
	      if (num3>avg) 
	      { System.out.println("���������� ��� �̻��Դϴ�.");
	      }
	      else {System.out.println("���������� ��� �����Դϴ�.");}
}
}