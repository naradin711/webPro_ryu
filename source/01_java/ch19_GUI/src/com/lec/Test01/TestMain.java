package com.lec.Test01;
import java.util.*;
public class TestMain {
	public static void main(String[] args) {
		Friend [] friends = {new Friend ("ȫ�浿", "����� ��걸", "010-9999-1234", "05-22"),
				              new Friend ("�ɱ浿", "����� ������", "010-1111-1234", "06-23")
				              };
        Scanner sc = new Scanner(System.in);
        while(true) {
        	System.out.print("�˻��� �ּ� �� ���� 2�ڸ� (��,���Ḧ ���Ͻø� x�� �Է��Ͻÿ�) : ");
        	String answer = sc.next();
        	if(answer.equalsIgnoreCase("x"))break;
        	boolean Ok=false;
        	for(int idx=0; idx<friends.length ; idx++) {
        		String add = friends[idx].getAddress();
        		String first = add.substring (0,2);
        	    if(first.equals(answer)) {
        	    	System.out.println(friends[idx]);
        	    	Ok=true;
        	    }
        	}
        	 if(! Ok) {
             	System.out.println("�ش� �ּ��� ģ���� �����ϴ�.");
             }
        }
        sc.close();
	}

}
