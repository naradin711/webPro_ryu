package com.lec.ch04.ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AdminInfoTestMain {

	public static void main(String[] args) {
		String location = "classpath:META-INF/ex02/applicationCTX.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(location);
		AdminInfo info = ctx.getBean("adminInfo", AdminInfo.class);
		System.out.println(info);

	}

}
