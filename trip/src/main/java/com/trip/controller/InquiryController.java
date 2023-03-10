package com.trip.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trip.dto.Criteria;
import com.trip.dto.Cust;
import com.trip.dto.Inquiry;
import com.trip.dto.Page;
import com.trip.frame.ImgUtil;
import com.trip.service.InquiryService;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

	String dir = "inquiry/";

	@Autowired
	InquiryService is;
	
	@Value("${admindir}")
	String admindir;
	
	@Value("${custdir}")
	String custdir;

	// 목록
	@RequestMapping("")
	public String inquiry(Criteria criteria, Model model, HttpSession session) throws Exception {

		// 글 목록
		List<Inquiry> list = null;
		Cust cust = (Cust) session.getAttribute("logincust");
		if(cust != null) {
			list = is.selectInquiryList(criteria);
			model.addAttribute("list", list);
			model.addAttribute("pageMaker", new Page(is.getTotalData(), 5, criteria));
			model.addAttribute("center", dir + "inquiry");
		}else {
			model.addAttribute("center", dir + "access-limit");
		}
		
		return "index";
	}

	// 글 쓰기
	@GetMapping("/inquirywrite")
	public String inquirywrite(Model model) throws Exception {
		model.addAttribute("center", dir + "inquirywrite");

		return "index";
	}

	// 글쓰기 완료
	@PostMapping("/inquirywriteok")
	public String inquirywriteok(Inquiry inquiry, Model model, HttpSession session) throws Exception {
		Cust cust = (Cust) session.getAttribute("logincust");
		String file = inquiry.getImg().getOriginalFilename();
		System.out.println(file+"-----");
		
		if(file == null || file.equals("")) {
			inquiry.setCustid(cust.getCustid());
			is.insertInquiry(inquiry);
			model.addAttribute("result", inquiry);
		}else {
			
			try {
				inquiry.setCustid(cust.getCustid());
				inquiry.setFile(file);
				ImgUtil.saveFile(inquiry.getImg(), admindir, custdir);
				is.insertInquiry(inquiry);
				model.addAttribute("result", inquiry);
			}catch(Exception e) {
				e.printStackTrace();
				return "redirect:/inquirywrite";
			}

		}
		
		return "redirect:/inquiry";

	}

	// 글 수정
	@RequestMapping("/inquiryedit")
	public String inquiryedit(Model model,int inquiryid) throws Exception {
		Inquiry inquiry = is.selectInquiry(inquiryid);
		model.addAttribute("inquiry", inquiry);
		model.addAttribute("center", dir + "inquiryedit");
		
		return "index";
	}

	// 글수정 완료
	@PostMapping("/inquiryeditok")
	public String inquiryeditok(Inquiry inquiry, Model model, HttpSession session) throws Exception {
		Cust cust = (Cust) session.getAttribute("logincust");
		inquiry.setCustid(cust.getCustid());
		System.out.println(inquiry);
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
	public String inquirydelete(int inquiryid, HttpSession session) throws Exception {
		Cust cust = (Cust) session.getAttribute("logincust");
		is.deleteInquiry(inquiryid, cust.getCustid());

		return "redirect:/inquiry";
	}

}