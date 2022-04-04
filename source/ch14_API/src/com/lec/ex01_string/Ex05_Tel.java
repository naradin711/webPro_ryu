package com.lec.ex01_string;
// 전화번호를 입력하여 입력받은 전화번호, 짝수번째 문자, 거꾸로, 전화번호 앞자리, 전화번호 뒷자리
import java.util.Scanner;
public class Ex05_Tel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		    do {
				System.out.print("전화번호를 입력하세요. (000-0000-0000) ");
				String tel = sc.next(); // 스트링입력
				if(tel.equalsIgnoreCase("x"))break;
				System.out.println("입력한 전화번호 : "+tel); //입력한 전화번호
				System.out.print("짝수번째 문자열 : "); // 짝수번째 문자. 숫자열 프린트
				for(int i=0 ; i<tel.length() ; i++){
					if(i%2 ==0) {
						System.out.print(tel.charAt(i)); // 짝수번째 출력
					}else {
						System.out.print(' ');//홀수 번째 문자열 대신 공백 출력
					}
				}
				System.out.println();
				System.out.print("전화번호의 역순 : "); // 전화번호의 역순
				for(int i =tel.length()-1 ; i>=0 ; i--) {
					System.out.print(tel.charAt(i));
				}
				System.out.println();
	            String pre = tel.substring(0,tel.indexOf('-'));
	            String post= tel.substring(tel.lastIndexOf('-')+1);
	            String mid= tel.substring(tel.indexOf('-')+1,tel.lastIndexOf('-'));
	            System.out.println("전화번호 앞자리 : "+pre);
	            System.out.println("전화번호 중간자리 : "+mid);
	            System.out.println("전화번호 뒷자리 : "+post);
		        }while(true);
		        System.out.println("종료합니다.");
	}

}
