package com.lec.ex06_wrapper;

import java.util.Scanner;

public class Ex04 {
// ����ڷκ��� ���� ���ڿ� "100" �� �޾� ������ �����ؼ� ����ϴ� ���α׷�
	public static void main(String[] args) {
       Scanner sc = new Scanner (System.in);
       System.out.print("������ �Է��ϼ��� : ");
       String nStr = sc.nextLine();
       System.out.println("�Է��Ͻ� ���ڿ��� "+nStr);
       nStr = nStr.trim();//�¿� ���� ����
       nStr = nStr.replaceAll("[a-zA-Z��-�R]", "");
       int num = Integer.parseInt(nStr);
       System.out.println("������ ������ "+num);
       
	}

}
