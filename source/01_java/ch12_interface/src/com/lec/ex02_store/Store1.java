package com.lec.ex02_store;
// �δ��-5,000  ���뱹-���Ⱦ� 
public class Store1 implements HeadQuaterStore {
	private String str;
	public Store1(String str) {
	   this.str = str;
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
	public String getStr() {
		return str;
	}	
}
