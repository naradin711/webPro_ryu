package com.lec.ex03_math;
import java.util.Random;
public class Ex05_Lotto {
	public static void main(String[] args) {
		  int [] lotto = new int [6];
          Random random = new Random();
          for (int idx = 0 ; idx<lotto.length ; idx++) {
        	// lotto[idx] = random.nextInt(45)+1; 
        	  int temp = random.nextInt(45)+1;
        	  // 뽑은 난수를 임시 변수에 저장하고
        	  boolean ok = true;
        	  for(int i=0 ; i<idx ; i++) {
        		  if(temp == lotto[i]) {//뽑은 난수가 중복이니 다시 뽑아야 함.
        		  idx --;
        		  ok = false;
        		  break;
        		  }
        	  }//  for : 발생된 난수가 이전 앞 방에 저정되었는지 확인 (중복된 난수인지)
        	  if(ok) {
        		  lotto[idx] = temp;
        	  }
          } // for - lotto 6개 추출
          for(int i =0 ; i<lotto.length ; i++) {
        	  for(int j = i+1 ; j<lotto.length ; j++) {
        		  if(lotto[i]>lotto[j]) {
        			int temp =   lotto[i];
        			lotto[i] = lotto[j];
        			lotto[j] = temp;
        		  }
        	  }
          }//for문 오름차순 정렬 
          for(int l : lotto) {
        	  System.out.print(l+"\t");
          }
	}
}
