package com.lec.Homework;
import java.util.*;
import java.io.*;
public class MemberTestMain_PrintWriter {
	public static void main(String[] args) {
       ArrayList<Member> mm = new ArrayList<Member>();
       Scanner sc = new Scanner(System.in);
       String answer, name, phone, bDay, address;
       while(true) {
    	   System.out.print("ȸ�� ������ �����Ͻðڽ��ϱ�? y/n ");
    	   answer = sc.next();
    	   if (answer.equalsIgnoreCase("n")) {
    		   break;
    	   }else if(answer.equalsIgnoreCase("y")) {
    		   System.out.print("�̸��� �Է��ϼ���. : ");
    		   name = sc.next();
    		   System.out.print("��ȭ��ȣ�� �Է��ϼ���. : ");
    		   phone = sc.next();
    		   System.out.print("������ �Է��ϼ���. : ");
    		   bDay = sc.next();
    		   System.out.print("�ּҸ� �Է��ϼ���. : ");
    		   sc.nextLine();
    		   address = sc.nextLine();
    		   mm.add(new Member(name, phone, bDay, address));
    	   } //if
        }//while
       sc.close();
       PrintWriter prWriter = null;
	   if(mm.isEmpty()) {
		   System.out.println("������ ȸ���� �����ϴ�."); 
	   } else { 
	       System.out.println("������ ȸ�� ����Ʈ");
		   for (Member m : mm) {
			   try {
				   prWriter = new PrintWriter("D:\\webPro_ryu\\source\\ch17_InputOutput\\src\\com\\lec\\Homework\\Member_PrintWriter.txt");
			
			   System.out.println(m);
			   prWriter.println(m.getName() +"  "+ m.getPhone() + "  "+ m.getbDay()+"��  "+m.getAddress()); 
			     if(m.getbDay().equals("04-06")) {
				  System.out.println("ȸ������ ������ ���ϵ帳�ϴ�.");
				  prWriter.println(m.getName()+"ȸ������ ������ ���ϵ帳�ϴ�.");		  
			
			     
		   }//for
		   System.out.println("���� "+mm.size()+"���� ȸ���� �����Ͽ����ϴ�.");
		   prWriter.println("���� "+mm.size()+"���� ȸ���� �����Ͽ����ϴ�.");
	     } catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		 }finally {
			if (prWriter!=null) prWriter.close();
		 }
	    }//for
      }//if else
	}// main
}// class

