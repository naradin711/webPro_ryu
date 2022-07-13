package com.lec.ch04.ex04;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext; 

public class Main {
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
		ctx.load("classpath:META-INF/ex04/dev.xml", "classpath:META-INF/ex04/run.xml");
		ctx.refresh();
		EnvInfo info = ctx.getBean("envInfo", EnvInfo.class);
		System.out.println("ipNum = " + info.getIpNum());
		System.out.println("portNum = " + info.getPortNum());
		System.out.println("userId = " + info.getUserId());
		System.out.println("pw = " + info.getPw());
		ctx.close();
	}
	
}
