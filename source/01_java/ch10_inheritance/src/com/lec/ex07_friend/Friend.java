package com.lec.ex07_friend;
// this. : �� ��ü�� �Ű������� ����.
// this () : �� Ŭ������ ������ �Լ�.
public class Friend {
   private String name;
   private String tel;// "010-9999-9999" Friend f = new Friend("ȫ�浿", "010-9999-9999")
   public Friend( ) {
	   System.out.println("�Ű����� ���� ������ �Լ�");
   }
   public Friend(String name ) { //
	   this(); // ���� ���� Ŭ������ �����ڸ� �ǹ���.
	   this.name = name;
	   System.out.println("�Ű����� �ִ� ������ �Լ�");
   }
   public Friend(String name, String tel ) {
	   this(name); // Friend(name)ȣ��
	   this.tel = tel;
	   System.out.println("�Ű����� �ΰ� ¥�� ������ �Լ�");
   }
   public String infoString() {
	   return "[�̸�]" + name +" : "+"[��ȭ]" + tel;
   }
}
