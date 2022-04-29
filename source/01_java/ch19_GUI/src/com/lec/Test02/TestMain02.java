package com.lec.Test02;
import java.util.*;
import java.io.*;
public class TestMain02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer, name, phone, address;
		HashMap<String, Customer> cs = new HashMap<String, Customer>();
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
			cs.put(phone, new Customer(name, phone, address));
		}while(true);
		sc.close();
		if(cs.isEmpty()) {
			System.out.println("입력하신 정보가 존재하지 않습니다.");
		} else {
			Iterator<String> iterator = cs.keySet().iterator();
			while(iterator.hasNext()) {
				System.out.println(cs.get(iterator.next()));
			}
		}
	}//main
}//class















