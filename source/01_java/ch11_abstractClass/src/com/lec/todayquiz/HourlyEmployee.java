package com.lec.todayquiz;

public class HourlyEmployee extends Employee {
   private int hoursWorked;
   private int moneyPerHour;
   public HourlyEmployee() {}
   public HourlyEmployee(String name, int hoursWorked, int moneyPerHour) {
	   super(name);
	  this.hoursWorked = hoursWorked;
	  this.moneyPerHour = moneyPerHour;
   }
	public int computePay() {
       return hoursWorked * moneyPerHour;	
	}
	public int getHoursWorked() {
		return hoursWorked;
	}
	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	public int getMoneyPerHour() {
		return moneyPerHour;
	}
	public void setMoneyPerHour(int moneyPerHour) {
		this.moneyPerHour = moneyPerHour;
	}  
   
}
