package com.trip.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.dto.Cust;
import com.trip.dto.ReplyBoard;
import com.trip.service.BoardService;
import com.trip.service.ReplyBoardService;

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
