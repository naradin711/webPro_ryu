package com.lec.ex01_string;

public class Ex06_regex {
   public static void main(String[] args) {
	  String str = "010-9999-9999 1111@naver.com (031)3888-9999 반갑습니다. 888888-2888888 daewqd@naver.com 안녕하세요 abc@hong.co.kr";
	  //System.out.println("replace =>" +str.replace("0", "홍")); // 0만 홍으로 바뀜
	  // 정규표현식
	  // 1. 참조 : goo.gl/HLntbd
	  // 2. 간략 문법
	  //    \\ d(숫자와 매치, [0-9]와 동일)
	  //    \\ s(whitespacen : 스페이스, 탭, 엔터)
	  //    \\ w(영문자나 숫자, [a-zA-z0-9]와 동일)
	  //    \\ W(영문자나 숫자가 아닌 문자.)
	  //       . (문자 하나)
	  //       + (1번이상 반복)
	  //       * (0번이상 반복)
	  //       ? (0-1번 반복)
	  // 3. 연습장 regexr.com
	  //  ex. 전화 번호 정규표현식은 다음과 같다.
	  // .?([0-9]){2,3}.[0-9]{3,4}-[0-9]{4} 전화번호 정규표현식
	  // [(]?[0-9][)]{2,3}.\D[0-9]{3,4}-[0-9]{4}
	  //      010            1111       1111
	  // 4. 특정 정규 표현식의 문자열 변경 : replaceAll("정규표현식", "대체문자열")
	  //    - \w+@\w+(.\w+){1,2} 이메일 정규 표현식
	
	  System.out.println(str.replaceAll(".?([0-9]){2,3}.[0-9]{3,4}-[0-9]{4}", "전화번호 지움"));
	  // 전화번호 지움식
	  System.out.println(str.replaceAll("\\w+@\\w+(.\\w+){1,2}", "***이메일 지움 ***"));
      // 이메일 지움
	  System.out.println(str.replaceAll("[a-zA-Z]", ""));
      // 알파벳을 지움
	  System.out.println(str.replaceAll("[가-힣ㄱ-ㅎ]", ""));
      // 한글 지움
	  System.out.println(str.replaceAll("[0-9]{7}", "*******")); // {7} = 7번 반복
	  // 주민번호 뒷자리 지움
	  
   }
}







