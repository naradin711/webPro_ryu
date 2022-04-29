package com.lec.ex03_ReaderWriter;
import java.io.*;
public class Ex03_BufferReader {
	public static void main(String[] args) {
       Reader         reader = null;
       BufferedReader br     = null;
       try {
		reader = new FileReader("txtfile/inTest.txt"); //1. �⺻ ��Ʈ�� ����
		br     = new BufferedReader(reader);// 1-1. ���� ��Ʈ�� ����
		int cnt = 0;
		while(true) {
			String linedata = br.readLine();// 2. ���پ� ������ �б�.
			if(linedata==null) break;
			System.out.println(++cnt +". "+ linedata);
		}
	} catch (FileNotFoundException e) {
        System.out.println(e.getMessage());
	} catch (IOException e) {
        System.out.println(e.getMessage());
	}finally {
		try { // 3. ������ ������. ���� �ݱ�.
			if (br!=null) br.close();
			if (reader!=null) reader.close();
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
	}
  }
}
