package com.lec.ex2_human.main;
import com.lec.ex2_human.*;// com.lec.ex2_human. 폴더 안의 패키지의 모든 class를 
                           // 불필요한 package Import 삭제 : ctrl+shift+o
public class Testmain {
   public static void main(String[] args) {
	  int i = 10;
	  int j = 10;
	  System.out.println(i==j ? "같다." : "다르다.");
	  if(i==j) {
		  System.out.println("i와 j는 같다.");  
	  }else {
		  System.out.println("i와 j는 다르다.");
	  }
	  String name = "홍길동";
	  String name2 = "김길동";
	  if(name.equals(name2)) { //if(name==name2) {
		 System.out.println("같다."); 
	  }else {
		  System.out.println("다르다.");
	  }
	  Woman hee1 = new Woman();
	  Woman hee2 = new Woman();
	  if(hee1.equals(hee2)) { // 객체 변수가 같은지 비교시 equals 사용.
	 //if(name==name2) 
			 System.out.println("hee1과 hee2는 같다."); 
	  }else {
			  System.out.println("hee1과 hee2는 다르다.");
	  }
	  Man kang = new Man(33,168,119.1);
	  Man kim =  new Man(22,180,72.3);
	  Man kim1; // 레퍼런스 변수 선언
	  kim1 = kim;
	  Man kim2 = new Man(22,180,72.3); // 변수는 같으나 주소가 다르기에 서로 다른 변수라고 인식함.
	  if (kim.equals(kim1)) {
		  System.out.println("같다."); // 같은 주소를 가리킨다.
	  }
	  if (kim.equals(kim2)) {
		  System.out.println("같다."); // 같은 주소값을 지닌다.
	  }else {
		  System.out.println("다르다."); // 다른 주소값이 있다.
	  }
	  if (!kim.equals(kim2)) {
		  System.out.println("다르다."); // 다른 주소값이 있다.
	  }
	  kang.setHeight(170);
	  kang.setWeight(51.89); // 정수를 써도 묵시적인 형변환 double -> int 로 자동으로 인식. 반대는 안됨.
	  if(kang.calculateBMI()>30) {
		  System.out.println("건강하세요...");
	  }else {
		  System.out.println("건강하시겠네요?");
	  }
 }
}
