package com.lec.ex01_string;
// ��ȭ��ȣ�� �Է��Ͽ� �Է¹��� ��ȭ��ȣ, ¦����° ����, �Ųٷ�, ��ȭ��ȣ ���ڸ�, ��ȭ��ȣ ���ڸ�
import java.util.Scanner;
public class Ex05_Tel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		    do {
				System.out.print("��ȭ��ȣ�� �Է��ϼ���. (000-0000-0000) ");
				String tel = sc.next(); // ��Ʈ���Է�
				if(tel.equalsIgnoreCase("x"))break;
				System.out.println("�Է��� ��ȭ��ȣ : "+tel); //�Է��� ��ȭ��ȣ
				System.out.print("¦����° ���ڿ� : "); // ¦����° ����. ���ڿ� ����Ʈ
				for(int i=0 ; i<tel.length() ; i++){
					if(i%2 ==0) {
						System.out.print(tel.charAt(i)); // ¦����° ���
					}else {
						System.out.print(' ');//Ȧ�� ��° ���ڿ� ��� ���� ���
					}
				}
				System.out.println();
				System.out.print("��ȭ��ȣ�� ���� : "); // ��ȭ��ȣ�� ����
				for(int i =tel.length()-1 ; i>=0 ; i--) {
					System.out.print(tel.charAt(i));
				}
				System.out.println();
	            String pre = tel.substring(0,tel.indexOf('-'));
	            String post= tel.substring(tel.lastIndexOf('-')+1);
	            String mid= tel.substring(tel.indexOf('-')+1,tel.lastIndexOf('-'));
	            System.out.println("��ȭ��ȣ ���ڸ� : "+pre);
	            System.out.println("��ȭ��ȣ �߰��ڸ� : "+mid);
	            System.out.println("��ȭ��ȣ ���ڸ� : "+post);
		        }while(true);
		        System.out.println("�����մϴ�.");
	}

}
