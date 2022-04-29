package com.lec.ex12_store;
// ºÎ´ëÂî°³-5,000  ¼ø´ë±¹-¾ÈÆÈ¾Æ 
public class Store1 extends HeadQuaterStore {
	public Store1(String str) {
		super(str);
	}
    @Override
    public void budae() {
    	System.out.println("ºÎ´ëÂî°³ 5,000¿ø ");
    }
    @Override
    public void sundae() {
    	System.out.println("¼ø´ñ±¹ ¾ÈÆÈ¾Æ");
    }
}
