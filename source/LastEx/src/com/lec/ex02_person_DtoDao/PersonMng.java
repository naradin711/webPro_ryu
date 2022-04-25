package com.lec.ex02_person_DtoDao;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMng {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PersonDao dao = PersonDao.getInstance();
		String fn;
		ArrayList<PersonDto> dtos;
		do {
			System.out.println("1. 입력 || 2. 직업별 조회 || 3. 전체조회 || 4. 직업 목록 출력 || 그외 : 종료");
			fn = sc.next();
			switch(fn) {
			case "1" : // 이름, 직업명, 국, 영, 수 점수 입력
				System.out.print ("입력할 이름? ");
				String pname = sc.next();
				System.out.print ("입력할 직업은(가수, 배우, 엠씨)? ");
				String jname = sc.next();
				System.out.print ("국어 점수는?  ");
				int kor = sc.nextInt();
				System.out.print ("영어 점수는?  ");
				int eng = sc.nextInt();
				System.out.print ("수학 점수는?  ");
				int mat = sc.nextInt();
				int result = dao.insertPerson(new PersonDto(pname,  jname,  kor,  eng,  mat));
				System.out.println(result==PersonDao.SUCCESS ? "입력성공" : "입력실패");
				break;
			case "2" :
				System.out.println("직업별 조회");
				System.out.print ("조회 직업은(배우, 가수, 엠씨)? ");
				jname = sc.next();
				dtos = dao.selectJname(jname);
				if(!dtos.isEmpty()) {
					System.out.println("rank \t이름\t직업\t국어\t수학\t영어\t 총점");
					for(PersonDto d : dtos) {
						System.out.println(d);
					}
				}else {
					System.out.println("유효하지 않은 입력입니다.");
				}
				break;
			case "3" :
				System.out.println("전체 조회");
				dtos = dao.selectAll();
				if(dtos.size()!=0) {
					System.out.println("rank \t이름\t직업\t국어\t수학\t영어\t 총점");
					for(PersonDto d : dtos) {
						System.out.println(d);
					}
				}else {
					System.out.println("유효하지 않은 입력입니다.");
				}
				break;
			case "4" :
				System.out.println("직업 목록 출력");
				break;
			}
		}while (fn.equals("1") || fn.equals("2") || fn.equals("3")|| fn.equals("4"));
		sc.close();
		System.out.println("실행을 종료합니다.");
	}

}
