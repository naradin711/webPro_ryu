package com.lec.quiz;
//�Է��� ���� ¦������ Ȧ������ ���
import java.util.Scanner;

public class Quiz2 {
	public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("���ڸ� �Է��ϼ��� : ");
    int i = scanner.nextInt(); // ����ڷκ��� ���� �Է� ��� 
    String result = i%2 == 0 ? "¦��" : "Ȧ��";
    System.out.println(result);
    scanner.close();
	}
}