package com.lec.ex01_store;
// ���� ��ħ         : ��ġ�-5,000  �δ��-6,000  �����-6,000 ���뱹-5,000  �����-1,000��
public abstract class HeadQuaterStore {
   private String str; // ����
   public HeadQuaterStore (String str) {this.str = str;}
   public abstract void kimchi( ); //method ������ ���� ���� �Ǿ��ִ� �޼ҵ� : �߻�޼ҵ� (��ӹ��� Ŭ�������� �������̵�.)
   public abstract void budae( );  //Ŭ���� �� �߻� �޼ҵ尡 �ϳ� �̻��� �� : �߻�Ŭ����
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
