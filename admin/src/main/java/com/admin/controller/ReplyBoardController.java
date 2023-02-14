package com.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.dto.Cust;
import com.admin.dto.ReplyBoard;
import com.admin.service.ReplyBoardService;

@RestController
@RequestMapping("/board")
public class ReplyBoardController {
	
	@Autowired
	ReplyBoardService rbs;
	
	//댓글 삭제
	@RequestMapping("/commentDelete")
	public void deleteComment(int replyno) throws Exception{
		rbs.deleteComment(replyno);
	}
	

}
