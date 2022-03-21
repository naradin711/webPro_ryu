package com.lec.ex09_super;
// name, character / intro()
// Baby b = new Baby ("홍아가", "예뻐")
// Baby b1 = new Baby();
public class Baby extends Person {
   public Baby( ) {
	   System.out.println("매개변수 없는 Baby 생성자");
   }
   public Baby (String name, String character) {
       super(name, character); //부모클래스 Person의 매개변수 있는 생성자 실행.
                               // this, super는 메소드 항의 맨 첫번째 줄 부터 우선 실행.
//	   setName(name); setCharacter(character);
	   System.out.println("매개변수 있는 Baby 생성자");
   }
	public void intro() {
		System.out.print("응애응애 난 아가야. " );
		super.intro(); // 내 클래스의 부모 클래스의 intro()함수 
	}
}
