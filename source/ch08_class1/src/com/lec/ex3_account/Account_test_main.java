package com.lec.ex3_account;

public class Account_test_main {
	public static void main(String[] args) {
		Account hong = new Account("100-1", "ȫ�浿", 22000000000L); // �ν��Ͻ� ���� = ��ü�� ����Ű�� ����
		Account shin = new Account("101-1", "�ű浿");
		Account acc = new Account();
		acc.setAccountNo("101-2");
		acc.setOwnerName("���浿");
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
