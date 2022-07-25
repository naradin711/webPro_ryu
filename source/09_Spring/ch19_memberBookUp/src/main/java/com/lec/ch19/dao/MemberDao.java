package com.lec.ch19.dao;
 

import com.lec.ch19.dto.MemberDto;
 
 
public interface MemberDao {
	public int idConfirm(String mid);
	public int joinMember(MemberDto memberDto); 
	public MemberDto getDetailMember(String mid);  
	public int modifyMember(MemberDto memberDto);
	
}
