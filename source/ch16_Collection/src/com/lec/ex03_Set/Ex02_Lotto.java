package com.lec.ex03_Set;
import java.util.*;
public class Ex02_Lotto {
	public static void main(String[] args) {
		HashSet <Integer> lotto = new HashSet <Integer>();
	//	TreeSet <Integer> lotto = new TreeSet <Integer>();
		Random rd = new Random();
		int cnt = 0;
		while (lotto.size()<6) {
			cnt++;
			lotto.add(rd.nextInt(45)+1); // 1~45사이의 정수 난수 add
		}
		System.out.println(cnt + "번 숫자 뽑아 나온 로또 수들 : " +lotto);
	}

}
