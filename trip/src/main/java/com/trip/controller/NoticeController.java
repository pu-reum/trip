package com.trip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trip.dto.Criteria;
import com.trip.dto.Notice;
import com.trip.dto.Page;
import com.trip.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	String dir = "notice/";
	
	@Autowired
	NoticeService ns;
	
	//공지 글 리스트
	@RequestMapping("")
	public String notice(Criteria criteria, Model model) throws Exception {
		//log.info("list");
		System.out.println(criteria);
		List<Notice> list = ns.selectNoticeList(criteria);
		model.addAttribute("list", list);
		System.out.println(list);
		System.out.println(new Page(ns.getTotalData(), 5, criteria));
		model.addAttribute("pageMaker", new Page(ns.getTotalData(), 5, criteria));
		model.addAttribute("center", dir+"notice");
		return "index";
	}
	
	//글 상세보기
	@GetMapping("/noticeview")
	public String noticeview(Integer noid, Model model) throws Exception {
		Notice notice = ns.selectNotice(noid);
		//model.addAttribute("notice", ns.selectNotice(noid));
		model.addAttribute("notice", notice);
		model.addAttribute("center", dir+"noticeview");
		return "noticeview";
	}
}
