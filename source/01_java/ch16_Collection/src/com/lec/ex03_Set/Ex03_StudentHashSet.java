package com.lec.ex03_Set;
import java.util.*;
public class Ex03_StudentHashSet {
	public static void main(String[] args) {
		HashSet <Student> students = new HashSet <Student>();
		Student s = new Student(6, "�̼���");
		students.add(s); // �ּҰ� ����
		students.add(s); // �ּҰ� ���� = �ߺ����� �ν�
		System.out.println(students);
		students.add(new Student(3, "ȫ�浿"));
		students.add(new Student(3, "ȫ�浿"));//�� ȫ�浿�� �Ʒ� ȫ�浿�� �ٸ�
		students.add(new Student(6, "�̼���"));
		System.out.println(students);
	}

}
