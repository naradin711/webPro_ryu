package com.lec.quiz;
//���� ����ڷκ��� �Է¹��� ���� 3�� ������� ���� ���
import java.util.Scanner;

public class Quiz {
	public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("���ڸ� �Է��ϼ��� : ");
    int su = scanner.nextInt(); // ����ڷκ��� ���� �Է� ��� 
    String result = su%3 == 0 ? "�Է��Ͻ� ���ڴ� 3�� ����Դϴ�." : "�Է��Ͻ� ���ڴ� 3�� ����� �ƴմϴ�.";
    System.out.println(result);
    scanner.close();
	}
}