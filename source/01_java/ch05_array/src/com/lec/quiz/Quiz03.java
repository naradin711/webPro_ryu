package com.lec.quiz;
//76, 45, 34, 89, 100, 50, 90, 92���� 1���� �迭�� �ʱ�ȭ �ϰ� 
//���� �հ��  ��� �׸��� �ִ밪�� �ּҰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
public class Quiz03 {
	public static void main (String[] args){
		  int[] arr = {76, 45, 34, 89, 100, 50, 90, 92};
		  int sum = 0 , avg = 0;
		  for (int i=0 ; i<arr.length; i++) {
			  sum += arr[i];
			  avg = sum/(arr.length);		  
			  }//for
		  System.out.printf("��     �� = %d  ��      �� = %d\n", sum,avg );
		  int maxidx=0, max=0; // ����� Ű�� �ε���
		   int minidx=0, min=999; // �ִܽ� Ű�� �ε���
		   for (int i=0; i<arr.length; i++) {
			   if(arr[i]>max) {
				     max = arr[i];
				     maxidx = i;
			   }
			   if(arr[i]<min) {
				     min = arr[i];
				     minidx = i;
			   }
		   }
		   System.out.printf("�ִ밪�� = %d, �ּҰ��� = %d \n", max, min);
  }
}