package com.lec.Test02;
import java.util.*;
import java.io.*;
public class TestMain02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer, name, phone, address;
		HashMap<String, Customer> cs = new HashMap<String, Customer>();
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
			cs.put(phone, new Customer(name, phone, address));
		}while(true);
		sc.close();
		if(cs.isEmpty()) {
			System.out.println("�Է��Ͻ� ������ �������� �ʽ��ϴ�.");
		} else {
			Iterator<String> iterator = cs.keySet().iterator();
			while(iterator.hasNext()) {
				System.out.println(cs.get(iterator.next()));
			}
		}
	}//main
}//class















