package com.lec.TodayQuiz;
import java.util.*;

import com.lec.ex02_Map.Friend;
//�ƿ� ������ '������ ȸ���� �����ϴ�' �� ����ؾ� ��.
public class TestMain01 {
   public static void main(String[] args) {
	   ArrayList<Member> members = new ArrayList<Member>();
	   Scanner sc = new Scanner(System.in);
	   String answer, name, pNo, address;
	   while(true) {System.out.print("ȸ�� ������ �����Ͻðڽ��ϱ�? (Y/N) : ");
	       answer = sc.next();
	       if(answer.equalsIgnoreCase("n")) {
	    	   break;  
	       }else if(answer.equalsIgnoreCase("y")) {
	       	   System.out.print("�̸��� �Է��Ͻÿ�. ");
	       	   name = (sc.next());
	       	   System.out.print("��ȭ��ȣ�� �Է��Ͻÿ�. ");
	       	   pNo = (sc.next());
	       	   System.out.print("�ּҸ� �Է��Ͻÿ�. ");
	       	   sc.nextLine();//���� ����
	       	   address = (sc.nextLine());
	       	   members.add(new Member(name, pNo, address));
	       	  
	        } 
	   } 
	   sc.close();
	   if(members.isEmpty()) {
		   System.out.println("������ ȸ���� �����ϴ�.");
	   }else {
		   System.out.println("������ ȸ�� ����Ʈ");
		   for (Member m : members) {
			   System.out.println(m);
		   }
	   }
	   
    }  
}  


