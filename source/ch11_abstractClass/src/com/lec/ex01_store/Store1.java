package com.lec.ex01_store;
// �δ��-5,000  ���뱹-���Ⱦ� 
public class Store1 extends HeadQuaterStore {
	public Store1(String str) {
		super(str);
	}
	@Override
	public void kimchi() {
		System.out.println("��ġ� 4,500�� ");
	}
    @Override
    public void budae() {
    	System.out.println("�δ�� 5,000�� ");
    }
    @Override
	public void bibim() {
    	System.out.println("����� 6,000�� ");
	}
    @Override
    public void sundae() {
    	System.out.println("���� ���Ⱦ�");
    }
	@Override
	public void gongibab() {
		System.out.println("����� 1,000��");
	}
}
