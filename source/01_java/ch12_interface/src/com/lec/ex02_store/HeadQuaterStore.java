package com.lec.ex02_store;
// HeadQuaterStore hsotre = new HeadQuaterStore("본사"); 객체 생성 불가.
public interface HeadQuaterStore {
   public void kimchi( ); //method 구현은 없고 선언만 되어있는 메소드 : 추상메소드 (상속받은 클래스에서 오버라이드.)
   public void budae( );  //클래스 내 추상 메소드가 하나 이상일 때 : 추상클래스
   public void bibim( );
   public void sundae( );
   public void gongibab( );
   public String getStr();
}
