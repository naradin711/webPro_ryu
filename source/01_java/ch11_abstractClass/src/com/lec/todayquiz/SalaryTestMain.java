package com.lec.todayquiz;

public abstract class SalaryTestMain {
	public static void main(String[] args) {
	   Employee [] sawon = {new SalaryEmployee("정우성", 25000000),
			               new SalaryEmployee("강동원", 17000000),
			               new SalaryEmployee("김고은", 50000000),
			               new HourlyEmployee("조이서", 100, 7000),
			               new HourlyEmployee("최우식", 120, 8000)};
	   for(Employee temp : sawon) {
		      System.out.println("~~~~~월급명세서~~~~~");
		      System.out.println("성 함 : "+temp.getName());
		      System.out.println("월 급 : "+temp.computePay()+"원");
	          int incen = temp.computeIncentive();
	          if(incen !=0) {
	        	 System.out.println("상 여  : " +incen+"원");
	          }
	   }
						 
	}

}
