package com.lec.ex01_string;
// String ���� (10����) > StringBuffer ���� 10���� > StringBuilder ���� 10����
public class Ex11_SpeedCheck {
   public static void main(String[] args) {
	  System.out.println(System.currentTimeMillis());//1970�� 1�� 1�� ���� ���ݱ����� �и�������
       // ��Ʈ�� ���� 10���� - �ð� üũ
	   String str = "A";
	   long startTime = System.currentTimeMillis(); // ���� ���� ����.
	   for (int i=0 ; i<100000 ; i++) { //10���� ����
		   str = str +"a";
	   }
	   long endTime = System.currentTimeMillis();
	   System.out.println("String 10���� ��������ð� : "+(endTime-startTime));
	   // StringBuffer ���� 10���� �ð�üũ
	   StringBuffer stBuf = new StringBuffer("A") ;
	   startTime = System.currentTimeMillis();
	   for (int i=0 ; i<100000 ; i++) { //10���� ����
		   stBuf.append("a");
	   }
	   endTime = System.currentTimeMillis();
	   System.out.println("StringBuffer 10���� ��������ð� : "+(endTime-startTime));
	   // StringBuilder ���� 10���� �ð�üũ
	   
	   StringBuilder stBud = new StringBuilder("A");
	   startTime = System.currentTimeMillis();
	   for (int i=0 ; i<100000 ; i++) { //10���� ����
		   stBud.append("a");
	   }
	   endTime = System.currentTimeMillis();
	   System.out.println("StringBuilder 10���� ��������ð� : "+(endTime-startTime));
	  
	   
   }
}
