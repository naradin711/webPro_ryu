package com.lec.ex12_store;
// �δ��-5,000  �����-5,000  �����-����
public class Store2 extends HeadQuaterStore {
	public Store2(String str) {
		super(str);
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
    public void gongibab() {
    	System.out.println("����!");
    }
}
