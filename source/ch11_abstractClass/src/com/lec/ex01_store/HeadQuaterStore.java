package com.lec.ex01_store;
// 본사 지침         : 김치찌개-5,000  부대찌개-6,000  비빔밥-6,000 순대국-5,000  공기밥-1,000원
public abstract class HeadQuaterStore {
   private String str; // 본사
   public HeadQuaterStore (String str) {this.str = str;}
   public abstract void kimchi( ); //method 구현은 없고 선언만 되어있는 메소드 : 추상메소드 (상속받은 클래스에서 오버라이드.)
   public abstract void budae( );  //클래스 내 추상 메소드가 하나 이상일 때 : 추상클래스
   public abstract void bibim( );
   public abstract void sundae( );
   public abstract void gongibab( );
   public String getStr() {
	  return str;
   }
   public void setStr(String str) {
	  this.str = str;
   }
 
}
