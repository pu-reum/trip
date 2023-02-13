package com.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admin.dto.Criteria;
import com.admin.dto.Cust;
import com.admin.dto.Inquiry;
import com.admin.dto.Page;
import com.admin.service.InquiryService;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

	String dir = "inquiry/";

	@Autowired
	InquiryService is;

	// 목록
	@RequestMapping("")
	public String inquiry(Criteria criteria, Model model, HttpSession session) throws Exception {

		// 글 목록
		List<Inquiry> list=null;
		if(session.getAttribute("loginAdmin")!=null) {
			try {
				list = is.selectInquiryList(criteria);
				model.addAttribute("list", list);
				model.addAttribute("pageMaker", new Page(is.getTotalData(), 5, criteria));
				model.addAttribute("center", dir + "inquiry");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			model.addAttribute("center",dir+"access-limit");
		}
		
		
		
		return "index";
	}

	// 글수정 완료
	@RequestMapping("/inquiryeditok")
	public String inquiryeditok(Model model,Inquiry inquiry) throws Exception {
			
				is.updeateInquiry(inquiry);
				model.addAttribute("result", inquiry);

		return "redirect:/inquiry";

	}

	// 글 상세보기
	@GetMapping("/inquiryview")
	public String inquiryview(Model model, int inquiryid) throws Exception {

		Inquiry inquiry = is.selectInquiry(inquiryid);
		model.addAttribute("inquiry", inquiry);
		model.addAttribute("center", dir + "inquiryview");
		return "index";
	}

	// 글 삭제
	@RequestMapping("/inquirydelete")
	public String inquirydelete(int inquiryid) throws Exception {
		is.deleteInquiry(inquiryid);

		return "redirect:/inquiry";
	}

}