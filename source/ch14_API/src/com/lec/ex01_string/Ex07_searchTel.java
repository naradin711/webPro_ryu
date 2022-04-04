package com.lec.ex01_string;
import java.util.Scanner;
// 배열에 있는 전화번호 찾아서 전체 전화번호 출력
public class Ex07_searchTel {
	public static void main(String[] args) {
		String[] tels = {"010-2222-3333","02-2222-8888","010-3333-8888"};
		Scanner sc = new Scanner(System.in);
		String searchTel;// 사용자로부터 전화번호 뒷번호 입력받은 데이터 할당 
        boolean searchOk = false;
        System.out.print("검색하고자 하는 회원의 전화번호의 뒷자리를 입력하시오. : ");
        searchTel = sc.next(); // 9999
        for(int idx = 0; idx<tels.length ; idx++) {
        	//idx번째의 전화번호 뒷자리만 추출
        	String post = tels[idx].substring(tels[idx].lastIndexOf('-')+1);
        	if(post.equals(searchTel)) {
        		System.out.println("검색하신 전화번호는 "+ tels[idx] +"입니다." );
        		searchOk = true;
        	} //if - 전화번호 찾을 경우 더 이상 검색하지 않고 for문 빠져나감.
        }//for 
        if(! searchOk) {//searchTel이 배열 전화에 없어서 못찾고 idx가 끝까지 간 경우.
           System.out.println("검색하신 전화번호는 없습니다.");
        }
       sc.close(); 
	}
   
}
