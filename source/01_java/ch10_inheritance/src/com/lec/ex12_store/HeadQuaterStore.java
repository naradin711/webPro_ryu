package com.lec.ex12_store;
// ���� ��ħ         : ��ġ�-5,000  �δ��-6,000  �����-6,000 ���뱹-5,000  �����-1,000��
public class HeadQuaterStore {
   private String str; // ����
   public HeadQuaterStore (String str) {this.str = str;}
   public void kimchi( ) {
	   System.out.println("��ġ� 5,000�� ");
   }
   public void budae( ) {
	   System.out.println("�δ�� 6,000�� ");
   }
   public void bibim( ) {
	   System.out.println("����� 6,000�� ");
   }
   public void sundae( ) {
	   System.out.println("���� 5,000�� ");
   }
   public void gongibab( ) {
	   System.out.println("����� 1,000�� ");
   }
   public String getStr() {
	  return str;
   }
   public void setStr(String str) {
	  this.str = str;
   }
 
}
