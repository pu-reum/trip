package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.ReplyBoard;
import com.admin.mapper.ReplyBoardMapper;

@Service
public class ReplyBoardService {
	
	@Autowired
	ReplyBoardMapper rbm;
	
	
	
	//댓글 목록
	public List<ReplyBoard> selectCommentList(int postid) throws Exception{
		return rbm.selectCommentList(postid);
	}
	
	//댓글 삭제
	public void deleteComment(int replyno) throws Exception{
		rbm.deleteComment(replyno);
	}
}
