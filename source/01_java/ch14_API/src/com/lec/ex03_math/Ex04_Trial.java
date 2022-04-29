package com.lec.ex03_math;
import java.util.Random;
public class Ex04_Trial {
	public static void main(String[] args) {
		  int [] lotto = new int [6];
          Random random = new Random();
          for (int idx = 0 ; idx<lotto.length ; idx++) {
        	lotto[idx] = random.nextInt(45)+1; 
          } // for - lotto 6개 추출
          for(int i =0 ; i<lotto.length ; i++) {
        	  for(int j = i+1 ; j<lotto.length ; j++) {
        		  if(lotto[i]>lotto[j]) {
        			int temp =   lotto[i];
        			lotto[i] = lotto[j];
        			lotto[j] = temp;
        		  }
        	  }
          }//오름차순 정렬 아직은 중복 있음
          for(int l : lotto) {
        	  System.out.print(l+"\t");
          }// 하지만 중복되는 수가 있기에 안됨.
	}
}
