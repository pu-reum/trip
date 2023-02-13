package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admin.dto.Board;
import com.admin.dto.Criteria;
import com.admin.dto.Page;
import com.admin.dto.ReplyBoard;
import com.admin.service.BoardService;
import com.admin.service.ReplyBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	String dir = "board/";
	
	@Autowired
	BoardService bs;
	
	@Autowired
	ReplyBoardService rbs;
	
	//목록
	@RequestMapping("")
	public String board(Model model, Criteria criteria) throws Exception {
		
		//글 목록
		List <Board> list = bs.selectBoardList(criteria);
		model.addAttribute("list", list);
		System.out.println(list);
		model.addAttribute("pageMaker", new Page(bs.getTotalData(), 5, criteria));
		//bs.categoryEnum(board);
		model.addAttribute("center", dir+"board");
		return "index";
	}
	//글 상세보기
	@GetMapping("/boardview")
	public String boardview(Model model, int postid)throws Exception {
		
		Board board=bs.selectBoard(postid);
		model.addAttribute("board", board);
		
		//댓글 조회
		List<ReplyBoard> reply = rbs.selectCommentList(postid);
		model.addAttribute("reply", reply);
		
		System.out.println(reply);
		model.addAttribute("center", dir+"boardview");
		return "index";
	}

	//글 삭제
	@RequestMapping("/boarddelete")
	public String boarddelete(int postid) throws Exception {
		bs.deleteBoard(postid);
		return "redirect:/board";
	}
	
}
