package com.lec.ex01_List;
import java.util.*;
import com.lec.ex02_Map.Friend;
public class Ex04_FriendArrayList {
	public static void main(String[] args) {
		Friend [] friends = new Friend [5];
		friends [0] = new Friend("ȫ", "010-9999-9999");
		friends [1] = new Friend("��", "010-8888-8888");
		for(int i=0 ; i<friends.length ; i++) {
			System.out.println(friends[i]);
		}
             /**ArrayList : index�� �ְ�, �ߺ��� ����**/
		ArrayList<Friend> fs = new ArrayList<Friend>();	
		fs.add(new Friend("ȫ", "010-9999-9999")); // 0�� �ε���
		fs.add(new Friend("��", "010-8888-8888")); // 1�� �ε���
		Friend temp = new Friend ("��", "010-7777-7777", new Date(91, 6, 6) );
		fs.add(temp);//2�� �ε���
		for(int i=0 ; i<fs.size() ; i++) {
			System.out.println(fs.get(i));
		}
		
	}
}
