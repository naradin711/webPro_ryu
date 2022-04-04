package com.lec.ex01_string;

import java.util.StringTokenizer;

public class Ex12_stringTokenizer {
	public static void main(String[] args) {
		String str1 = "�ں��� ���� ���� ��ҿ� �嵿��";
		String str2 = "03/28/2022";
		StringTokenizer tkn1 = new StringTokenizer(str1);// space �������� ���ڿ��� �����Ѵ�.
		System.out.println("tkn1�� ��ū ���� : "+ tkn1.countTokens()); //��ū ����
		while(tkn1.hasMoreTokens()) {
			  System.out.println(tkn1.nextToken()); //��ū�� �������� ���� ��ū ��� ���
		}//while����
		StringTokenizer tkn2 = new StringTokenizer(str2, "/");
		System.out.println("tkn2�� ��ū ���� : "+ tkn2.countTokens());
		while(tkn2.hasMoreTokens()) {
			  System.out.println(tkn2.nextToken()); //��ū�� �������� ���� ��ū ��� ���
		}
	}

}
