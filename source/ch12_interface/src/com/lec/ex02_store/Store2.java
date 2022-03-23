package com.lec.ex02_store;
// ºÎ´ëÂî°³-5,000  ºñºö¹ä-5,000  °ø±â¹ä-¹«·á
public class Store2 implements HeadQuaterStore {
	private String str;
	public Store2(String str) {
	   this.str = str;
	}
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ 5,000¿ø ");
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
	public void sundae() {
    	System.out.println("¼ø´ë±¹ 5,000¿ø ");
	}
    @Override
    public void gongibab() {
    	System.out.println("°ø±â¹äÀº ¹«·á!");
    }
    public String getStr() {
		return str;
	}
	
	
}
