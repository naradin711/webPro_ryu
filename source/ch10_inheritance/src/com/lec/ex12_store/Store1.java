package com.lec.ex12_store;
// �δ��-5,000  ���뱹-���Ⱦ� 
public class Store1 extends HeadQuaterStore {
	public Store1(String str) {
		super(str);
	}
    @Override
    public void budae() {
    	System.out.println("�δ�� 5,000�� ");
    }
    @Override
    public void sundae() {
    	System.out.println("���� ���Ⱦ�");
    }
}
