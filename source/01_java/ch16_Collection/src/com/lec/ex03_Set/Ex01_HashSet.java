package com.lec.ex03_Set;
import java.util.*;
public class Ex01_HashSet {
	public static void main(String[] args) {
		HashSet<String> hSet = new HashSet<String>();
		String [] arr = new String [5];
		hSet.add("str0");
		hSet.add("str1");
		System.out.println(hSet);
		hSet.add("str1");
		System.out.println(hSet);
		Iterator<String> iterator =hSet.iterator();
		while(iterator.hasNext()) { //�ش� ���๮�� �� �� ���� ����ȴ�.
			System.out.print(iterator.next()+"\t");
		}

	}

}
