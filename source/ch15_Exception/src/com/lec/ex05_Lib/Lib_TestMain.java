package com.lec.ex05_Lib;

import java.util.Date;

public class Lib_TestMain {
	public static void main(String[] args) { //���ο����� throw�Լ� ���� �ʴ´�!
		BookLib bk1 = new BookLib("89a-21", "java", "�ڹ�Ĩ");
		BookLib bk2 = new BookLib("90a-73", "DBMS", "�δܺ�");
	   
	    System.out.println(bk1);
	    try {
			bk1.checkOut("�����");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	    // ������ ����
	    bk1.setcDate(new Date(122,2,11));
	    System.out.println(bk1);
	    try {
			bk1.checkIn();
		} catch (Exception e) {
		    System.out.println("���� �޽��� :" +e.getMessage());
		}
	    System.out.println(bk1);
	}

}
