package com.lec.test;
import java.util.Scanner;
//������ �� �Է¹޾� �ش� ������ ��µǴ� ȭ��
public class Test_week1 {
	public static void main (String []args) {
		  Scanner sc = new Scanner(System.in);
		  System.out.print(" ���Ͻô� �������� �ܼ��� �Է��ϼ��� :  ");
		  int dansu = sc.nextInt();
		  for(int i=1 ; i<10; i++) {
			  int j = dansu*i;
			  System.out.print(dansu +"*"+i+"="+j+"\t");
		  }
		  sc.close();
}
}