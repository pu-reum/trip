package com.trip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trip.dto.Criteria;
import com.trip.dto.Page;
import com.trip.dto.Placedet;
import com.trip.service.PlacedetService;

@Controller
@RequestMapping("/trip")
public class TripController {
	
	String dir = "trip/";
	
	@Autowired
	PlacedetService pds;
	
	@RequestMapping("/trip")
	public String trip(Model model, Criteria criteria) throws Exception {
		
		List<Placedet> list = pds.selectPlaceList(criteria);
		model.addAttribute("list", list);
		System.out.println(list);
		model.addAttribute("pageMaker", new Page(pds.getTotalData(), 5, criteria));
		model.addAttribute("center", dir+"trip");
		return "index";
	}
	
	@RequestMapping("/placedetail")
	public String placeDetail(Model model, int pdid) throws Exception {
		
		Placedet place=pds.selectPlace(pdid);
		model.addAttribute("place", place);
		System.out.println(place);
		model.addAttribute("center", dir+"placedetail");
		return "index";
	}
	
}
