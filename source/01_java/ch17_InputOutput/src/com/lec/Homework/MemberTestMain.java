package com.lec.Homework;
import java.util.*;
import java.io.*;
public class MemberTestMain {
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
		   OutputStream     os = null;
	       System.out.println("������ ȸ�� ����Ʈ");
		   for (Member m : mm) {
			   try {
				os = new FileOutputStream("D:\\webPro_ryu\\source\\ch17_InputOutput\\src\\com\\lec\\Homework\\Member.txt", true);
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
			   System.out.println(m);
			   String str1 = m.getName() +"  "+ m.getPhone() + "  "+ m.getbDay()+"��  "+m.getAddress()+"\n";
			   byte [] bs1 = str1.getBytes();
			   try {
				os.write(bs1);
			} catch (IOException e) {
			}
			     if(m.getbDay().equals("04-06")) {
				  System.out.println("ȸ������ ������ ���ϵ帳�ϴ�.");
				  String str2 = "\nȸ������ ������ ���ϵ帳�ϴ�.";
				  byte [] bs2 = str2.getBytes();
				   try {
					os.write(bs2);
				} catch (IOException e) {
				}
			   }
		   }//for
		   System.out.println("���� "+mm.size()+"���� ȸ���� �����Ͽ����ϴ�.");
		   String str3 = "\n���� "+mm.size()+"���� ȸ���� �����Ͽ����ϴ�.";
		   byte [] bs3 = str3.getBytes();
			try {
				os.write(bs3);
			} catch (IOException e) {
			} finally {
				try {
					if (os!=null) os.close();
				} catch (Exception e2) {
				
				}
			}
      }//if else
	}// main
}// class

