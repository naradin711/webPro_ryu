package com.lec.quiz01;

import java.util.Scanner;

public class Friend_TestMain {
	public static void main(String[] args) {
		Friend [] friends = { new Friend ("서지수", "010-1122-0211", "02-11"),
				              new Friend ("서지안", "010-1122-0211", "02-16"),
				              new Friend ("임지혜", "010-9876-0256", "03-27"),
				              new Friend ("류수정", "010-3242-1119", "11-19"),};
        Scanner sc = new Scanner(System.in);  
        while(true) {
        System.out.print("검색하고자 하는 친구의 전화번호 뒷자리는? ");
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
        	System.out.println("검색하신 친구는 조회되지 않습니다.");
        }//if
      }//while
        sc.close();
  }
}
