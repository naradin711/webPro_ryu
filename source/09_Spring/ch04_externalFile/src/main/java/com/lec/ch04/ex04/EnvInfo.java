package com.lec.ch04.ex04;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import lombok.Data;

@Data
public class EnvInfo {
	private String ipNum;
	private String portNum;
	private String userId;
	private String pw;
}
