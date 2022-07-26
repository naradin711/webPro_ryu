package com.lec.ch19.controller;
 
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch19.dto.MemberDto;
import com.lec.ch19.service.MemberService;

@Controller
@RequestMapping (value = "member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	@RequestMapping( params = "method=idConfirm" , method = RequestMethod.GET )
	public String idConfirm (String mid ) {
		
		return "forward:member.do?method=joinForm";
	}
	@RequestMapping( params = "method=joinForm" , method = RequestMethod.GET )
	public String joinForm () {
		
		return "member/joinForm";
	}
	@RequestMapping (params = "method=joinMember", method = {RequestMethod.GET, RequestMethod.POST})
	public String joinMember (MemberDto memberDto, Model model,HttpSession httpSession ) {
		model.addAttribute("joinResult", memberService.joinMember(memberDto, httpSession));
		System.out.println("join 완료");
		return  "member/loginForm";
	}
	
	@RequestMapping( params = "method=loginForm" , method = RequestMethod.GET )
	public String loginForm () {
		
		return "member/loginForm";
	}
	@RequestMapping (params = "method=loginCheck", method = RequestMethod.POST)
	public String loginCheck (String mid, String mpw, Model model, HttpSession httpSession ) {
		try {
			model.addAttribute("loginResult", memberService.loginCheck(mid, mpw, httpSession));
		} catch (Exception e) {
			model.addAttribute("loginResult", "필드 값이 유효하지 않습니다.");
			return "forward:member.do?method=loginCheck";
		}
		return  "forward:main.do";
	}
	@RequestMapping( params = "method=modifyForm" , method = RequestMethod.GET )
	public String modifyForm (String mid, Model model) {
		model.addAttribute("memberDto", memberService.getDetailMember(mid));
		return "member/modifyForm";
	}
	@RequestMapping (params = "method=modifyMember", method = RequestMethod.POST)
	public String modifyMember (MemberDto memberDto, Model model) {
		try {
			model.addAttribute("modifyResult", memberService.modifyMember(memberDto));
		} catch (Exception e) {
			model.addAttribute("modifyResult", "필드 값이 유효하지 않습니다.");
			return "forward:member.do?method=modifyForm";
		}
		return  "forward:main.do";
	}
	@RequestMapping( params = "method=logout" , method = RequestMethod.GET )
	public String logout (HttpSession session) { 
		session.invalidate(); 
		return "forward:main.do";
	}
	
	
	
	

}
