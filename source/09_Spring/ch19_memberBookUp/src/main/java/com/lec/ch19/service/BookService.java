package com.lec.ch19.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dto.BookDto;
@Service
public interface BookService {
	public List<BookDto> mainList();
	public List<BookDto> bookList(String pageNum, BookDto bookDto);
	public int totCntBook(BookDto bookDto);
	public BookDto getDetailBook(int bnum);
	public int registerBook(MultipartHttpServletRequest mRequest, BookDto bookDto);
	public int modifyBook(BookDto bookDto, MultipartHttpServletRequest mRequest);
}
