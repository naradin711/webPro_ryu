package com.lec.ex01_string;

public class Ex02_stringAPImethod {

	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String ("ABCXabc");
		String str3 = "            ja          va           ";
		System.out.println("1. "+str1.concat(str2)); //abcXabcABCxabc �� ���ڿ��� ���ϴ� ��.
		System.out.println("2. "+str1.substring(3)); // Xabc ������ġ���� ���������� ��ȯ(return)
		System.out.println("3. "+str1.substring(3,5));// Xa ���� ��ġ���� �ش� ���� �ٷ� �ձ��� ��ȯ (return)
		System.out.println("4. "+str1.length());//���ڱ��� 7
		System.out.println("5. "+str1.toUpperCase());// �ش� ���ڿ��� �ִ� ���ڸ� �빮�ڷ� �ٲ۴� ABCXABC
		System.out.println("6. "+str1.toLowerCase());// �ش� ���ڿ��� �ִ� ���ڸ� �ҹ��ڷ� �ٲ۴� abcxabc
		System.out.println("7. "+str1.charAt(3));// ����° ���� 'X'
		System.out.println("8. "+str1.indexOf('b')); // b�� ���°�� ��������
		System.out.println("9. "+str1.indexOf('b', 3)); // 3��° ���� �����ؼ� b�� ���°�� ��������
		System.out.println("10. "+str1.indexOf("abc")); // ���ڿ��� ��ġ
		System.out.println("11. "+str1.indexOf("abc",3)); // 3��° ���� �����ϴ� ���ڿ� ��ġ 
		System.out.println("12. "+str1.indexOf('z')); // ������ -1
		System.out.println("13. "+str1.lastIndexOf('b')); // �������� b ��ġ�� ��ȯ 
		System.out.println("14. "+str1.lastIndexOf('b',3));//3��° ���� �� �������� b
		str1 = "abcXabc";
		str2 = new String ("ABCXabc");
		System.out.println("15. "+str1.equals(str2));// ���� ���� ���ڿ��ΰ�?
		System.out.println("16. "+str1.equalsIgnoreCase(str2)); //��ҹ��� ���� ���� ��.
		str1 = "abcXabc";
		str3 = "            ja          va           ";
		System.out.println("17. "+str3.trim()); // �� �� ����鸸 �߶󳻱�
		System.out.println("18. "+str1.replace('a', '9')); // a�� 9�� ��� ���� ���ڿ��� ���� ����
		System.out.println("19. "+str1.replace("abc", "$")); // abc�� ���� ���� 
		System.out.println("������ֱ� "+str3.replace(" ","")); // ������ ���ڿ��������� ��ü
		System.out.println("20. "+str1.replaceAll("abc", "z")); // abc�� z
		// ����ǥ���� 
		// ������
		String str = "�ȳ�Hello"; // ������ �� �����ϰ� ����
		System.out.println(str.replaceAll("[a-zA-z]","")); //���� ���ֱ�
		System.out.println(str.replaceAll("[��-�R]","")); // �ѱ� ���ֱ� 
		// ���ڿ� �޼ҵ�� ���ڿ��� �������� ����.
		System.out.println("str1 = "+str1);
	}

}




















