package com.lec.ex02_date;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.lec.quiz01.Friend;
public class Ex06_FriendSimpleDateFormat {
// �˻��� ��ȭ��ȣ ���ڸ��� �Է¹޾� => �ý������� ���� �ð��� �Է¹޾� "MM-dd" ��Ÿ���� String���� ��ȯ
// 0~������� �ش� ��ȭ��ȣ�� ������ ��� => 0~������ �ش� ���ϰ� ������ ��ȯ�� ��Ʈ���� ������ ���
// �˻��� ���� �ʾ� ��� ���ϸ� ���ٶ�� ��� => �ش� �����ڰ� ������ �ش��ϴ� ����� �����ϴ� ���
	public static void main(String[] args) {
		Friend [] friends = { new Friend ("������", "010-1122-0211", "02-11"),
	                          new Friend ("������", "010-1122-0211", "02-16"),
	                          new Friend ("�����", "010-9876-0256", "03-28"),
	                          new Friend ("������", "010-3242-1119", "03-28")};
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        String today = sdf.format(date); 
        boolean sOk = false;
	    for(Friend f : friends) {
	    	String bDay = f.getBday(); // �ش� ��°�� ��ü ���ϰ��� ����.
	    	if(bDay.equals(today)) {
	    		System.out.println(f);
	    		sOk = true;
	    	}// if �ش� �����ڸ� ���
	    }//for
	    if(!sOk) {
		System.out.println("���� ������ ģ���� �����ϴ�.");
	}
  }
}
