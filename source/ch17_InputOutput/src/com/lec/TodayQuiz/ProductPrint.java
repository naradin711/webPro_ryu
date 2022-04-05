package com.lec.TodayQuiz;
// ���Ͽ� ����� ������ ���.
import java.io.*;
import java.util.*;
public class ProductPrint {
	public static void main(String[] args) {
		InputStream     fis=null;
		DataInputStream dis=null;
		ArrayList<Product> products = new ArrayList<Product> ();
		try {
			fis = new FileInputStream("src/com/lec/TodayQuiz/product.dat");
			dis = new DataInputStream(fis);
			while (true) {
				String name = dis.readUTF();
				int   price = dis.readInt();
				int      ps = dis.readInt();
				products.add(new Product(name, price, ps));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("��� �����ʹ� ������ �����ϴ�.");
		} finally {
			try {
				if(dis!=null) dis.close();
				if(fis!=null) fis.close();	
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}// try-catch
		}// array
		if(products.isEmpty()) {
			System.out.println("�Էµ� ����� �����ϴ�.");
		}else {
			for(Product p :products) {
				System.out.println(p);
			}
			System.out.println("�̻� ��ǰ " + products.size()+"�� �Էµ�.");
		}
	}
}
