package strategy03.academy.modulization;

import strategy03.academy.interfaces.*;

public class Staff extends Person {
    private String department;
	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;	
		setJob(new JobMng());
		setGet(new GetSalary());
	}
    public void print () {
    	System.out.println(getId() +"\t" +getName() + "\t" + department); 
    }
}
