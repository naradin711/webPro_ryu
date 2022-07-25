package com.lec.ch19.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dto.BookDto;
@Service
public interface BookService {
	public List<BookDto> mainList();
	public List<BookDto> bookList(String pageNum);
	public int totCntBook();
	public BookDto getDetailBook(int bnum);
	public int registerBook(BookDto bookDto, MultipartHttpServletRequest mRequest);
	public int modifyBook(BookDto bookDto, MultipartHttpServletRequest mRequest);
}
