package com.lec.ex3_account;

public class Account_test_main {
	public static void main(String[] args) {
		Account hong = new Account("100-1", "홍길동", 22000000000L); // 인스턴스 변수 = 객체를 가리키는 변수
		Account shin = new Account("101-1", "신길동");
		Account acc = new Account();
		acc.setAccountNo("101-2");
		acc.setOwnerName("유길동");
		System.out.println(hong.inforPrint());
		System.out.println(shin.inforPrint());
		System.out.println(acc.inforPrint());
		shin.deposit(2000);
		shin.withdraw(1200);
		shin.withdraw(20000);
		acc.withdraw(10);
		System.out.println(hong.inforPrint());
		System.out.println(shin.inforPrint());
		System.out.println(acc.inforPrint());
	}

}
