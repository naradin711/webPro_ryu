package com.lec.ex03_Student;

import java.util.ArrayList;
import java.util.Scanner;
 

public class StudentMng {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentDao dao = StudentDao.getInstance();
		String fn;
		ArrayList<StudentDto> dtos;
		StudentDto dto = new StudentDto();
		do {
		System.out.println("1. 학번 검색 || 2. 이름 검색 || 3. 전공검색 || 4. 학생 입력 || 5. 학생 수정 || 6. 학생 출력 || 7. 제적자 출력 || 8. 제적 처리 || 그외 : 종료");	
		fn = sc.next();
		switch(fn) {
		case "1" :
			System.out.println("학번 검색");
			System.out.print("검색하고자  하는 학번을 입력하시오. ");
			int sno = sc.nextInt();
			dto = dao.snogetStudent(sno);
			String sname = dto.getSname();
			String mname = dto.getMname();			
			int score = dto.getScore();		
			System.out.println(sno+sname+mname+score);
			break;
			
		case "2" :
			System.out.println("이름 검색");
			System.out.print("검색하고자  하는 이름을 입력하시오. ");
			sname = sc.next();
			dtos = dao.snamegetStudent(sname);
			if(!dtos.isEmpty()) {
				System.out.println("학번\t이름\t전공\t점수");
				for(StudentDto d : dtos) {
					System.out.println(d);
				}
			}else {
				System.out.println("유효하지 않은 입력입니다.");
			}
			break;
			
		case "3" :
			System.out.println("전공 검색");
			System.out.print("검색하고자  하는 이름을 입력하시오. ");
			mname = sc.next();
			dtos = dao.selectMname(mname);
			if(!dtos.isEmpty()) {
				System.out.println("RANK\t이름\t\t전공\t점수");
				for(StudentDto d : dtos) {
					System.out.println(d);
				}
			}else {
				System.out.println("유효하지 않은 입력입니다.");
			}
			break;
			
		case "4" :
			System.out.println ("학생 입력");
			System.out.print ("입력할 이름? ");
			 	sname = sc.next();
			System.out.print ("입력할 학과는? ");
				mname = sc.next();
			System.out.print ("입력할 점수는? ");	
				score = sc.nextInt();
			int result = dao.insertStudent(new StudentDto(sname, mname, score));
			System.out.println(result==StudentDao.SUCCESS ? "입력성공" : "입력실패");
			break;
		
		case "5" :
			System.out.println ("학생 수정");
			System.out.println("학번 검색");
			System.out.print("수정  하는 학번을 입력하시오. ");
			 sno = sc.nextInt();
			dto = dao.snogetStudent(sno);
			 sname = dto.getSname();
			 mname = dto.getMname();			
			 score = dto.getScore();
			 result = dao.updateStudent(new StudentDto(sno, sname, mname, score));
			break;
			
		case "6" :
			System.out.println("학생 출력 ");
			dtos = dao.getStudents();
			if(dtos.size()!=0) {
				System.out.println("rank\t이름\t\t전공\t\t점수");
				for (StudentDto d : dtos) {
					System.out.println(d);
				}
			}else {
				System.out.println("유효하지 않은 입력입니다.");
			}			
			break;
			
		case "7" :
			System.out.println ("제적자 출력 ");
			dtos = dao.getStudentsExpel();
			if(dtos.size()!=0) {
				System.out.println("rank\t이름\t\t전공\t\t점수");
				for (StudentDto d : dtos) {
					System.out.println(d);
				}
			}else {
				System.out.println("유효하지 않은 입력입니다.");
			}
			break;
			
		case "8" :
			System.out.println("제적 처리");
			System.out.print("제적하고자  하는 학번을 입력하시오. ");
			 sno = sc.nextInt();
			 result = dao.sNoExpel(new StudentDto(sno));
			break;
		}
	  }while(fn.equals("1") || fn.equals("2") || fn.equals("3") || fn.equals("4") || fn.equals("5") || fn.equals("6") || fn.equals("7") || fn.equals("8"));
	}
}
