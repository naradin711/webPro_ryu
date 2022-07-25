package com.lec.ch19.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
 
import com.lec.ch19.dto.BookDto;
 

@Mapper
public interface BookDao {
	public List<BookDto> mainList(BookDto bookDto);
	public List<BookDto> bookList(BookDto bookDto);
	public int totCntBook();
	public BookDto getDetailBook(int bnum);
	public int registerBook(BookDto bookDto);
	public int modifyBook(BookDto bookDto);
	
	
}
