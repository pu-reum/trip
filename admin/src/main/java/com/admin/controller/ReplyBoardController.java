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
	
	@RequestMapping("/commentWrite")
	public String insertComment(ReplyBoard rBoard, HttpSession session) throws Exception{
		
		Cust cust=(Cust) session.getAttribute("logincust");
		rBoard.setCustid(cust.getCustid());
		
		rbs.insertComment(rBoard);
		
		return "redirect:/board/boardview?postid=" +rBoard.getPostid(); 
	}
	

}
