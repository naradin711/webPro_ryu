package com.lec.TodayQuiz;
import java.util.*;

import com.lec.ex02_Map.Friend;
//아예 없으면 '가입한 회원이 없습니다' 값 출력해야 함.
public class TestMain01 {
   public static void main(String[] args) {
	   ArrayList<Member> members = new ArrayList<Member>();
	   Scanner sc = new Scanner(System.in);
	   String answer, name, pNo, address;
	   while(true) {System.out.print("회원 가입을 진행하시겠습니까? (Y/N) : ");
	       answer = sc.next();
	       if(answer.equalsIgnoreCase("n")) {
	    	   break;  
	       }else if(answer.equalsIgnoreCase("y")) {
	       	   System.out.print("이름을 입력하시오. ");
	       	   name = (sc.next());
	       	   System.out.print("전화번호를 입력하시오. ");
	       	   pNo = (sc.next());
	       	   System.out.print("주소를 입력하시오. ");
	       	   sc.nextLine();//리셋 ㅋㅋ
	       	   address = (sc.nextLine());
	       	   members.add(new Member(name, pNo, address));
	       	  
	        } 
	   } 
	   sc.close();
	   if(members.isEmpty()) {
		   System.out.println("가입한 회원이 없습니다.");
	   }else {
		   System.out.println("가입한 회원 리스트");
		   for (Member m : members) {
			   System.out.println(m);
		   }
	   }
	   
    }  
}  


