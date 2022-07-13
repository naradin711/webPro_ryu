package com.lec.ch05.ex01;

import lombok.Data;

@Data
public class Worker {
		private String name;
		private int age;
		private String job; 
		public void getWorkerInfo() { // 호출될 핵심기능 (티켓 메소드 = 비즈니스 로직)
			System.out.println("이름 : " + name);
			System.out.println("나이 : " + age);
			System.out.println("직업 : " + job); 
		}

}
