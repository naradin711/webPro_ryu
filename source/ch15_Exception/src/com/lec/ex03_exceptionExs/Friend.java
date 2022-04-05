package com.lec.ex03_exceptionExs;

import java.text.SimpleDateFormat;
// Friend f = new Friend("ȫ�浿", "010-9999-9999")
// Friend f = new Friend("ȫ�浿")
import java.util.Date;
public class Friend {
	private String name;
	private String tel;
	private Date enterDate;
	public Friend(String name) {
		this.name = name;
		enterDate = new Date();
	}
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
		enterDate = new Date();
	}
	@Override
	public String toString() {
		String telPost;                       
		if(tel!=null) {
			String post = tel.substring(tel.lastIndexOf('-')+1); 
			telPost = "***-****-" + post;
		}else {
			telPost = "����\t\t";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yy��M��d�� ģ����");
		//return "[�̸�]" + name + "\t[��ȭ]" + telPot + "\t[�Է���]" + sdf.format(enterDate);
		return String.format("[�̸�]%s\t[��ȭ]%s\t[�Է���]%s", name, telPost, sdf.format(enterDate));
	}
	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}
}



