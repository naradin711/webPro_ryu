package com.lec.ex02_Map;
import java.text.SimpleDateFormat;
import java.util.Date;
// Friend f = new Friend ("全", "010-9999-9999")
// sysout f 全狼 楷遏贸 010-9999-9999, 积老 : 04岿 14老
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
		SimpleDateFormat sdf = new SimpleDateFormat("\t积老 : MM岿 dd老 \t");
		if(birth != null) {
			return  name + "狼 楷遏贸 = " + tel + ",\t" + sdf.format(birth);
		}else {
			return  name + "狼 楷遏贸 = " + tel;
		}// if else		
	}//toString 
}//class
