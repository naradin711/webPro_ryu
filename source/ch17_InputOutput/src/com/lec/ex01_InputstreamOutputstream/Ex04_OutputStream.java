package com.lec.ex01_InputstreamOutputstream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
// 1. ������ ����. ��¿� ��Ʈ�� ��ü ����.
// 2. write �Ѵ�. 
// 3. ������ �ݴ´�. (��Ʈ����ü.close)
public class Ex04_OutputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {                                                       // 1. �ùٸ� ��η� ���� ������ ������ �ش��ϴ� ������ ���� �����
			os = new FileOutputStream("txtfile/outTest.txt", true); //  true�� ���� �����.
			String str = "Hello, Java\n�� �ñ��� ��� �ǰ��ϼ���!";
			byte [] bs = str.getBytes();// �ش� ���ڿ��� byte �迭�� �ٲٴ� �Լ�.
				os.write(bs);
			System.out.println("���� ��� ����");
		} catch (FileNotFoundException e) {
		  System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(os!=null)os.close();
			} catch (IOException e) {
			System.out.println(e.getMessage());
			}
		}

	}

}
