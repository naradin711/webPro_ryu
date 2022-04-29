package com.lec.ex02_date;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.lec.quiz01.Friend;
public class Ex06_FriendSimpleDateFormat {
// 검색할 전화번호 뒷자리를 입력받아 => 시스템으로 부터 시간을 입력받아 "MM-dd" 스타일의 String으로 변환
// 0~끝방까지 해당 전화번호가 있으면 출력 => 0~끝까지 해당 생일과 위에서 변환한 스트링이 같으면 출력
// 검색이 되지 않아 출력 못하면 없다라고 출력 => 해당 생일자가 없으면 해당하는 사람이 없습니다 출력
	public static void main(String[] args) {
		Friend [] friends = { new Friend ("서지수", "010-1122-0211", "02-11"),
	                          new Friend ("서지안", "010-1122-0211", "02-16"),
	                          new Friend ("정희원", "010-9876-0256", "03-28"),
	                          new Friend ("류수정", "010-3242-1119", "03-28")};
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        String today = sdf.format(date); 
        boolean sOk = false;
	    for(Friend f : friends) {
	    	String bDay = f.getBday(); // 해당 번째의 객체 생일값을 얻음.
	    	if(bDay.equals(today)) {
	    		System.out.println(f);
	    		sOk = true;
	    	}// if 해당 생일자만 출력
	    }//for
	    if(!sOk) {
		System.out.println("오늘 생일인 친구는 없습니다.");
	}
  }
}
