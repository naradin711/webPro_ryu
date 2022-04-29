package com.lec.Homework;
import java.util.*;
import java.io.*;
public class MemberTestMain_PrintWriter {
	public static void main(String[] args) {
       ArrayList<Member> mm = new ArrayList<Member>();
       Scanner sc = new Scanner(System.in);
       String answer, name, phone, bDay, address;
       while(true) {
    	   System.out.print("회원 가입을 진행하시겠습니까? y/n ");
    	   answer = sc.next();
    	   if (answer.equalsIgnoreCase("n")) {
    		   break;
    	   }else if(answer.equalsIgnoreCase("y")) {
    		   System.out.print("이름을 입력하세요. : ");
    		   name = sc.next();
    		   System.out.print("전화번호를 입력하세요. : ");
    		   phone = sc.next();
    		   System.out.print("생일을 입력하세요. : ");
    		   bDay = sc.next();
    		   System.out.print("주소를 입력하세요. : ");
    		   sc.nextLine();
    		   address = sc.nextLine();
    		   mm.add(new Member(name, phone, bDay, address));
    	   } //if
        }//while
       sc.close();
       PrintWriter prWriter = null;
	   if(mm.isEmpty()) {
		   System.out.println("가입한 회원이 없습니다."); 
	   } else { 
	       System.out.println("가입한 회원 리스트");
		   for (Member m : mm) {
			   try {
				   prWriter = new PrintWriter("D:\\webPro_ryu\\source\\ch17_InputOutput\\src\\com\\lec\\Homework\\Member_PrintWriter.txt");
			
			   System.out.println(m);
			   prWriter.println(m.getName() +"  "+ m.getPhone() + "  "+ m.getbDay()+"생  "+m.getAddress()); 
			     if(m.getbDay().equals("04-06")) {
				  System.out.println("회원님의 생일을 축하드립니다.");
				  prWriter.println(m.getName()+"회원님의 생일을 축하드립니다.");		  
			
			     
		   }//for
		   System.out.println("이하 "+mm.size()+"명의 회원이 가입하였습니다.");
		   prWriter.println("이하 "+mm.size()+"명의 회원이 가입하였습니다.");
	     } catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		 }finally {
			if (prWriter!=null) prWriter.close();
		 }
	    }//for
      }//if else
	}// main
}// class

