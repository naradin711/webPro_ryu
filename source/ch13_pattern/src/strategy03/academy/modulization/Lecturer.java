package strategy03.academy.modulization;

import strategy03.academy.interfaces.*;

public class Lecturer extends Person {
    private String subject;
	public Lecturer(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;		
		setJob(new JobLec());
		setGet(new GetSalary());
	}
    public void print () {
    	System.out.println(getId() + "\t" + getName() + "\t" + subject); 
    }
}
