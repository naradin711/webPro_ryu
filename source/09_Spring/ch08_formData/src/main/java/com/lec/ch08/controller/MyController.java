package com.lec.ch08.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	@ModelAttribute("cnt")
	public int cnt() { //cnt 값 5로 지정
		return 5;
	}
	@ModelAttribute("list")
	public ArrayList<String> list(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("test1"); list.add("test2");
		return list;
	}
	
	@RequestMapping(value="/")
	public String input() {
		return "member/input";
	}
//	@RequestMapping(value="studentId/*")
//	public String studentId(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
//		String uri = request.getRequestURI();// /ch08/stduentID/aaa
//		String id = uri.substring(uri.lastIndexOf("/")+1);
//		id = URLDecoder.decode(id, "utf-8");
//		model.addAttribute("id", id);
//		return "studentId";
//		 
//	}
	@RequestMapping(value="studentId/{id}")
	public String studentId(@PathVariable("id") String id , Model model ) { 
		model.addAttribute("id", id);
		return "studentId";
	}
	
}






















