package com.lec.TodayQuiz;
//아예 없으면 '가입한 회원이 없습니다' 값 출력해야 함.
import java.util.*;
public class TestMain02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String answer, name, phone, address;
		HashMap<String, Member> members = new HashMap<String, Member>();
		do {
			System.out.print("회원 가입 진행하시겠습니까 (Y/N)? ");
			answer = scanner.next();
			if(answer.equalsIgnoreCase("n")) {
				break;
			}else if(answer.equalsIgnoreCase("y")){ // 회원가입 진행
				System.out.print("이름은 ?");
				name = scanner.next();
				System.out.print("번호는 ?");
				phone = scanner.next();
				// 가입한 번호인지 확인하는 방법1
				if(members.get(phone) !=null) { 
					System.out.println("이미 가입되어 있는 번호입니다.");
					continue;
				}
				System.out.print("주소는 ?");
				scanner.nextLine(); //버퍼 지우는 용도
				address = scanner.nextLine();
				members.put(phone, new Member(name, phone, address));
			}
		}while(true);
		scanner.close();
		if(members.isEmpty()) {
			System.out.println("회원 없음");
		}else {
			System.out.println("가입 회원 목록");
			Iterator<String> iterator = members.keySet().iterator();
			while(iterator.hasNext()) {
				System.out.println(members.get(iterator.next()));
			}//while  
		}//if  
	}
}