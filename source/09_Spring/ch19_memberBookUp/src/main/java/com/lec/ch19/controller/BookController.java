package com.lec.ch19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch19.dto.BookDto;
import com.lec.ch19.service.BookService;
import com.lec.ch19.util.Paging;

@Controller
@RequestMapping (value = "book")
public class BookController {
	@Autowired
	private BookService bookService;
	@RequestMapping(params = "method=bookList", method = {RequestMethod.POST, RequestMethod.GET})
	public String bookList(String pageNum, Model model, BookDto bookDto ) {
		model.addAttribute("bookList", bookService.bookList(pageNum, bookDto));
		model.addAttribute("paging", new Paging(bookService.totCntBook(bookDto), pageNum, 3, 3));
		return "book/bookList";
	}
	@RequestMapping (params = "method=getDetailBook", method = RequestMethod.GET)
	public String getDetailBook (int bnum, Model model) {
		model.addAttribute("bookDto", bookService.getDetailBook(bnum));
		return "book/getDetailBook";
	}
	@RequestMapping (params = "method=registerForm" , method = {RequestMethod.POST, RequestMethod.GET} )
	public String registerForm () {
		
		return "book/registerForm";
	}
	@RequestMapping(params = "method=registerBook" , method = RequestMethod.POST)
	 
	public String registerBook(MultipartHttpServletRequest mRequest, BookDto bookDto, Model model) {
		model.addAttribute("registerResult", bookService.registerBook(mRequest, bookDto));
		return "redirect:book.do?method=bookList";
	}
	@RequestMapping (params = "method=modifyBookForm" , method = {RequestMethod.POST, RequestMethod.GET} )
	public String modifyBookForm () {
		
		return "book/modifyBookForm";
	}
	@RequestMapping(params = "method=modifyBook" , method = RequestMethod.POST)
	public String modifyBook(BookDto bookDto , Model model, MultipartHttpServletRequest mRequest) { 
		try {
			model.addAttribute("modifyResult", bookService.modifyBook(bookDto, mRequest));
		} catch (Exception e) {
			model.addAttribute("modifyResult", "필드 값이 유효하지 않습니다.");
			return "forward:book.do?method=modifyBookForm";
		} 
		return "forward:book.do?method=bookList";
	}
	
	

}
