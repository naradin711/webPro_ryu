package com.lec.ex2_human.main;
import com.lec.ex2_human.*;// com.lec.ex2_human. ���� ���� ��Ű���� ��� class�� 
                           // ���ʿ��� package Import ���� : ctrl+shift+o
public class Testmain {
   public static void main(String[] args) {
	  int i = 10;
	  int j = 10;
	  System.out.println(i==j ? "����." : "�ٸ���.");
	  if(i==j) {
		  System.out.println("i�� j�� ����.");  
	  }else {
		  System.out.println("i�� j�� �ٸ���.");
	  }
	  String name = "ȫ�浿";
	  String name2 = "��浿";
	  if(name.equals(name2)) { //if(name==name2) {
		 System.out.println("����."); 
	  }else {
		  System.out.println("�ٸ���.");
	  }
	  Woman hee1 = new Woman();
	  Woman hee2 = new Woman();
	  if(hee1.equals(hee2)) { // ��ü ������ ������ �񱳽� equals ���.
	 //if(name==name2) 
			 System.out.println("hee1�� hee2�� ����."); 
	  }else {
			  System.out.println("hee1�� hee2�� �ٸ���.");
	  }
	  Man kang = new Man(33,168,119.1);
	  Man kim =  new Man(22,180,72.3);
	  Man kim1; // ���۷��� ���� ����
	  kim1 = kim;
	  Man kim2 = new Man(22,180,72.3); // ������ ������ �ּҰ� �ٸ��⿡ ���� �ٸ� ������� �ν���.
	  if (kim.equals(kim1)) {
		  System.out.println("����."); // ���� �ּҸ� ����Ų��.
	  }
	  if (kim.equals(kim2)) {
		  System.out.println("����."); // ���� �ּҰ��� ���Ѵ�.
	  }else {
		  System.out.println("�ٸ���."); // �ٸ� �ּҰ��� �ִ�.
	  }
	  if (!kim.equals(kim2)) {
		  System.out.println("�ٸ���."); // �ٸ� �ּҰ��� �ִ�.
	  }
	  kang.setHeight(170);
	  kang.setWeight(51.89); // ������ �ᵵ �������� ����ȯ double -> int �� �ڵ����� �ν�. �ݴ�� �ȵ�.
	  if(kang.calculateBMI()>30) {
		  System.out.println("�ǰ��ϼ���...");
	  }else {
		  System.out.println("�ǰ��Ͻðڳ׿�?");
	  }
 }
}
