package com.lec.todayquiz;

public abstract class SalaryTestMain {
	public static void main(String[] args) {
	   Employee [] sawon = {new SalaryEmployee("���켺", 25000000),
			               new SalaryEmployee("������", 17000000),
			               new SalaryEmployee("�����", 50000000),
			               new HourlyEmployee("���̼�", 100, 7000),
			               new HourlyEmployee("�ֿ��", 120, 8000)};
	   for(Employee temp : sawon) {
		      System.out.println("~~~~~���޸���~~~~~");
		      System.out.println("�� �� : "+temp.getName());
		      System.out.println("�� �� : "+temp.computePay()+"��");
	          int incen = temp.computeIncentive();
	          if(incen !=0) {
	        	 System.out.println("�� ��  : " +incen+"��");
	          }
	   }
						 
	}

}
