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
			lotto.add(rd.nextInt(45)+1); // 1~45������ ���� ���� add
		}
		System.out.println(cnt + "�� ���� �̾� ���� �ζ� ���� : " +lotto);
	}

}
