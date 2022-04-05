package com.lec.ex02_DataStream;
import java.io.*;
// 1. ��Ʈ�� ��ü ����-������ ����. 2. �����͸� ����. 3. ��Ʈ�� ��ü �ݴ´� = ������ �ݴ´�.
public class Ex01_DateOutputStream {
	public static void main(String[] args) {
	   OutputStream     fos = null;
	   DataOutputStream dos = null;
	   try {
		fos = new FileOutputStream("txtfile/dataFile.dat", true);//�⺻ ��Ʈ��
		dos = new DataOutputStream(fos); // ���� ��Ʈ���� �⺻ ��Ʈ���� ���ؼ��� ���� �����ϴ�.
		// �̸� - �г� - ���� write
		dos.writeUTF("ȫ�浿"); //���ڿ� �� ����
		dos.writeInt(2);       // ������ ����
		dos.writeDouble(95.5); // �Ǽ��� ����

		dos.writeUTF("ö�浿"); //���ڿ� �� ����
		dos.writeInt(1);       // ������ ����
		dos.writeDouble(87.6); // �Ǽ��� ����
		
		dos.writeUTF("�ɱ浿"); //���ڿ� �� ����
		dos.writeInt(4);       // ������ ����
		dos.writeDouble(98.2); // �Ǽ��� ����
	    System.out.println("���� ���� �Ϸ�");
	} catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
	} catch (IOException e) {
		System.out.println(e.getMessage());
	} finally {
		
			try {
				if (dos!=null) dos.close();
				if (fos!=null) fos.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} 
	}
	   
	}

}
