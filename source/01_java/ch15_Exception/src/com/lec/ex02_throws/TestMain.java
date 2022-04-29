package com.lec.ex02_throws;

public class TestMain {
		public static void main(String[] args) {
			try {
				new ThrowsEx();
			} catch (Exception e) {
				System.out.println("없는 번호 입니다.");
			}
			System.out.println("완료");
		}
	}

