package com.lec.ex01_InputstreamOutputstream;

import java.io.*;

// 1. �켱 ��Ʈ�� ��ü ���� (�Է¿�, ��¿�) 2. �а� ����. 3. ��Ʈ�� ��ü �ݴ´�. (��Ʈ����ü.close)
public class Ex05_fileCopyStep1 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("d:/webPro/bts.jpg");
			os = new FileOutputStream("d:/webPro/bts_copied.jpg");
			int cnt = 0; // ����� �ݺ��� Ƚ�� ����.
			while(true) {// 2�ܰ� �а� ����
				int i = is.read(); //1byte�б�
				if(i==-1) break;
				os.write(i);
				cnt ++;
			}
			System.out.println(cnt+"�� �����Ͽ� ���� ����!");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os!=null) os.close(); //
				if (is!=null) is.close(); // ó�� ���� ��ü�� ���߿� Ŭ���� �ؾ���. is os ������ ����� os is������ Ŭ����
				System.out.println("���� �Ϸ�!");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
