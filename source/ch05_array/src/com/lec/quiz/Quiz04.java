package com.lec.quiz;
//거스름돈 2680을 
//500, 100, 50, 10짜리 동전으로 줄 때, 몇 개씩 주어야 하나?
public class Quiz04 {
	public static void main (String[] args){
		  int money = 2680;
		  int[] coinunit = {500,100,50,10};
          for(int i = 0 ; i<coinunit.length ; i++) {
          System.out.println(coinunit[i] + "원짜리 동전"+ (money/coinunit[i])+ "개");
          money %= coinunit[i];
          }
	}
}