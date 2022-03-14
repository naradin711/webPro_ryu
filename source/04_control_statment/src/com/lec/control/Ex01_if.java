package com.lec.control;

public class Ex01_if {
	 public static void main(String[]ars) {
		 int seoulLunchPrice = 4500;
		 if ( seoulLunchPrice >= 8000 ) {
		 System.out.println("서울 점심값 비싸네요");	 
		 }
		 else if ( seoulLunchPrice >= 6000 ) {
			 System.out.println("서울 밥값 ㅇㅈ? ㅇㅇㅈ.");	 
			 }
		 else if ( seoulLunchPrice >= 5000 ) {
			 System.out.println("좋은데?");	 
			 }
		 else {
			 System.out.println("식당 망하는거 아냐?");}
		 }
}
