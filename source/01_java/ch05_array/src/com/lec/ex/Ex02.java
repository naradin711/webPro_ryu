package com.lec.ex;
// �Ϲ� for ��. vs Ȯ�� for �� (�迭 ���)
public class Ex02 {
   public static void main (String [] args) {
	  int [] arr = new int [3]; // {0,0,0}
	  for(int idx = 0; idx<arr.length; idx++) { // �Ϲ�  for�� �̿��� ���
		  System.out.printf("arr[%d] = %d\n" , idx, arr[idx]);  
	  }
	  for(int temp : arr ) { // Ȯ��  for�� �̿��� ���
		  System.out.println(temp);
		  // ���� ���� ����Ҷ� �̿��ϱ�!
	  }
	  for(int i=0 ; i<arr.length ; i++) {
		  arr[i] = 5;
	  }
	  for(int temp : arr ) { // Ȯ��  for���� �̿��� �迭 ������ �Ұ���. temp ���� ����� ��.
		  temp =9;
		  // ���� ���� ����Ҷ� �̿��ϱ�!
	  }
	  System.out.println("������");
	  for(int temp : arr ) { // Ȯ��  for�� �̿��� ���
		  System.out.println(temp);
		  // ���� ���� ����Ҷ� �̿��ϱ�!
	  }
	  
	  
   }
}
