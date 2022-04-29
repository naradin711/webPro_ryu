package com.lec.ex01_InputstreamOutputstream;

import java.io.*;

// 1. �켱 ��Ʈ�� ��ü ���� (�Է¿�, ��¿�) 2. �а� ����. 3. ��Ʈ�� ��ü �ݴ´�. (��Ʈ����ü.close)
public class Ex07_fileCopyStep3 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			File file = new File("d:/webPro/bts.jpg");
			is = new FileInputStream(file);
			os = new FileOutputStream("d:/webPro/bts_mk3.jpg");
			int cnt = 0; // ����� �ݺ��� Ƚ�� ����.
			byte [] bs = new byte [(int)file.length()]; //�����ϰ� ���� ������ �뷮�� ����
			while(true) {// 2�ܰ� �а� ����
				int readByCount = is.read(bs); //1kbyte�б�
				if(readByCount==-1) break;
				os.write(bs, 0, readByCount);//bs�� ����� �� 0�� index���� readByCount��ŭ ����.
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
