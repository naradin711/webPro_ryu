package com.lec.quiz;
//���� �� ���ڸ� �Է¹޾Ƽ� �� ���� ������ ����� O�� X�� ���
//     ù��° ���ڰ� �� ū�� ����� O�� X�� ����Ѵ�.
import java.util.Scanner;

public class Quiz3 {
	public static void main (String[] args) {
  Scanner scanner = new Scanner(System.in);
  System.out.print("ù��° ���ڸ� �Է��ϼ��� : ");
  int i = scanner.nextInt(); // ����ڷκ��� ���� �Է� ���
  System.out.print("�ι�° ���ڸ� �Է��ϼ��� : ");
  int k = scanner.nextInt(); // ����ڷκ��� ���� �Է� ���
  String result = ((i==k) ? "O" : "X"); 
  System.out.println(result);
  String result2 = ((i>k) ? "O" : "X"); 
  System.out.println(result2);
  scanner.close();
	}
}