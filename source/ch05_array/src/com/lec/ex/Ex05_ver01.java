package com.lec.ex;
// ����, ����, ����, ����, ������ Ű�� �Է¹ް�, ��� Ű�� ����Ͻÿ�.
// ����� ģ���̸��� Ű, �ִܽ� ģ�� �̸��� Ű ���
import java.util.Scanner;
public class Ex05_ver01{
	public static void main (String [] args) {
		   String[] arrName= {"����", "����", "����", "����", "����"};
		   int [] arrHeight = new int[arrName.length];
		   int totalHeight = 0;
		   Scanner sc = new Scanner(System.in);
		   for(int i=0; i<arrHeight.length ; i++) {
			   System.out.print(arrName[i]+ "�� Ű��? ");
			   arrHeight[i] = sc.nextInt();
			   totalHeight += arrHeight[i];
		   }
		   System.out.print("���Ű : ");
		   System.out.println((double)totalHeight/arrName.length + "cm ");
		   sc.close();
	}
}