package com.lec.ex01_string;

public class Ex10_StringBuffer {
	public static void main(String[] args) {
		StringBuilder stBuilder = new StringBuilder("abc");
		System.out.println("�ؽ��ڵ� ��� : "+stBuilder.hashCode());
		// �� �ܰ迡�� �ּҰ� ������ �Ϸ�.
		System.out.println("stBuilder : " + stBuilder);
		stBuilder.append("def"); //������ abc�� def�� �߰�.
		System.out.println("stBuilder : " + stBuilder);
		stBuilder.insert(3, "AAA"); //3��°�� AAA�߰�
		System.out.println("stBuilder : " + stBuilder);
		System.out.println("�ؽ��ڵ� ��� : "+stBuilder.hashCode());
		stBuilder.deleteCharAt(3); //3 ��° ���ڸ� ����
		System.out.println("stBuilder : " + stBuilder);
		System.out.println("�ؽ��ڵ� ��� : "+stBuilder.hashCode());

	}

}
