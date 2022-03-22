package com.lec.ex12_store;
// ±èÄ¡Âî°³-6,000  ºÎ´ëÂî°³-7,000  ºñºö¹ä-7,000 ¼ø´ë±¹-6,000
public class Store3 extends HeadQuaterStore {
	public Store3(String str) {
		super(str);
	}
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ 6,000¿ø ");
	}
    @Override
    public void budae() {
    	System.out.println("ºÎ´ëÂî°³ 7,000¿ø ");
    }
    @Override
    public void bibim() {
    	System.out.println("ºñºö¹ä 7,000¿ø");
    }
    @Override
    public void sundae() {
    	System.out.println("¼ø´ñ±¹ 6,000¿ø");
    }
}
