package com.lec.ex05_momchild;
// Child first = new Child("ù°");
// first.takemoney (1000) "���� õ����"
public class Child {
	private String name;
	static Mompouch momPouch; //static�� ����ϸ� �ش� ������
	                          //heap�޸𸮿� 1��ü�� ����.
	public Child( ) {}
	public Child(String name) {
		this.name = name ;
		momPouch = new Mompouch();
	}
    public void takemoney(int money){
       if(momPouch.money >= money) {
    	     momPouch.money -= money;
    	     System.out.println(name+ "�� " + money+"�� �������� ���� ������ " +momPouch.money + "�� ����" );
       }else {
    	   System.out.println(name + "�� ���� ������. \n���� ���� �������� " + momPouch.money +"�� �ۿ� ����");
       }//if
    }//take money
}














