package com.lec.quiz01_institute;
public class Main {
	public static void main(String[] args) {
       Person st1 = new Student("A01","������","JAVA��");
       Person st2 = new Student("A02","������","C++��");
       Person sf1 = new Staff("S01","������","�������");
       Person sf2 = new Staff("S02","���ؿ�","���������");
       Person tc1 = new Teacher("T01","������","��ü����");
       Person [] p = {st1, st2, sf1, sf2, tc1} ;
       //st1.print();
       for(Person pp : p) {
    	pp.print();
       }
	}
}
