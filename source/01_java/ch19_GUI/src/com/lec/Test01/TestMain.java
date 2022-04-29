package com.lec.Test01;
import java.util.*;
public class TestMain {
	public static void main(String[] args) {
		Friend [] friends = {new Friend ("홍길동", "서울시 용산구", "010-9999-1234", "05-22"),
				              new Friend ("꽃길동", "서울시 마포구", "010-1111-1234", "06-23")
				              };
        Scanner sc = new Scanner(System.in);
        while(true) {
        	System.out.print("검색할 주소 앞 글자 2자리 (단,종료를 원하시면 x를 입력하시오) : ");
        	String answer = sc.next();
        	if(answer.equalsIgnoreCase("x"))break;
        	boolean Ok=false;
        	for(int idx=0; idx<friends.length ; idx++) {
        		String add = friends[idx].getAddress();
        		String first = add.substring (0,2);
        	    if(first.equals(answer)) {
        	    	System.out.println(friends[idx]);
        	    	Ok=true;
        	    }
        	}
        	 if(! Ok) {
             	System.out.println("해당 주소의 친구는 없습니다.");
             }
        }
        sc.close();
	}

}
