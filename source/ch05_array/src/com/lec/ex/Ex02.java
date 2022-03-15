package com.lec.ex;
// 일반 for 문. vs 확장 for 문 (배열 출력)
public class Ex02 {
   public static void main (String [] args) {
	  int [] arr = new int [3]; // {0,0,0}
	  for(int idx = 0; idx<arr.length; idx++) { // 일반  for문 이용한 출력
		  System.out.printf("arr[%d] = %d\n" , idx, arr[idx]);  
	  }
	  for(int temp : arr ) { // 확장  for문 이용한 출력
		  System.out.println(temp);
		  // 관련 값만 출력할때 이용하기!
	  }
	  for(int i=0 ; i<arr.length ; i++) {
		  arr[i] = 5;
	  }
	  for(int temp : arr ) { // 확장  for문을 이용한 배열 변경은 불가능. temp 값만 변경될 뿐.
		  temp =9;
		  // 관련 값만 출력할때 이용하기!
	  }
	  System.out.println("수정후");
	  for(int temp : arr ) { // 확장  for문 이용한 출력
		  System.out.println(temp);
		  // 관련 값만 출력할때 이용하기!
	  }
	  
	  
   }
}
