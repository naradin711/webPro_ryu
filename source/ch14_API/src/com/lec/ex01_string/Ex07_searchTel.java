package com.lec.ex01_string;
import java.util.Scanner;
// �迭�� �ִ� ��ȭ��ȣ ã�Ƽ� ��ü ��ȭ��ȣ ���
public class Ex07_searchTel {
	public static void main(String[] args) {
		String[] tels = {"010-2222-3333","02-2222-8888","010-3333-8888"};
		Scanner sc = new Scanner(System.in);
		String searchTel;// ����ڷκ��� ��ȭ��ȣ �޹�ȣ �Է¹��� ������ �Ҵ� 
        boolean searchOk = false;
        System.out.print("�˻��ϰ��� �ϴ� ȸ���� ��ȭ��ȣ�� ���ڸ��� �Է��Ͻÿ�. : ");
        searchTel = sc.next(); // 9999
        for(int idx = 0; idx<tels.length ; idx++) {
        	//idx��°�� ��ȭ��ȣ ���ڸ��� ����
        	String post = tels[idx].substring(tels[idx].lastIndexOf('-')+1);
        	if(post.equals(searchTel)) {
        		System.out.println("�˻��Ͻ� ��ȭ��ȣ�� "+ tels[idx] +"�Դϴ�." );
        		searchOk = true;
        	} //if - ��ȭ��ȣ ã�� ��� �� �̻� �˻����� �ʰ� for�� ��������.
        }//for 
        if(! searchOk) {//searchTel�� �迭 ��ȭ�� ��� ��ã�� idx�� ������ �� ���.
           System.out.println("�˻��Ͻ� ��ȭ��ȣ�� �����ϴ�.");
        }
       sc.close(); 
	}
   
}
