package com.lec.quiz;
//�Ž����� 2680�� 
//500, 100, 50, 10¥�� �������� �� ��, �� ���� �־�� �ϳ�?
public class Quiz04 {
	public static void main (String[] args){
		  int money = 2680;
		  int[] coinunit = {500,100,50,10};
          for(int i = 0 ; i<coinunit.length ; i++) {
          System.out.println(coinunit[i] + "��¥�� ����"+ (money/coinunit[i])+ "��");
          money %= coinunit[i];
          }
	}
}