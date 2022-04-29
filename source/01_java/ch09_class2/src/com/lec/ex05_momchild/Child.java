package com.lec.ex05_momchild;
// Child first = new Child("첫째");
// first.takemoney (1000) "엄마 천원만"
public class Child {
	private String name;
	static Mompouch momPouch; //static을 사용하면 해당 변수가
	                          //heap메모리에 1개체만 잡힘.
	public Child( ) {}
	public Child(String name) {
		this.name = name ;
		momPouch = new Mompouch();
	}
    public void takemoney(int money){
       if(momPouch.money >= money) {
    	     momPouch.money -= money;
    	     System.out.println(name+ "가 " + money+"원 가져가서 엄마 지갑에 " +momPouch.money + "원 있음" );
       }else {
    	   System.out.println(name + "가 돈을 못받음. \n현재 엄마 지갑에는 " + momPouch.money +"원 밖에 없음");
       }//if
    }//take money
}














