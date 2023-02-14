package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.Board;
import com.admin.dto.Criteria;
import com.admin.mapper.BoardMapper;

@Service
public class BoardService{

	@Autowired
	BoardMapper bmp;

	//글 삭제
	public void deleteBoard(int postid) throws Exception {
		bmp.deleteBoard(postid);
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
	
	public List<Board> bList() throws Exception{
		return bmp.bList();
	}
}
