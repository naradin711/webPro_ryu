package com.lec.ex10_customer;
// name, tel. address, sum, point, date, vip
// Customer c = new Customer ("홍", "010", "인천", "1994-02-11")
public class Customer extends Person {
   private String address;
   private int    sum; // 구매 누적금액
   private int    point; // 포인트 (구매마다 5% 적립)
   private String date; // 기념일 (Date 타입 매개변수로 바꿀 예정)
   private boolean vip; // true면 vip, false면 일반.
   public Customer(String name, String tel, String address, String date) {
	  super(name, tel); //부모 클래스에서 매개변수 name, tel 상속받음.
	  this.address = address;
	  this.date = date;
	  point = 1000; // 신규 고객에게는 1000 포인트 자동 부여.
	  System.out.println(name+"님 감사합니다. 포인트 1000점을 선물로 드립니다.");
   }
   public void buy (int price) { // c.buy(10000)
	  sum += price;
	  int tempPoint = (int)(price*0.05);
	  point += tempPoint;
	  System.out.println(getName()+"님 감사드립니다. 이번 구매 포인트 "+tempPoint+"점 추가되어 총 포인트 : "+point);
	  if(sum>=1000000 && vip == false) {
		 vip = true; // 구매누적금액이 100만원 이상시 vip 고객으로
         System.out.println(getName() + "님께서는 VIP 고객으로 업그레이드 되셨습니다.");
	  }//if
   }//by
    //1. c.print() vs. sysout(c.infoString) vs. sysout(c)
    // super.inforstring = "[이름] : "+name+" [전화] : "+tel;
   public String infoString( ) {
	  return super.infoString() + " [주소] : "+address+" [포인트] : "+point+" [누적금액] : "+sum+"원";
   }
   public String getAddress() {
	  return address;
   }
   public void setAddress(String address) {
	  this.address = address;
   }
   public int getSum() {
	  return sum;
   }
   public void setSum(int sum) {
	  this.sum = sum;
   }
   public int getPoint() {
	  return point;
   }
   public void setPoint(int point) {
	  this.point = point;
   }
   public String getDate() {
	  return date;
   }
   public void setDate(String date) {
	  this.date = date;
   }
   public boolean isVip() {
	  return vip;
   }
   public void setVip(boolean vip) {
	  this.vip = vip;
   }   
}
