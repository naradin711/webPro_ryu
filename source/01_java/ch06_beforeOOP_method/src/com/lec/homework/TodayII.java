package com.lec.homework;
import java.util.Scanner;
/*����ڷκ��� ���� �Է¹޾� ���밪�� ����ϴ� ������ �����Ͻÿ� 
 * (��, �Ű������� �޾� ���밪�� �����ϴ� �Լ�=�޼ҵ带 �̿��մϴ�)*/
public class TodayII {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int su = sc.nextInt();
		int result = abs(su);
		System.out.print("���밪�� "+result);
		sc.close();
	}
	public static int abs(int value) {
		return value>=0 ? value : -value;
	}
}
