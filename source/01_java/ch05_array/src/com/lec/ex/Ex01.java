package com.lec.ex;

public class Ex01 {
   public static void main(String[] args) {
      int i =10;	// ������ ����� �ʱ�ȭ
      // �� 1. �迭 ������ ����� �ʱ�ȭ�� �Ѳ�����
      int [] iArr = {10,20,30,40,50};
      iArr[2] = 30; //�迭�� index�� ���� (0~4=iArr.length-1����)
      for(int idx = 0 ; idx<5 ; idx++) {
    	  System.out.printf("%d \n" , iArr[idx]  ); 
      }// for
      // �� 2. �迭 ������ ����� �迭 �޸� ���� Ȯ��. = �迭ũ�� ������ ���� �Ұ�.
      int[] iArr2 = new int[5];
      for(int idx = 0; idx<iArr2.length ; idx++) {
    	  System.out.printf("iArr2[%d] = %d\n", idx, iArr2[idx]);
      }// for
      iArr2 [0]=999; iArr2 [1]=888;
      for(int idx = 0; idx<iArr2.length ; idx++) {
    	  System.out.printf("iArr2[%d] = %d\n", idx, iArr2[idx]);
      }// for
      //�� 3. �迭 ���� ����
      int[] iArr3;
      iArr3 = new int [3]; // �迭 ���� Ȯ���ϰ� �� ���� ���� 0���� �ڵ� �ʱ�ȭ.
      for(int idx=0 ; idx<iArr3.length ; idx++ ) {
    	  System.out.printf("iArr3[%d] = %d\n", idx, iArr3[idx]);
      }// for
   }//main
}//class











