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
			System.out.println("1. �Է� || 2. ������ ��ȸ || 3. ��ü��ȸ || 4. ���� ��� ��� || �׿� : ����");
			fn = sc.next();
			switch(fn) {
			case "1" : // �̸�, ������, ��, ��, �� ���� �Է�
				System.out.print ("�Է��� �̸�? ");
				String pname = sc.next();
				System.out.print ("�Է��� ������(����, ���, ����)? ");
				String jname = sc.next();
				System.out.print ("���� ������?  ");
				int kor = sc.nextInt();
				System.out.print ("���� ������?  ");
				int eng = sc.nextInt();
				System.out.print ("���� ������?  ");
				int mat = sc.nextInt();
				int result = dao.insertPerson(new PersonDto(pname,  jname,  kor,  eng,  mat));
				System.out.println(result==PersonDao.SUCCESS ? "�Է¼���" : "�Է½���");
				break;
			case "2" :
				System.out.println("������ ��ȸ");
				System.out.print ("��ȸ ������(���, ����, ����)? ");
				jname = sc.next();
				dtos = dao.selectJname(jname);
				if(!dtos.isEmpty()) {
					System.out.println("rank \t�̸�\t����\t����\t����\t����\t ����");
					for(PersonDto d : dtos) {
						System.out.println(d);
					}
				}else {
					System.out.println("��ȿ���� ���� �Է��Դϴ�.");
				}
				break;
			case "3" :
				System.out.println("��ü ��ȸ");
				dtos = dao.selectAll();
				if(dtos.size()!=0) {
					System.out.println("rank \t�̸�\t����\t����\t����\t����\t ����");
					for(PersonDto d : dtos) {
						System.out.println(d);
					}
				}else {
					System.out.println("��ȿ���� ���� �Է��Դϴ�.");
				}
				break;
			case "4" :
				System.out.println("���� ��� ���");
				break;
			}
		}while (fn.equals("1") || fn.equals("2") || fn.equals("3")|| fn.equals("4"));
		sc.close();
		System.out.println("������ �����մϴ�.");
	}

}
