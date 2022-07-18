package com.lec.ch11.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
// mvcboard/list.do, mvcboard/write.do, mvcboard/content.do ...
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch11.bservice.BDeleteService;
import com.lec.ch11.bservice.BModifyReplyViewService;
import com.lec.ch11.bservice.BReplyService;
import com.lec.ch11.bservice.BcontentService;
import com.lec.ch11.bservice.BlistService;
import com.lec.ch11.bservice.BmodifyService;
import com.lec.ch11.bservice.BwriteService;
import com.lec.ch11.bservice.Service;
import com.lec.ch11.dto.BoardDto;
		
@Controller
@RequestMapping("mvcboard")
public class BoardController {
	private Service bservice;
	@RequestMapping(value = "list", method = RequestMethod.GET )
	public String list(String pageNum, Model model) {
		// mvcboard/list.do?pageNum=2
		System.out.println(pageNum);
		model.addAttribute("pageNum", pageNum);
		bservice= new BlistService();
		bservice.execute(model);
		return "mvcboard/list";
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST )
	public String list_post(String pageNum, Model model) {
		// mvcboard/list.do?pageNum=2
		model.addAttribute("pageNum", pageNum);
		bservice= new BlistService();
		bservice.execute(model);
		return "mvcboard/list";
	}
	@RequestMapping(value = "writeView", method = RequestMethod.GET )
	public String writeView() {
		return "mvcboard/write_view";
	}
	@RequestMapping(value = "write", method = RequestMethod.POST )
	public String write(@ModelAttribute("bDto") BoardDto boardDto,
						HttpServletRequest reqeust, Model model) {
		model.addAttribute("request", reqeust);
		bservice = new BwriteService();
		bservice.execute(model);
		
		return "forward:list.do";
		
	}
	
	//@RequestMapping(value = "write" )
	
	@RequestMapping(value = "content", method = RequestMethod.GET )
	public String content (int bid, Model model) {
		model.addAttribute("bid", bid);
		bservice = new BcontentService();
		bservice.execute(model);
		return "mvcboard/content_view";
	}
	@RequestMapping(value = "content", method = RequestMethod.POST )
	public String content_post (int bid, Model model) {
		model.addAttribute("bid", bid);
		bservice = new BcontentService(); // 조회수 올림
		bservice.execute(model);
		return "mvcboard/content_view";
	}
	@RequestMapping(value = "modify", method = RequestMethod.GET )
	public String modifyView(int bid, Model model) {
		model.addAttribute("bid", bid);
		bservice = new BModifyReplyViewService(); // 조회수 올리지 않음
		bservice.execute(model);
		return "mvcboard/modify";
	}
	 
	@RequestMapping(value = "modify", method = RequestMethod.POST ) 
	public String modify(@ModelAttribute("bDto") BoardDto boardDto, 
			HttpServletRequest reqeust,  Model model) { 
		model.addAttribute("request", reqeust); 
		bservice = new BmodifyService(); 
		bservice.execute(model); 
		return "forward:content.do";
	   
	}
	@RequestMapping(value = "delete", method = RequestMethod.GET )
	public String delete(int bid, Model model) {
		model.addAttribute("bid", bid);
		bservice = new BDeleteService(); // 조회수 올리지 않음
		bservice.execute(model);
		return "forward:list.do";
	}
	@RequestMapping(value = "reply", method = RequestMethod.GET )
	public String reply (int bid, Model model) {
		model.addAttribute("bid", bid);
		bservice = new BModifyReplyViewService();
		bservice.execute(model);
		return "mvcboard/reply_view";
	}
	@RequestMapping(value = "reply", method = RequestMethod.POST )
	public String reply (@ModelAttribute("bDto") BoardDto boardDto, 
			HttpServletRequest reqeust,  Model model) {
		model.addAttribute("request", reqeust);
		bservice = new BReplyService();
		bservice.execute(model);
		return "forward:list.do";
	}

}
