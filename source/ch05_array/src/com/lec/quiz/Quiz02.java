package com.lec.quiz;
// 2차원 배열에 저장된 값의 합계를 구하시오
public class Quiz02 {
	 public static void main (String[] args){
		  int[][]arr={{5, 5, 5, 5, 5},
				  {10, 10, 10, 10, 10},
				  {20, 20, 20, 20, 20},
				  {30, 30, 30, 30, 30}};
		  int total = 0;
		  for(int i=0 ; i<arr.length ; i++) {
			  for(int j=0 ; j<arr[i].length ; j++) {
				  total += arr[i][j];  
			  }
		  }
		  System.out.printf("합계는 %d 입니다.", total);
}
}