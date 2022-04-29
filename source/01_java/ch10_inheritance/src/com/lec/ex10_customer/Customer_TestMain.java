package com.lec.ex10_customer;

public class Customer_TestMain {
   public static void main(String[] args) {
	  Customer c1 = new Customer("서", "010-1111-1111", "인천", "1994-02-11");
	  c1.buy(100000);
	  c1.buy(900000);//누적됨.
	  System.out.println(c1.infoString());
	  Staff s1 = new Staff("미주", "010-9999-9999", "2019-03-16", "개발부서");
	  Person p1 = new Person("이", "010-7777-7777");
	  Person [] p1Arr = {c1, s1, p1};
	  for(int i=0; i<p1Arr.length; i++) { //일반 for문
		  System.out.println(p1Arr[i].infoString());
	  }
	  for (Person p : p1Arr) { //확장 for문
		  //배열 0~끝번호까지  infoString
		  System.out.println(p.infoString());
	  }
	  // buy(1000)
	  for(Person p : p1Arr) {
		  if(p instanceof Customer) { // p변수가 Customer형 객체(instance)인가?
		  ((Customer)p).buy(1000);  
		  }else {
		     System.out.println("buy는 Customer만 가능합니다.");
		  }//else	 
	  }//for
  }
}
