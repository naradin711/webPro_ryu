package com.lec.ex01_store;
// �δ��-5,000  �����-5,000  �����-����
public class Store2 extends HeadQuaterStore {
	public Store2(String str) {
		super(str);
	}
	@Override
	public void kimchi() {
		System.out.println("��ġ� 5,000�� ");
	}
    @Override
    public void budae() {
    	System.out.println("�δ�� 5,000�� ");
    }
    @Override
    public void bibim() {
    	System.out.println("����� 5,000��");
    }
    @Override
	public void sundae() {
    	System.out.println("���뱹 5,000�� ");
	}
    @Override
    public void gongibab() {
    	System.out.println("������� ����!");
    }
	
	
}
