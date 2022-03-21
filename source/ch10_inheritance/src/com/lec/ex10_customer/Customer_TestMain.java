package com.lec.ex10_customer;

public class Customer_TestMain {
   public static void main(String[] args) {
	  Customer c1 = new Customer("��", "010-1111-1111", "��õ", "1994-02-11");
	  c1.buy(100000);
	  c1.buy(900000);//������.
	  System.out.println(c1.infoString());
	  Staff s1 = new Staff("����", "010-9999-9999", "2019-03-16", "���ߺμ�");
	  Person p1 = new Person("��", "010-7777-7777");
	  Person [] p1Arr = {c1, s1, p1};
	  for(int i=0; i<p1Arr.length; i++) { //�Ϲ� for��
		  System.out.println(p1Arr[i].infoString());
	  }
	  for (Person p : p1Arr) { //Ȯ�� for��
		  //�迭 0~����ȣ����  infoString
		  System.out.println(p.infoString());
	  }
	  // buy(1000)
	  for(Person p : p1Arr) {
		  if(p instanceof Customer) { // p������ Customer�� ��ü(instance)�ΰ�?
		  ((Customer)p).buy(1000);  
		  }else {
		     System.out.println("buy�� Customer�� �����մϴ�.");
		  }//else	 
	  }//for
  }
}
