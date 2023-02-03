package com.trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/index")
	public String main() {
		return "index";
	}
	
	
	
	@RequestMapping("/course/course1")
	public String course1(Model model) {
		model.addAttribute("center", "course/course1");
		return "index";
	}
	
	@RequestMapping("/course/course2")
	public String course2(Model model) {
		model.addAttribute("center", "course/course2");
		return "index";
	}
	
	@RequestMapping("/course/course3")
	public String course3(Model model) {
		model.addAttribute("center", "course/course3");
		return "index";
	}
	
	@RequestMapping("/course/course4")
	public String course4(Model model) {
		model.addAttribute("center", "course/course4");
		return "index";
	}
	
	@RequestMapping("/course/course5")
	public String course5(Model model) {
		model.addAttribute("center", "course/course5");
		return "index";
	}
	
	@RequestMapping("/course/course6")
	public String course6(Model model) {
		model.addAttribute("center", "course/course6");
		return "index";
	}
}
