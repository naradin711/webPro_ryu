package com.lec.ex01_string;

public class Ex06_regex {
   public static void main(String[] args) {
	  String str = "010-9999-9999 1111@naver.com (031)3888-9999 �ݰ����ϴ�. 888888-2888888 daewqd@naver.com �ȳ��ϼ��� abc@hong.co.kr";
	  //System.out.println("replace =>" +str.replace("0", "ȫ")); // 0�� ȫ���� �ٲ�
	  // ����ǥ����
	  // 1. ���� : goo.gl/HLntbd
	  // 2. ���� ����
	  //    \\ d(���ڿ� ��ġ, [0-9]�� ����)
	  //    \\ s(whitespacen : �����̽�, ��, ����)
	  //    \\ w(�����ڳ� ����, [a-zA-z0-9]�� ����)
	  //    \\ W(�����ڳ� ���ڰ� �ƴ� ����.)
	  //       . (���� �ϳ�)
	  //       + (1���̻� �ݺ�)
	  //       * (0���̻� �ݺ�)
	  //       ? (0-1�� �ݺ�)
	  // 3. ������ regexr.com
	  //  ex. ��ȭ ��ȣ ����ǥ������ ������ ����.
	  // .?([0-9]){2,3}.[0-9]{3,4}-[0-9]{4} ��ȭ��ȣ ����ǥ����
	  // [(]?[0-9][)]{2,3}.\D[0-9]{3,4}-[0-9]{4}
	  //      010            1111       1111
	  // 4. Ư�� ���� ǥ������ ���ڿ� ���� : replaceAll("����ǥ����", "��ü���ڿ�")
	  //    - \w+@\w+(.\w+){1,2} �̸��� ���� ǥ����
	
	  System.out.println(str.replaceAll(".?([0-9]){2,3}.[0-9]{3,4}-[0-9]{4}", "��ȭ��ȣ ����"));
	  // ��ȭ��ȣ �����
	  System.out.println(str.replaceAll("\\w+@\\w+(.\\w+){1,2}", "***�̸��� ���� ***"));
      // �̸��� ����
	  System.out.println(str.replaceAll("[a-zA-Z]", ""));
      // ���ĺ��� ����
	  System.out.println(str.replaceAll("[��-�R��-��]", ""));
      // �ѱ� ����
	  System.out.println(str.replaceAll("[0-9]{7}", "*******")); // {7} = 7�� �ݺ�
	  // �ֹι�ȣ ���ڸ� ����
	  
   }
}







