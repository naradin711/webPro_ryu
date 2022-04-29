package com.lec.ex04_object;
//♠◆♣♥ 모양에 1-13숫자
public class Card {
   private char kind;
   private int num; //1~13
   public Card(char kind, int num) {
	this.kind = kind;
	this.num = num;
  }
@Override
public String toString() {
	return "카드는" + kind + num ;
  }
  // c1.equal(c2) => c1의 카인드와 c2의 카인드, c1의 넘버와 c2의 넘버를 비교
  public boolean equals(Object obj) {
	  // c1.equals(c2) => c1은 내객체, c2는 obj
	  if(obj !=null && obj instanceof Card) {// obj가 Person 타입의 객체
		  boolean kindCk= (kind == ((Card)obj).kind);
		  boolean numCk= (num == ((Card)obj).num);
		  return kindCk && numCk;
	  }else {
		  return false;
	  }
  }
}
