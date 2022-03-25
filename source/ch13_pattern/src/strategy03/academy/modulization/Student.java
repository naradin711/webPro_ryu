package strategy03.academy.modulization;

import strategy03.academy.interfaces.*;

public class Student extends Person {
    private String ban;
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;	
		setJob(new JobStudy());
    	setGet(new GetStudentPay());
	}
    public void print () {
    	System.out.println(getId() + "\t" + getName() + "\t" + ban); 
    }
}
