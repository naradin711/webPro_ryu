package com.lec.ch04.ex01;

import java.io.IOException;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class AdminTestMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); // 컨테이너 생성
		ConfigurableEnvironment env =  ctx.getEnvironment();// 환경변수 가지고 옴 
		MutablePropertySources propertySources = env.getPropertySources(); // env의 속성값 가져오기
		try {
			String location = "classpath:META-INF/ex01/admin.properties";
			propertySources.addLast(new ResourcePropertySource(location));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("admin.id = " + env.getProperty("admin.id"));
		System.out.println("admin.pw = " + env.getProperty("admin.pw"));
		// env에서 외부 설정파일 속성들을 추가한 후 빈 생성
		ctx.load("classpath:META-INF/ex01/adminCTX.xml");
		ctx.refresh();
		Admin admin = ctx.getBean("admin", Admin.class);
		System.out.println(admin);
		System.out.println("adminId : " + admin.getAdminId());
		System.out.println("adminPw : " + admin.getAdminPw());
		ctx.close();

	}

}
