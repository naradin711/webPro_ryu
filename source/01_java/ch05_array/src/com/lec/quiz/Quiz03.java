package com.lec.quiz;
//76, 45, 34, 89, 100, 50, 90, 92값을 1차원 배열로 초기화 하고 
//값에 합계와  평균 그리고 최대값과 최소값을 구하는 프로그램을 작성하시오.
public class Quiz03 {
	public static void main (String[] args){
		  int[] arr = {76, 45, 34, 89, 100, 50, 90, 92};
		  int sum = 0 , avg = 0;
		  for (int i=0 ; i<arr.length; i++) {
			  sum += arr[i];
			  avg = sum/(arr.length);		  
			  }//for
		  System.out.printf("합     계 = %d  평      균 = %d\n", sum,avg );
		  int maxidx=0, max=0; // 최장신 키와 인덱스
		   int minidx=0, min=999; // 최단신 키와 인덱스
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
		   System.out.printf("최대값은 = %d, 최소값은 = %d \n", max, min);
  }
}