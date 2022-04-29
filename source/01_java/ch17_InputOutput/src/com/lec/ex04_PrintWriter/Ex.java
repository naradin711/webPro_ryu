package com.lec.ex04_PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
public class Ex {
	public static void main(String[] args) {
		OutputStream os = null;
		Writer writer = null;
		PrintWriter prWriter = null;
		try {
//			os = new FileOutputStream("txtfile/outTest.txt", true);//�⺻��Ʈ��
//			prWriter = new PrintWriter(os); // ������Ʈ��
//			writer = new FileWriter("txtfile/outTest.txt", true); //�⺻��Ʈ��
//			prWriter = new PrintWriter(writer); // ������Ʈ��
			prWriter = new PrintWriter("txtfile/outTest.txt"); // ���� append �Ұ���.
			System.out.println("�ȳ��ϼ��� \n�ݰ����ϴ�");
			prWriter.println("�ȳ��ϼ��� \n�ݰ����ϴ�");
			System.out.print("print�� ������ �ȵǼ� �����߰� \n");
			prWriter.print("print�� ������ �ȵǼ� �����߰� \n");
			System.out.printf("%s \t %3d \t %3d \t %4.1f\n", "ȫ�浿", 90, 91, 90.78);
			prWriter.printf("%s \t %3d \t %3d \t %4.1f\n", "ȫ�浿", 90, 91, 90.78);

			System.out.printf("%s \t %3d \t %3d \t %4.1f\n", "�ɱ浿", 100, 100, 100.00);
			prWriter.printf("%s \t %3d \t %3d \t %4.1f\n", "�ɱ浿", 100, 100, 100.00);
		} catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
		} catch (IOException e) {
            System.out.println(e.getMessage());
		} finally {
			try {
				if(prWriter!=null) prWriter.close();
			} catch (Exception e2) {
	            System.out.println(e2.getMessage());
			}
		}
	}

}


























