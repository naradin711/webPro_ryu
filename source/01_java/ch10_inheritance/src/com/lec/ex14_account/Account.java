package com.lec.ex14_account;
//������(�Ӽ�) : ���¹�ȣ(accountNo:String), 
//             ������(ownerName:String), 
//             �ܾ�(balance:int)
//���(�޼ҵ�) : �����ϴ�(void deposit(int)). 
//            �����ϴ�(int withdraw(int)), 
//            �ܾ���ȸ(long getBalance())
// Account a = New Account("100-1", "ȫ�浿"); / Account("100-2", "�ű浿", 2200000000000);
public class Account {
   private String accountNo ;
   private String ownerName ;
   private long balance;
// ��������� ������ ����
   public Account() {} // default ������. �Ű����� ���� �ƹ� �ϵ� ���ϴ� ������.
   public Account(String accountNo, String ownerName ) { // ������ ���� : ������ �ʱ�ȭ.
	 this.accountNo =   accountNo;
	 this.ownerName = ownerName;
	 System.out.printf("%s(%s)�� ���� ���� �����մϴ�. ���� �� �Ȱ��� ���̳���? \n", ownerName,accountNo);
   }
   public Account(String accountNo, String ownerName, long balance ) { // ������ ���� : ������ �ʱ�ȭ.
		 this.accountNo =   accountNo;
		 this.ownerName = ownerName;
		 this.balance = balance;
		 System.out.printf("%s(%s)�� ���� ���� �����մϴ�. ���� ������ ���� �ܾ��� %d ���Դϴ�. \n", ownerName,accountNo,balance);
	   }
   //���� �Ʒ����� �޼ҵ� ����
   //�����ϴ�(void deposit(int)), �����ϴ�(int withdraw(int)), 
   // �ܾ���ȸ(long getBalance())
   public void deposit(int money) { // ������ ������
	   if(money>=0) {
		   balance += money ;
		   System.out.printf("%s(%s)�� %d�� �ԱݿϷ��߽��ϴ�. ���� �ܾ� : %d\n",ownerName, accountNo, money, balance);
	   } else {
		   System.out.println("�߸��� �Է��Դϴ�. ");
	   }
   }
   public void withdraw(int money) {
	   if(money<=balance) {
		   balance -= money ; 
		   System.out.println(ownerName + "�� �� ���¿��� " +money+ "���� ����Ǿ����ϴ�.\n" + ownerName + "�� ������ �ܾ��� " + balance +  "�� �Դϴ�.");
	   } else {
		   System.out.println(ownerName + "�� �ܾ��� �����մϴ�. ");
	   }
   }
   public String inforPrint() {
	   return String.format("%s(%s)���� �ܾ� : %d �� �Դϴ�. \n", ownerName, accountNo, balance);
	//   return ownerName + "("+ accountNo +")"+"���� �ܾ� : " + balance + "�� �Դϴ�.";
   }
    // setter & getter
   public String getAccountNo() {
	  return accountNo;
   }
   public void setAccountNo(String accountNo) {
	  this.accountNo = accountNo;
   }
   public String getOwnerName() {
	  return ownerName;
   }
   public void setOwnerName(String ownerName) {
	  this.ownerName = ownerName;
   }
   public long getBalance() {
	  return balance;
   }
   public void setBalance(long balance) {
	  this.balance = balance;
   }
// source���� �ڵ����� setter�� getter�� ������ �� �ִ�.   
//   public void setAccountNo(String accountNo) {
//	   this.accountNo = accountNo;
//   }
//   public String setAccountNo() {
//	   return accountNo;
//   }
} 
