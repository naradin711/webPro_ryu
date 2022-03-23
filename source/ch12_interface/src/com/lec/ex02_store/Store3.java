package com.lec.ex02_store;
// ±èÄ¡Âî°³-6,000  ºÎ´ëÂî°³-7,000  ºñºö¹ä-7,000 ¼ø´ë±¹-6,000
public class Store3 implements HeadQuaterStore {
	private String str;
	public Store3(String str) {
	   this.str = str;
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
	@Override
	public void gongibab() {
		System.out.println("°ø±â¹ä 1,000¿ø");
	}
	public String getStr() {
		return str;
	}
	
}
