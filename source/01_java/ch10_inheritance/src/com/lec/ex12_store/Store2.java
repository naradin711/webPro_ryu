package com.lec.ex12_store;
// ºÎ´ëÂî°³-5,000  ºñºö¹ä-5,000  °ø±â¹ä-¹«·á
public class Store2 extends HeadQuaterStore {
	public Store2(String str) {
		super(str);
	}
    @Override
    public void budae() {
    	System.out.println("ºÎ´ëÂî°³ 5,000¿ø ");
    }
    @Override
    public void bibim() {
    	System.out.println("ºñºö¹ä 5,000¿ø");
    }
    @Override
    public void gongibab() {
    	System.out.println("¹«·á!");
    }
}
