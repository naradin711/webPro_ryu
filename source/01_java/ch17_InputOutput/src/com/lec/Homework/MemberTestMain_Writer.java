package com.lec.Homework;
import java.util.*;
import java.io.*;
public class MemberTestMain_Writer {
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
	   if(mm.isEmpty()) {
		   System.out.println("������ ȸ���� �����ϴ�."); 
	   } else {
		   Writer writer = null;
		   try {
			writer = new FileWriter("D:\\webPro_ryu\\source\\ch17_InputOutput\\src\\com\\lec\\Homework\\Member_writer.txt",true);
		} catch (IOException e) {}
	       System.out.println("������ ȸ�� ����Ʈ");
		   for (Member m : mm) {
			   System.out.println(m);
			   String s1 = m.getName()+ "  "+m.getPhone()+"  "+m.getbDay()+"��  "+m.getAddress()+"\n";
			   try {
				writer.write(s1);
			} catch (IOException e) {}
			     if(m.getbDay().equals("04-06")) {
				  System.out.println("ȸ������ ������ ���ϵ帳�ϴ�.");
				  String s2 ="\n  "+ m.getName()+ "ȸ������ ������ ���ϵ帳�ϴ�.";
				  try {
					writer.write(s2);
				} catch (IOException e) {}
			     }
		   }//for
		   System.out.println("\n���� "+mm.size()+"���� ȸ���� �����Ͽ����ϴ�.");
		   String s3 ="\n���� "+mm.size()+"���� ȸ���� �����Ͽ����ϴ�.";
		   try {
			writer.write(s3);
		} catch (IOException e) {
	    } finally {
			try {
				 if(writer!=null) writer.close();
			} catch (Exception e2) {}
		}
      }//if else
	}// main
}// class

