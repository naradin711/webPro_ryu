package com.lec.ex;
// API�� �̿��� �迭 ���� - System.arraycopy(�����迭, ��������idx, ���纻�迭, ���纻 idx, �� ����)
public class Ex04_array_copy2 {
	public static void main (String [] args) {
		   int i = 10; // ��������, �ʱ�ȭ
		   int j = 20;
		   j=99;
		   System.out.printf("i = %d, j = %d\n" , i, j);
		   int[] score = {100,10,20,30,40};
		   int[] s = new int [score.length];
           System.arraycopy(score, 0, s, 0, score.length);
		   s[0]=999;
		   for(int idx = 0 ; idx<score.length; idx++) {
		   System.out.printf("score[%d]=%d  s[%d]=%d\n" , idx, score[idx], idx, s[idx]);
		   }
    }
}