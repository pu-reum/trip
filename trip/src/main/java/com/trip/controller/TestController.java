package com.trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	
	@RequestMapping("/map")
	public String map(Model model) {
		
		model.addAttribute("center", "map");
		return "index";
	}
	
}
