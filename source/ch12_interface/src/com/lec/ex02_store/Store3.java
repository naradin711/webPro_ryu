package com.lec.ex02_store;
// ��ġ�-6,000  �δ��-7,000  �����-7,000 ���뱹-6,000
public class Store3 implements HeadQuaterStore {
	private String str;
	public Store3(String str) {
	   this.str = str;
	}
	@Override
	public void kimchi() {
		System.out.println("��ġ� 6,000�� ");
	}
    @Override
    public void budae() {
    	System.out.println("�δ�� 7,000�� ");
    }
    @Override
    public void bibim() {
    	System.out.println("����� 7,000��");
    }
    @Override
    public void sundae() {
    	System.out.println("���� 6,000��");
    }
	@Override
	public void gongibab() {
		System.out.println("����� 1,000��");
	}
	public String getStr() {
		return str;
	}
	
}
