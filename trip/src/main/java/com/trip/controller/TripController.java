package com.trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trip")
public class TripController {
	
	String dir = "trip/";
	
	@RequestMapping("/trip1")
	public String trip(Model model) {
		model.addAttribute("center", dir+"trip");
		return "index";
	}
	
	@RequestMapping("/food")
	public String food(Model model) {
		model.addAttribute("center", dir+"food");
		return "index";
	}
	
	@RequestMapping("/festival")
	public String festival(Model model) {
		model.addAttribute("center", dir+"festival");
		return "index";
	}
	
}
