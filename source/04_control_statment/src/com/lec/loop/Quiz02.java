package com.lec.loop;
//1~10���� ���� �� ¦�� �Ǵ� Ȧ���� ���� ���غ���.
public class Quiz02 {
	public static void main(String[] args) {
		   int tot = 0; // ������ ����
//		   for(int i =1 ; i <11; i++) {
//			   if(i%2 != 0) {
//				   
//			   }
//		   }
		   for (int i=1 ; i<=10 ; i++) {
			    if(i%2==0) continue;
			    tot += i; //tot = tot + i;   
		   }
		   System.out.println("1~10���� Ȧ���� ���� " + tot);
	}
}