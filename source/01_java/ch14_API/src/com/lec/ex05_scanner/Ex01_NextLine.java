package com.lec.ex05_scanner;

import java.util.Scanner;

public class Ex01_NextLine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		   System.out.print("���̸� �Է��ϼ��� : ");
		   int age = sc.nextInt();//\n ���� ������ �����´�.
		   System.out.println("�Է��Ͻ� ���̴� "+age);
		   
		   System.out.print("�̸��� �Է��ϼ��� : ");
		   String name = sc.next();//whitespace�ձ����� ����
		   System.out.println("�Է��Ͻ� �̸��� "+name);
		   
		   System.out.print("�ּҸ� �Է��ϼ��� : ");
		   sc.nextLine(); // ������ �����ִ� \n �� ����� ����
		   String address = sc.nextLine(); // \n ���� �տ� �ִ� ���� �����ϰ� 
		   System.out.println("�Է��Ͻ� �ּҴ� "+address);
		   sc.close();
	}
   
}
