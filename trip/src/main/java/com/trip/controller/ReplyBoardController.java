package com.trip.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.dto.Cust;
import com.trip.dto.ReplyBoard;
import com.trip.service.ReplyBoardService;

@RestController
@RequestMapping("/board")
public class ReplyBoardController {
	
	@Autowired
	ReplyBoardService rbs;
	
	String dir="board/";
	
	@RequestMapping("/commentWrite")
	public String insertComment(ReplyBoard rBoard, HttpSession session, Model model) throws Exception{
		
		Cust cust=(Cust) session.getAttribute("logincust");
		rBoard.setCustid(cust.getCustid());
		
		rbs.insertComment(rBoard);
		
		model.addAttribute("center", dir+"boardview");
		model.addAttribute("board", rBoard.getPostid());
		//int no=rBoard.getPostid();
		//String result="redirect:/board/boardview?postid="+;
		//System.out.println("결과:"+result);
		return "redirect:/boardview";
	}
	
	//댓글 삭제
	@RequestMapping("/commentDelete")
	public void deleteComment(int replyno) throws Exception{
		rbs.deleteComment(replyno);
	}
	

}
