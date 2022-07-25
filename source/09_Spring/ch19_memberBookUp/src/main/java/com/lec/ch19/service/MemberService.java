package com.lec.ch19.service;

import javax.servlet.http.HttpSession;
 
import org.springframework.stereotype.Service;

import com.lec.ch19.dto.MemberDto;

@Service
public interface MemberService {
	public int idConfirm(String mid);
	public int joinMember(MemberDto memberDto, HttpSession httpSession);
	public String loginCheck(String mid, String mpw, HttpSession httpSession);
	public MemberDto getDetailMember(String mid);  
	public int modifyMember(MemberDto memberDto);
}
