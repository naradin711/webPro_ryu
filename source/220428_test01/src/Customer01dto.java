
public class Customer01dto {
	private String pno;
	private String cname;
	private int cpoint;
	
	public Customer01dto(String pno, String cname, int cpoint) {
		super();
		this.pno = pno;
		this.cname = cname;
		this.cpoint = cpoint;
	}
	
	

	@Override
	public String toString() {
		return pno+"\t"+cname +"\t"+cpoint;
	}



	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCpoint() {
		return cpoint;
	}

	public void setCpoint(int cpoint) {
		this.cpoint = cpoint;
	}
	
	
	
	
}
