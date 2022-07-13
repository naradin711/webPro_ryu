package com.lec.ch03.ex02;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OtherPerson {
	private String name;
	private int age;
	@PostConstruct
	public void initMethod() {
		System.out.println("OtherPerson 형 빈 생성하자마자 자동 호출 : initMethod()  ");
	}
	@PreDestroy
	public void deleteMethod() {
		System.out.println("OtherPerson 형 빈 소멸되기 전에 호출 : deleteMethod()  ");
	}
}
