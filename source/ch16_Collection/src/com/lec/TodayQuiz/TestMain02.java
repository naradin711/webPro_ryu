package com.lec.TodayQuiz;
//�ƿ� ������ '������ ȸ���� �����ϴ�' �� ����ؾ� ��.
import java.util.*;
public class TestMain02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String answer, name, phone, address;
		HashMap<String, Member> members = new HashMap<String, Member>();
		do {
			System.out.print("ȸ�� ���� �����Ͻðڽ��ϱ� (Y/N)? ");
			answer = scanner.next();
			if(answer.equalsIgnoreCase("n")) {
				break;
			}else if(answer.equalsIgnoreCase("y")){ // ȸ������ ����
				System.out.print("�̸��� ?");
				name = scanner.next();
				System.out.print("��ȣ�� ?");
				phone = scanner.next();
				// ������ ��ȣ���� Ȯ���ϴ� ���1
				if(members.get(phone) !=null) { 
					System.out.println("�̹� ���ԵǾ� �ִ� ��ȣ�Դϴ�.");
					continue;
				}
				System.out.print("�ּҴ� ?");
				scanner.nextLine(); //���� ����� �뵵
				address = scanner.nextLine();
				members.put(phone, new Member(name, phone, address));
			}
		}while(true);
		scanner.close();
		if(members.isEmpty()) {
			System.out.println("ȸ�� ����");
		}else {
			System.out.println("���� ȸ�� ���");
			Iterator<String> iterator = members.keySet().iterator();
			while(iterator.hasNext()) {
				System.out.println(members.get(iterator.next()));
			}//while  
		}//if  
	}
}