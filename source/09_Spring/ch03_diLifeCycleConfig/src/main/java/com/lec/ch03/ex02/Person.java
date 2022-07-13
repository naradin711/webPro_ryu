package com.lec.ch03.ex02;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person implements InitializingBean, DisposableBean, EnvironmentAware{
	private String name;
	private String tel;

	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("Person 형 빈 객체 생성하자 마자 실행 : setEnvironment 호출 " + environment);
		
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Person 형 빈 객체 생성 후 실행 : afterPropertiesSet() 호출 ");
		
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("Person 형 빈 소멸 바로 전 실행 : destroy() 호출 ");
		
	}
}
