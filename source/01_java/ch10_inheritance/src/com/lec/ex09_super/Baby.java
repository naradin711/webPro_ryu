package com.lec.ex09_super;
// name, character / intro()
// Baby b = new Baby ("ȫ�ư�", "����")
// Baby b1 = new Baby();
public class Baby extends Person {
   public Baby( ) {
	   System.out.println("�Ű����� ���� Baby ������");
   }
   public Baby (String name, String character) {
       super(name, character); //�θ�Ŭ���� Person�� �Ű����� �ִ� ������ ����.
                               // this, super�� �޼ҵ� ���� �� ù��° �� ���� �켱 ����.
//	   setName(name); setCharacter(character);
	   System.out.println("�Ű����� �ִ� Baby ������");
   }
	public void intro() {
		System.out.print("�������� �� �ư���. " );
		super.intro(); // �� Ŭ������ �θ� Ŭ������ intro()�Լ� 
	}
}
