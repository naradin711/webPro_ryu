package com.lec.exam220722.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.exam220722.dao.BoardDao;
import com.lec.exam220722.model.Board;
import com.lec.exam220722.util.Paging;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Board> boardList(String pageNum) {
		Paging paging = new Paging(boardDao.totCnt(), pageNum, 5 ,5);
		Board board = new Board();
		board.setStartRow(paging.getStartRow());
		board.setEndRow(paging.getEndRow());
		return boardDao.boardList(board) ;
	}

	@Override
	public int totCnt() { 
		return boardDao.totCnt();
	}

	@Override
	public Board detail(int bid) {
		// TODO Auto-generated method stub
		return boardDao.detail(bid);
	}

	@Override
	public int hitup(int bid) {
		// TODO Auto-generated method stub
		return boardDao.hitup(bid) ;
	}
 
	@Override 
	public int reply(Board board, HttpServletRequest request) {  
		return boardDao.reply(board)  ;
	}

	@Override
	public int insert(Board board, HttpServletRequest request) {
		
		return boardDao.insert(board);
	}

	@Override
	public int modify(Board board, HttpServletRequest request) { 
		return boardDao.modify(board);
	}

	@Override
	public int delete(int bid) { 
		return boardDao.delete(bid);
	}
 
 

}
