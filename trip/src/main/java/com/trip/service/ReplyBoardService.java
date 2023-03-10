package com.trip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trip.dto.ReplyBoard;
import com.trip.mapper.ReplyBoardMapper;

@Service
public class ReplyBoardService {
	
	@Autowired
	ReplyBoardMapper rbm;
	
	
	//댓글 작성
	public void insertComment(ReplyBoard rBoard) throws Exception{
		rbm.insertComment(rBoard);
	}
	//댓글 목록
	public List<ReplyBoard> selectCommentList(int postid) throws Exception{
		return rbm.selectCommentList(postid);
	}
//	//댓글 수정
//	public void updateComment(ReplyBoard rBoard) throws Exception{
//		rbm.updateComment(rBoard);
//	}
	//댓글 삭제
	public void deleteComment(int replyno) throws Exception{
		rbm.deleteComment(replyno);
	}
}
