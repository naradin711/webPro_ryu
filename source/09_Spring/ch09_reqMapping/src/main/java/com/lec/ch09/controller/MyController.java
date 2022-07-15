package com.lec.ch09.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class MyController {
	@RequestMapping(value="main.do", method= RequestMethod.GET)
	public String main () {
		return "main";
	}
	@RequestMapping(value="student.do", method = RequestMethod.GET )
	public String student (String id, Model model ) { 
		model.addAttribute("method", "GET");
		model.addAttribute("id", id);
		return "studentId";
	}
	@RequestMapping(value="student.do", method = RequestMethod.POST )
	public ModelAndView student (String id, ModelAndView mav) { 
		mav.addObject("method", "POST");
		mav.addObject("id", id);
		mav.setViewName("studentId");
		return mav;
	}
	@RequestMapping(value="idConfirm.do", method = RequestMethod.GET )
	public String idConfirm (String id, Model model ) { 
		model.addAttribute("method", "GET");
		model.addAttribute("id", id);
		if(id.equals("aaa")) {
			return "forward:studentOk.do";
			//return "redirect:studentOk.do";
		}
		return "redirect:studentNG.do?id="+id;
	}
	
	@RequestMapping(value="studentOk.do", method = RequestMethod.GET)
	public String studentOk () {
		return "studentOk";
	}
	
	@RequestMapping(value="studentNG.do", method = RequestMethod.GET )
	public String studentNG (String id) {
		return "studentNG";
	}
	@RequestMapping(value="fullPath.do", method = RequestMethod.GET )
	public String fullpath () {
		return "redirect:http://www.naver.com";
	}
	
	
	
}





















