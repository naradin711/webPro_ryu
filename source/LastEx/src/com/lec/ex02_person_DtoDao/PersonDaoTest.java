package com.lec.ex02_person_DtoDao;

import java.util.ArrayList;
import java.util.Vector;

public class PersonDaoTest {

	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance();
		PersonDto dto = new PersonDto("�̼���", "���", 60, 80, 70);
		int result = dao.insertPerson(dto); // 1�� ��� �Է� �׽�Ʈ
		System.out.println("*****************1�� �׽�Ʈ***************************");
		System.out.println();
		System.out.println(result == PersonDao.SUCCESS? "�Է¼���":"�Է½���");
		System.out.println();
		System.out.println("*****************2�� �׽�Ʈ***************************");
		System.out.println();
		ArrayList<PersonDto> dtos = dao.selectJname("���"); // 2�� ��� ������ ��ȸ �׽�Ʈ
		if(!dtos.isEmpty()) {
			for(PersonDto d : dtos) {
				System.out.println(d);
			}		
		}else {
			System.out.println("��ȿ�� �Է��� �ƴմϴ�. ");
		}
		System.out.println();
		System.out.println("*****************3�� �׽�Ʈ***************************");
		System.out.println();
		dtos = dao.selectAll();
		if(dtos.size()!=0) {
			for(PersonDto d : dtos) {
				System.out.println(d);
			}			
		}else {
			System.out.println("��ȿ�� �Է��� �ƴմϴ�. ");	
		}
		System.out.println();
		System.out.println("*****************4�� �׽�Ʈ***************************");
		System.out.println();
		Vector<String> jnames = dao.jnamelist(); // 4.������ ����Ʈ
		System.out.println(jnames);
	}

}
