package com.lec.quiz01;

import java.util.Scanner;

public class Friend_TestMain {
	public static void main(String[] args) {
		Friend [] friends = { new Friend ("������", "010-1122-0211", "02-11"),
				              new Friend ("������", "010-1122-0211", "02-16"),
				              new Friend ("������", "010-9876-0256", "03-27"),
				              new Friend ("������", "010-3242-1119", "11-19"),};
        Scanner sc = new Scanner(System.in);  
        while(true) {
        System.out.print("�˻��ϰ��� �ϴ� ģ���� ��ȭ��ȣ ���ڸ���? ");
        String sPhone = sc.next();
        if(sPhone.equals("x")) break;
        boolean sOk=false;
        for(int idx = 0; idx<friends.length ; idx++) {
        	String ph = friends[idx].getPhone();
        	String post = ph.substring(ph.lastIndexOf('-')+1);
        	if(post.equals(sPhone)) {
        		System.out.println(friends[idx]);
        		sOk=true;
        	}// if
        }//for
        if(! sOk) {
        	System.out.println("�˻��Ͻ� ģ���� ��ȸ���� �ʽ��ϴ�.");
        }//if
      }//while
        sc.close();
  }
}
