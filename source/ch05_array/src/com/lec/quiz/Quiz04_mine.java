package com.lec.quiz;
//�Ž����� 2680�� 
//500, 100, 50, 10¥�� �������� �� ��, �� ���� �־�� �ϳ�?
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
			 System.out.printf("500�� ¥�� %d��, 100�� ¥�� %d��, 50�� ¥�� %d��, 10�� ¥�� %d�� ��� �Ѵ�.", unit5,unit1,unit15,unit11);
				
 }
}