package com.lec.exam220722.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Mapper;

import com.lec.exam220722.model.Board;

@Mapper
public interface BoardService {
	public List<Board> boardList(String pageNum);
	public int totCnt();
	public Board detail(int bid);
	public int hitup(int bid); 
	public int reply(Board board, HttpServletRequest request);
	public int insert(Board board, HttpServletRequest request);
	public int modify(Board board, HttpServletRequest request);
	public int delete(int bid); 
}
