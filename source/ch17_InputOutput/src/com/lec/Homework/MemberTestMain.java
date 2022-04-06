package com.lec.Homework;
import java.util.*;
import java.io.*;
public class MemberTestMain {
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
	   if(mm.isEmpty()) {
		   System.out.println("가입한 회원이 없습니다."); 
	   } else {
		   OutputStream     os = null;
	       System.out.println("가입한 회원 리스트");
		   for (Member m : mm) {
			   try {
				os = new FileOutputStream("D:\\webPro_ryu\\source\\ch17_InputOutput\\src\\com\\lec\\Homework\\Member.txt", true);
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
			   System.out.println(m);
			   String str1 = m.getName() +"  "+ m.getPhone() + "  "+ m.getbDay()+"생  "+m.getAddress()+"\n";
			   byte [] bs1 = str1.getBytes();
			   try {
				os.write(bs1);
			} catch (IOException e) {
			}
			     if(m.getbDay().equals("04-06")) {
				  System.out.println("회원님의 생일을 축하드립니다.");
				  String str2 = "\n회원님의 생일을 축하드립니다.";
				  byte [] bs2 = str2.getBytes();
				   try {
					os.write(bs2);
				} catch (IOException e) {
				}
			   }
		   }//for
		   System.out.println("이하 "+mm.size()+"명의 회원이 가입하였습니다.");
		   String str3 = "\n이하 "+mm.size()+"명의 회원이 가입하였습니다.";
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

