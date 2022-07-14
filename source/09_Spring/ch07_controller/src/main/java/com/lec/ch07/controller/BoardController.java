package com.lec.ch07.controller;
 
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch07.dto.Member;

@Controller
@RequestMapping("board/") //공통경로
public class BoardController {
	 @RequestMapping("write")// 조합된 요청경로 : board/write
	 //메소드
	 public String write() {
		 return "board/write"; // 뷰 : /WEB-INF/views/content.jsp
	 }
	  @RequestMapping(value="content", method=RequestMethod.GET)
	  public String content(Model model/*, HttpServletRequest request */ ) {
		  // request.setAttribute("id", "aaa");
		  	model.addAttribute("id", "aaa");
		  	model.addAttribute("pw", "111");
		  	Member member = new Member("bbb", "222");
		  	model.addAttribute("member", member);
			return "board/content"; // 뷰 : /WEB-INF/views/content.jsp
	  }
	 @RequestMapping(value="list", method=RequestMethod.GET)
	 //메소드
	 public ModelAndView list() {
		 ModelAndView mav = new ModelAndView();
		 Member member = new Member("ccc", "333");
		 ArrayList<Member> list = new ArrayList<Member>();
		 list.add(member);
		 mav.addObject("list", list);
		 mav.setViewName("board/list");
		 return mav;
		 
	 }
	 @RequestMapping(value="reply", method=RequestMethod.GET)
	 
	 //메소드
	 public ModelAndView reply (ModelAndView mav) {
		 Member member = new Member("ddd", "333");
		 mav.addObject("member", member);
		 mav.setViewName("board/reply");
		 return mav;
	 }

}

















