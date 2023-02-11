package com.trip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trip.dto.Board;
import com.trip.dto.Criteria;
import com.trip.mapper.BoardMapper;

@Service
public class BoardService{

	@Autowired
	BoardMapper bmp;
	
	//글 작성
	public void insertBoard(Board board) throws Exception {
		//String catenum=bmp.categoryEnum(board);
		bmp.insertBoard(board);
	}

	//글 삭제
	public void deleteBoard(int postid, String custid) throws Exception {
		bmp.deleteBoard(postid, custid);
	}

	//글 수정
	public void updateBoard(Board board) throws Exception {
		bmp.updateBoard(board);
	}

	//글 상세 보기
	public Board selectBoard(int postid) throws Exception {
		bmp.updateHitCount(postid);
		
		Board board = bmp.selectBoard(postid);
		return board;
	}

	//글 목록
	public List<Board> selectBoardList(Criteria criteria) throws Exception {
		//String catenum=bmp.categoryEnum(board);
		
		return bmp.selectBoardList(criteria);
	}
	//페이지 네이션
	public int getTotalData() {
		return bmp.getTotalData();
	}
	
}
