package com.lec.quiz01_institute;
public class Main {
	public static void main(String[] args) {
       Person st1 = new Student("A01","서지수","JAVA반");
       Person st2 = new Student("A02","류수정","C++반");
       Person sf1 = new Staff("S01","설윤아","운영지원팀");
       Person sf2 = new Staff("S02","오해영","취업지원팀");
       Person tc1 = new Teacher("T01","노지선","객체지향");
       Person [] p = {st1, st2, sf1, sf2, tc1} ;
       //st1.print();
       for(Person pp : p) {
    	pp.print();
       }
	}
}
