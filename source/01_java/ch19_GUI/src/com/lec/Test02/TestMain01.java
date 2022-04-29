package com.lec.Test02;
import java.util.*;
import java.io.*;
public class TestMain01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer, name, phone, address;
		ArrayList<Customer> cs = new ArrayList<Customer>();
		do {
			System.out.print("ȸ�� �����Ͻðڽ��ϱ�? (Y/N) : ");
			answer = sc.next();
			if(answer.equalsIgnoreCase("n")) break;
			System.out.print("�̸��� �Է��Ͻʽÿ� : ");
			name = sc.next();
			System.out.print("��ȭ��ȣ�� �Է��Ͻʽÿ� : ");
			phone = sc.next();
			System.out.print("�ּҸ� �Է��Ͻʽÿ� : ");
			sc.nextLine(); // �տ� �Է� ������ ����
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















