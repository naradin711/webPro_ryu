package com.lec.Test02;
import java.util.*;
import java.io.*;
public class TestMain01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer, name, phone, address;
		ArrayList<Customer> cs = new ArrayList<Customer>();
		do {
			System.out.print("회원 가입하시겠습니까? (Y/N) : ");
			answer = sc.next();
			if(answer.equalsIgnoreCase("n")) break;
			System.out.print("이름을 입력하십시오 : ");
			name = sc.next();
			System.out.print("전화번호를 입력하십시오 : ");
			phone = sc.next();
			System.out.print("주소를 입력하십시오 : ");
			sc.nextLine(); // 앞에 입력 잔존값 리셋
			address = sc.nextLine();
			cs.add(new Customer(name, phone, address));
		}while(true);
		sc.close();
		OutputStream os = null;
		try {
			os = new FileOutputStream("src/com/lec/Test02/customer.txt", true);
	        for (Customer c : cs) {
	    	    System.out.println(c);	    	
				os.write(c.toString().getBytes());
	        }
			} catch (FileNotFoundException e) {			
			} catch (IOException e) {
				
			}finally{
				try {
					if(os!=null) os.close();
				} catch (Exception e2) {
					
				}
			}
	    }
	}















