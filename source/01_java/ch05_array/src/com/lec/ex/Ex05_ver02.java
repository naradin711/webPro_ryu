package com.lec.ex;
// ����, ����, ����, ����, ������ Ű�� �Է¹ް�, ��� Ű�� ����Ͻÿ�.
// ����� ģ���̸��� Ű, �ִܽ� ģ�� �̸��� Ű ���
import java.util.Scanner;
public class Ex05_ver02{
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
		   System.out.println((double)totalHeight/arrName.length + "cm \n\n");
		   sc.close();
		   int maxIdx=0, maxHeight=0; // ����� Ű�� �ε���
		   int minIdx=0, minHeight=999; // �ִܽ� Ű�� �ε���
		   for (int i=0; i<arrName.length; i++) {
			   if(arrHeight[i]>maxHeight) {
				     maxHeight = arrHeight[i];
				     maxIdx = i;
			   }
			   if(arrHeight[i]<minHeight) {
				     minHeight = arrHeight[i];
				     minIdx = i;
			   }
		   }
		   System.out.printf("���� ���� �л��� : %s, Ű : %d cm\n", arrName[minIdx], minHeight);
		   System.out.printf("���� ū �л��� : %s, Ű : %d cm\n", arrName[maxIdx], maxHeight);
	}
}














