package com.trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MypageController {

	String dir = "mypage/";
	
	@RequestMapping("/calendar")
	public String calendar(Model model) {
		model.addAttribute("center", dir+"calendar");
		return "index";
	}
	
	@RequestMapping("/useredit")
	public String useredit(Model model) {
		model.addAttribute("center", dir+"useredit");
		return "index";
	}

	
	@RequestMapping("/wishlist")
	public String wishlist(Model model) {
		model.addAttribute("center", dir+"wishlist");
		return "index";
	}
	
}
