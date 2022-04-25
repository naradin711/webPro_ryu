package com.lec.ex02_person_DtoDao;

import java.util.ArrayList;
import java.util.Vector;

public class PersonDaoTest {

	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance();
		PersonDto dto = new PersonDto("이순재", "배우", 60, 80, 70);
		int result = dao.insertPerson(dto); // 1번 기능 입력 테스트
		System.out.println("*****************1번 테스트***************************");
		System.out.println();
		System.out.println(result == PersonDao.SUCCESS? "입력성공":"입력실패");
		System.out.println();
		System.out.println("*****************2번 테스트***************************");
		System.out.println();
		ArrayList<PersonDto> dtos = dao.selectJname("배우"); // 2번 기능 직업별 조회 테스트
		if(!dtos.isEmpty()) {
			for(PersonDto d : dtos) {
				System.out.println(d);
			}		
		}else {
			System.out.println("유효한 입력이 아닙니다. ");
		}
		System.out.println();
		System.out.println("*****************3번 테스트***************************");
		System.out.println();
		dtos = dao.selectAll();
		if(dtos.size()!=0) {
			for(PersonDto d : dtos) {
				System.out.println(d);
			}			
		}else {
			System.out.println("유효한 입력이 아닙니다. ");	
		}
		System.out.println();
		System.out.println("*****************4번 테스트***************************");
		System.out.println();
		Vector<String> jnames = dao.jnamelist(); // 4.직업명 리스트
		System.out.println(jnames);
	}

}
