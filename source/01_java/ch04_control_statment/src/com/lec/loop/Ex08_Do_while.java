package com.lec.loop;
import java.util.Scanner;
// do-while �� : �켱 ������ �� ������ �����Ǹ� ���� �ƴϸ� �������� �ʴ´�.
public class Ex08_Do_while {
	public static void main(String[] args) {
		   int num;
		   Scanner sc = new Scanner(System.in);
		   do {
			   System.out.print("�ݵ�� ¦���� �Է��Ͻÿ�. : ");
			   num = sc.nextInt();
		   }while(num%2!=0);
		   System.out.printf("�Է��Ͻ� ���� %d�̰� ¦���Դϴ�.", num);
		   sc.close();
	}
}