package com.lec.exam220722.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.exam220722.model.Board;

@Mapper
public interface BoardDao {
	public List<Board> boardList(Board board);
	public int totCnt();
	public Board detail(int bid);
	public int hitup(int bid);
	public int stepA(Board board);
	public int reply(Board board);
	public int insert(Board board);
	public int modify(Board board);
	public int delete(int bid);
}
