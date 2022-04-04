package com.lec.ex03_math;
import java.util.Random;
public class Ex05_Lotto {
	public static void main(String[] args) {
		  int [] lotto = new int [6];
          Random random = new Random();
          for (int idx = 0 ; idx<lotto.length ; idx++) {
        	// lotto[idx] = random.nextInt(45)+1; 
        	  int temp = random.nextInt(45)+1;
        	  // ���� ������ �ӽ� ������ �����ϰ�
        	  boolean ok = true;
        	  for(int i=0 ; i<idx ; i++) {
        		  if(temp == lotto[i]) {//���� ������ �ߺ��̴� �ٽ� �̾ƾ� ��.
        		  idx --;
        		  ok = false;
        		  break;
        		  }
        	  }//  for : �߻��� ������ ���� �� �濡 �����Ǿ����� Ȯ�� (�ߺ��� ��������)
        	  if(ok) {
        		  lotto[idx] = temp;
        	  }
          } // for - lotto 6�� ����
          for(int i =0 ; i<lotto.length ; i++) {
        	  for(int j = i+1 ; j<lotto.length ; j++) {
        		  if(lotto[i]>lotto[j]) {
        			int temp =   lotto[i];
        			lotto[i] = lotto[j];
        			lotto[j] = temp;
        		  }
        	  }
          }//for�� �������� ���� 
          for(int l : lotto) {
        	  System.out.print(l+"\t");
          }
	}
}
