package com.lec.homework;
import java.util.Scanner;
/* ������ ���� : ����ڷκ��� ���ϴ� �ܼ�(2~9) �������� ����ϴ� ���α׷��� �����Ͻÿ�.
(��, �ܼ��� �Ű������� �޾� �ش� �ܼ��� �������� ����ϴ� �κ��� method�� ó���Ѵ�. 
����ڰ� 2~9 ������ ���� �ƴ� ���� �Է��� �� 2~9������ ���� �Է��� ������ ��� �Է� �޴´�.)
   �ڹ������� ÷���Ͽ� yisy0703@naver.com�� ���Ϸ� �����մϴ�(12:00)
 */
public class TodayI_2 {
	public static void main(String[] args) {
		// ����ڷ� ���� 2~9������ ���ϴ� �������� �޴´�.
		Scanner sc = new Scanner(System.in);
		int dansu;
		while(true) {
			System.out.print("����� ���ϴ� ������ ���� ?(2~9�ܱ����� ��)");
			dansu = sc.nextInt();
			if (dansu>=2 && dansu<=9) {
				break;
			}
		}
		guguPrint(dansu);// ����ڷκ��� ���� ���� �������� ���
		sc.close();
	}
	private static void guguPrint(int dansu) {// ����ڷκ��� ���� ���� �������� ���
		for(int i=1 ; i<10 ; i++) {
			System.out.printf("%d * %d = %d\n", dansu, i, dansu*i);
		}
	}
}
