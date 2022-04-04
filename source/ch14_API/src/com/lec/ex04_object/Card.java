package com.lec.ex04_object;
//���ߢ��� ��翡 1-13����
public class Card {
   private char kind;
   private int num; //1~13
   public Card(char kind, int num) {
	this.kind = kind;
	this.num = num;
  }
@Override
public String toString() {
	return "ī���" + kind + num ;
  }
  // c1.equal(c2) => c1�� ī�ε�� c2�� ī�ε�, c1�� �ѹ��� c2�� �ѹ��� ��
  public boolean equals(Object obj) {
	  // c1.equals(c2) => c1�� ����ü, c2�� obj
	  if(obj !=null && obj instanceof Card) {// obj�� Person Ÿ���� ��ü
		  boolean kindCk= (kind == ((Card)obj).kind);
		  boolean numCk= (num == ((Card)obj).num);
		  return kindCk && numCk;
	  }else {
		  return false;
	  }
  }
}
