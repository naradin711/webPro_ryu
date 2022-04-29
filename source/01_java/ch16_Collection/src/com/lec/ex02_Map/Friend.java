package com.lec.ex02_Map;
import java.text.SimpleDateFormat;
import java.util.Date;
// Friend f = new Friend ("ȫ", "010-9999-9999")
// sysout f ȫ�� ����ó 010-9999-9999, ���� : 04�� 14��
public class Friend {
   private String name;
   private String tel;
   private Date birth;
    public Friend(String name, String tel) {
	   super();
	   this.name = name;
	   this.tel = tel;
    }
    public Friend(String name, String tel, Date birth) {
	   super();
	   this.name = name;
	   this.tel = tel;
	   this.birth = birth;
    }
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("\t���� : MM�� dd�� \t");
		if(birth != null) {
			return  name + "�� ����ó = " + tel + ",\t" + sdf.format(birth);
		}else {
			return  name + "�� ����ó = " + tel;
		}// if else		
	}//toString 
}//class
