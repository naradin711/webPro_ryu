package com.lec.quiz;
//거스름돈 2680을 
//500, 100, 50, 10짜리 동전으로 줄 때, 몇 개씩 주어야 하나?
public class Quiz04_mine {
	public static void main (String[] args){
		  int[] coin = {500,100,50,10};
		  int unit5 = 0, unit1 = 0, unit15 = 0, unit11 = 0;
		  int money = 2680 ;
		 	 unit5= money/coin[0];
			 money= money%coin[0];
			 unit1 =money/coin[1];
			 money= money%coin[1];
			 unit15 = money/coin[2];
			 money= money%coin[2];
			 unit11 = money/coin[3];	
			 System.out.printf("500원 짜리 %d개, 100원 짜리 %d개, 50원 짜리 %d개, 10원 짜리 %d개 줘야 한다.", unit5,unit1,unit15,unit11);
				
 }
}