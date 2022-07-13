package com.lec.ch03.ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		//컨테이너 생성 (환경설정)
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		// pathing
		ctx.load("classpath:/META-INF/ex02/applicationCTX3.xml");
		ctx.refresh();// 빈 생성
		System.out.println("-----------------------------------------");
		Person person = ctx.getBean("person", Person.class);
		System.out.println(person);
		OtherPerson otherperson = (OtherPerson)ctx.getBean("otherperson");
		System.out.println(otherperson);
		System.out.println("-----------------------------------------");
		ctx.close();
		System.out.println("빈 소멸");

	}

}
