package com.lec.ex;
import java.util.Scanner;
//����ڷκ��� ���� �Է¹޾�  �Է¹��� ��(3) ! = 3*2*1 (���丮�� ����ϴ� �޼ҵ� �̿�)
public class Ex06_factorial {
	public static void main(String[] args) {
		int su;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("����� �Է��ϼ��� : ");
			su = scanner.nextInt();
		}while(su<=0);
		long result = factorial(su);
		System.out.println("�Է��Ͻ� "+su+"! = "+result);
//		System.out.printf("�Է��Ͻ� %d != %d", su, result);
	}
	private static long factorial(int su) { // su�� 1�ʰ��� ��� : su * facorial(su-1)
		if (su==1) {
			return 1;
		}else {
			return su * factorial(su-1); // ����� �Լ� ȣ��
		}
	}
//	private static long factorial(int su) {
//		int result = 1;
//		for (int i=su ; i>=1 ; i--) {
//			result *= i; //result = result * i;
//		}
//		return result;
//	}
}