package com.lec.ch04.ex03;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProfileTest {

	public static void main(String[] args) {
		String config = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("dev? run? = ");
		String answer = sc.next();
		if(answer.equalsIgnoreCase("dev")) {
			config = "dev";
		} else if (answer.equalsIgnoreCase("run")) {
			config = "run";
		} else {
			System.out.println("제대로 된 환경이 입력되지 않았습니다.");
			System.exit(0); // 끝냄
		}
		sc.close();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load("classpath:META-INF/ex03/CTX_dev.xml", "classpath:META-INF/ex03/CTX_run.xml");
		ctx.refresh();
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("IP : " + info.getIpNum());
		System.out.println("포트 : " + info.getPortNum());
		ctx.close();

	}

}
