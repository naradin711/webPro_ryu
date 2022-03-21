package com.lec.ex10_customer;
// name, tel. address, sum, point, date, vip
// Customer c = new Customer ("ȫ", "010", "��õ", "1994-02-11")
public class Customer extends Person {
   private String address;
   private int    sum; // ���� �����ݾ�
   private int    point; // ����Ʈ (���Ÿ��� 5% ����)
   private String date; // ����� (Date Ÿ�� �Ű������� �ٲ� ����)
   private boolean vip; // true�� vip, false�� �Ϲ�.
   public Customer(String name, String tel, String address, String date) {
	  super(name, tel); //�θ� Ŭ�������� �Ű����� name, tel ��ӹ���.
	  this.address = address;
	  this.date = date;
	  point = 1000; // �ű� �����Դ� 1000 ����Ʈ �ڵ� �ο�.
	  System.out.println(name+"�� �����մϴ�. ����Ʈ 1000���� ������ �帳�ϴ�.");
   }
   public void buy (int price) { // c.buy(10000)
	  sum += price;
	  int tempPoint = (int)(price*0.05);
	  point += tempPoint;
	  System.out.println(getName()+"�� ����帳�ϴ�. �̹� ���� ����Ʈ "+tempPoint+"�� �߰��Ǿ� �� ����Ʈ : "+point);
	  if(sum>=1000000 && vip == false) {
		 vip = true; // ���Ŵ����ݾ��� 100���� �̻�� vip ������
         System.out.println(getName() + "�Բ����� VIP ������ ���׷��̵� �Ǽ̽��ϴ�.");
	  }//if
   }//by
    //1. c.print() vs. sysout(c.infoString) vs. sysout(c)
    // super.inforstring = "[�̸�] : "+name+" [��ȭ] : "+tel;
   public String infoString( ) {
	  return super.infoString() + " [�ּ�] : "+address+" [����Ʈ] : "+point+" [�����ݾ�] : "+sum+"��";
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
