package com.lec.ex02_store;
// ºÎ´ëÂî°³-5,000  ¼ø´ë±¹-¾ÈÆÈ¾Æ 
public class Store1 implements HeadQuaterStore {
	private String str;
	public Store1(String str) {
	   this.str = str;
	}
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ 4,500¿ø ");
	}
    @Override
    public void budae() {
    	System.out.println("ºÎ´ëÂî°³ 5,000¿ø ");
    }
    @Override
	public void bibim() {
    	System.out.println("ºñºö¹ä 6,000¿ø ");
	}
    @Override
    public void sundae() {
    	System.out.println("¼ø´ñ±¹ ¾ÈÆÈ¾Æ");
    }
	@Override
	public void gongibab() {
		System.out.println("°ø±â¹ä 1,000¿ø");
	}
	public String getStr() {
		return str;
	}	
}
