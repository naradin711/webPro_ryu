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
		System.out.println("1. �й� �˻� || 2. �̸� �˻� || 3. �����˻� || 4. �л� �Է� || 5. �л� ���� || 6. �л� ��� || 7. ������ ��� || 8. ���� ó�� || �׿� : ����");	
		fn = sc.next();
		switch(fn) {
		case "1" :
			System.out.println("�й� �˻�");
			System.out.print("�˻��ϰ���  �ϴ� �й��� �Է��Ͻÿ�. ");
			int sno = sc.nextInt();
			dto = dao.snogetStudent(sno);
			String sname = dto.getSname();
			String mname = dto.getMname();			
			int score = dto.getScore();		
			System.out.println(sno+sname+mname+score);
			break;
			
		case "2" :
			System.out.println("�̸� �˻�");
			System.out.print("�˻��ϰ���  �ϴ� �̸��� �Է��Ͻÿ�. ");
			sname = sc.next();
			dtos = dao.snamegetStudent(sname);
			if(!dtos.isEmpty()) {
				System.out.println("�й�\t�̸�\t����\t����");
				for(StudentDto d : dtos) {
					System.out.println(d);
				}
			}else {
				System.out.println("��ȿ���� ���� �Է��Դϴ�.");
			}
			break;
			
		case "3" :
			System.out.println("���� �˻�");
			System.out.print("�˻��ϰ���  �ϴ� �̸��� �Է��Ͻÿ�. ");
			mname = sc.next();
			dtos = dao.selectMname(mname);
			if(!dtos.isEmpty()) {
				System.out.println("RANK\t�̸�\t\t����\t����");
				for(StudentDto d : dtos) {
					System.out.println(d);
				}
			}else {
				System.out.println("��ȿ���� ���� �Է��Դϴ�.");
			}
			break;
			
		case "4" :
			System.out.println ("�л� �Է�");
			System.out.print ("�Է��� �̸�? ");
			 	sname = sc.next();
			System.out.print ("�Է��� �а���? ");
				mname = sc.next();
			System.out.print ("�Է��� ������? ");	
				score = sc.nextInt();
			int result = dao.insertStudent(new StudentDto(sname, mname, score));
			System.out.println(result==StudentDao.SUCCESS ? "�Է¼���" : "�Է½���");
			break;
		
		case "5" :
			System.out.println ("�л� ����");
			System.out.println("�й� �˻�");
			System.out.print("����  �ϴ� �й��� �Է��Ͻÿ�. ");
			 sno = sc.nextInt();
			dto = dao.snogetStudent(sno);
			 sname = dto.getSname();
			 mname = dto.getMname();			
			 score = dto.getScore();
			 result = dao.updateStudent(new StudentDto(sno, sname, mname, score));
			break;
			
		case "6" :
			System.out.println("�л� ��� ");
			dtos = dao.getStudents();
			if(dtos.size()!=0) {
				System.out.println("rank\t�̸�\t\t����\t\t����");
				for (StudentDto d : dtos) {
					System.out.println(d);
				}
			}else {
				System.out.println("��ȿ���� ���� �Է��Դϴ�.");
			}			
			break;
			
		case "7" :
			System.out.println ("������ ��� ");
			dtos = dao.getStudentsExpel();
			if(dtos.size()!=0) {
				System.out.println("rank\t�̸�\t\t����\t\t����");
				for (StudentDto d : dtos) {
					System.out.println(d);
				}
			}else {
				System.out.println("��ȿ���� ���� �Է��Դϴ�.");
			}
			break;
			
		case "8" :
			System.out.println("���� ó��");
			System.out.print("�����ϰ���  �ϴ� �й��� �Է��Ͻÿ�. ");
			 sno = sc.nextInt();
			 result = dao.sNoExpel(new StudentDto(sno));
			break;
		}
	  }while(fn.equals("1") || fn.equals("2") || fn.equals("3") || fn.equals("4") || fn.equals("5") || fn.equals("6") || fn.equals("7") || fn.equals("8"));
	}
}
