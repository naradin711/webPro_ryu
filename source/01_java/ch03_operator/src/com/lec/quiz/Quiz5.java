package com.lec.quiz;
//��,��,�� ������ ����ڿ��� �Ҵ�ް� �� ������ ����ϰ� ����, ��� �Ҽ��� 2�ڸ����� ����Ͻÿ�.
import java.util.Scanner;

public class Quiz5 {
	public static void main (String[] args) {
  Scanner scanner = new Scanner(System.in);
  System.out.print("���� : ");
  int a = scanner.nextInt(); // ����ڷκ��� ���� �Է� ��� 
  System.out.print("���� : ");
  int b = scanner.nextInt(); // ����ڷκ��� ���� �Է� ��� 
  System.out.print("���� : ");
  int c = scanner.nextInt(); // ����ڷκ��� ���� �Է� ��� 
  System.out.printf("\n���� %d ���� %d ����%d\n\n", a,b,c);
  int d = a + b + c;
  double e = d/3.00;
  System.out.printf("���� %d ��� %.2f", d,e);
  scanner.close();
	}
}