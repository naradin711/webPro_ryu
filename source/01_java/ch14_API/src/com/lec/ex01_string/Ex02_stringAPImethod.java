package com.lec.ex01_string;

public class Ex02_stringAPImethod {

	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String ("ABCXabc");
		String str3 = "            ja          va           ";
		System.out.println("1. "+str1.concat(str2)); //abcXabcABCxabc 두 문자열을 더하는 것.
		System.out.println("2. "+str1.substring(3)); // Xabc 시작위치부터 마지막까지 반환(return)
		System.out.println("3. "+str1.substring(3,5));// Xa 시작 위치부터 해당 숫자 바로 앞까지 반환 (return)
		System.out.println("4. "+str1.length());//글자길이 7
		System.out.println("5. "+str1.toUpperCase());// 해당 문자열에 있는 글자를 대문자로 바꾼다 ABCXABC
		System.out.println("6. "+str1.toLowerCase());// 해당 문자열에 있는 글자를 소문자로 바꾼다 abcxabc
		System.out.println("7. "+str1.charAt(3));// 세번째 문자 'X'
		System.out.println("8. "+str1.indexOf('b')); // b가 몇번째에 나오는지
		System.out.println("9. "+str1.indexOf('b', 3)); // 3번째 부터 시작해서 b가 몇번째에 나오는지
		System.out.println("10. "+str1.indexOf("abc")); // 문자열의 위치
		System.out.println("11. "+str1.indexOf("abc",3)); // 3번째 부터 시작하는 문자열 위치 
		System.out.println("12. "+str1.indexOf('z')); // 없으면 -1
		System.out.println("13. "+str1.lastIndexOf('b')); // 마지막의 b 위치를 반환 
		System.out.println("14. "+str1.lastIndexOf('b',3));//3번째 부터 맨 마지막의 b
		str1 = "abcXabc";
		str2 = new String ("ABCXabc");
		System.out.println("15. "+str1.equals(str2));// 서로 같은 문자열인가?
		System.out.println("16. "+str1.equalsIgnoreCase(str2)); //대소문자 구분 없이 비교.
		str1 = "abcXabc";
		str3 = "            ja          va           ";
		System.out.println("17. "+str3.trim()); // 앞 뒤 공백들만 잘라내기
		System.out.println("18. "+str1.replace('a', '9')); // a를 9로 모두 수정 문자열도 같이 가능
		System.out.println("19. "+str1.replace("abc", "$")); // abc를 별로 수정 
		System.out.println("공백없애기 "+str3.replace(" ","")); // 공백을 문자열없음으로 대체
		System.out.println("20. "+str1.replaceAll("abc", "z")); // abc를 z
		// 정규표현식 
		// 연습장
		String str = "안녕Hello"; // 영문자 다 제거하고 싶음
		System.out.println(str.replaceAll("[a-zA-z]","")); //영어 없애기
		System.out.println(str.replaceAll("[가-힣]","")); // 한글 없애기 
		// 문자열 메소드는 문자열을 수정하지 않음.
		System.out.println("str1 = "+str1);
	}

}




















