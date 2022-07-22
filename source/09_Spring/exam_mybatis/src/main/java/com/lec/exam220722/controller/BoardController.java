package com.lec.exam220722.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

 
import com.lec.exam220722.model.Board;
import com.lec.exam220722.service.BoardService;
import com.lec.exam220722.util.Paging;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping (value = "boardList", method = {RequestMethod.GET, RequestMethod.POST })
	public String boardList(String pageNum, Model model) {
		model.addAttribute("boardList", boardService.boardList(pageNum)  );
		model.addAttribute("paging", new Paging(boardService.totCnt(), pageNum, 5 , 5 ));
		return "list";
	}
	@RequestMapping (value ="detail1", method = RequestMethod.GET )
	public String detail1 (int bid, Model model) {
		boardService.hitup(bid);
		model.addAttribute("board", boardService.detail(bid));
		return "content_view";
	}
	@RequestMapping (value ="detail", method = RequestMethod.GET )
	public String detail (int bid, Model model) {
		model.addAttribute("board", boardService.detail(bid));
		return "content_view";
	}
	@RequestMapping(value = "modifyView" , method = {RequestMethod.GET, RequestMethod.POST})
	public String updateView(int bid, Model model) {
		model.addAttribute("board", boardService.detail(bid));
		return "modify";
	}
	@RequestMapping(value = "modify" , method = RequestMethod.POST)
	public String update(Board board, HttpServletRequest request, Model model) {
		board.setBip(request.getRemoteAddr());
		try {
			model.addAttribute("modifyResult", boardService.modify(board, request));
		} catch (Exception e) {
			model.addAttribute("modifyResult", "필드 값이 유효하지 않습니다.");
			return "forward:modifyView.do";
		} 
		return "forward:boardList.do";
	}
	@RequestMapping(value = "delete" , method = RequestMethod.GET)
	public String delete(int bid, Model model ) {
		model.addAttribute("deleteResult", boardService.delete(bid));
		return "forward:boardList.do";
	}
	@RequestMapping(value = "writeView" , method = {RequestMethod.GET, RequestMethod.POST})
	public String writeView( Model model) {
		 return "write_view";
	}
	@RequestMapping(value = "write" , method =  RequestMethod.POST) 
	public String write(Board board, HttpServletRequest request ,Model model) {  
		try {
			board.setBip(request.getRemoteAddr());
			model.addAttribute("writeResult", boardService.insert(board, request));
		} catch (Exception e) {
			model.addAttribute("writeResult", "필드 값이 유효하지 않습니다.");
			return "forward:writeView.do";
		} 
		return "forward:boardList.do";
	}
	@RequestMapping(value = "replyView" , method = {RequestMethod.GET, RequestMethod.POST})
	public String replyView(int bid, Model model) {
		 model.addAttribute("board", boardService.detail(bid));
		 return "reply_view";
	}
	@RequestMapping(value = "reply" , method =  RequestMethod.POST) 
	public String reply(Board board, HttpServletRequest request ,Model model) {  
		try { 
			board.setBip(request.getRemoteAddr());
			model.addAttribute("replyResult", boardService.reply(board, request));
		} catch (Exception e) {
			model.addAttribute("replyResult", "필드 값이 유효하지 않습니다.");
			return "forward:replyView.do";
		} 
		return "forward:boardList.do";
	}

}
