package com.trip.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trip.dto.Criteria;
import com.trip.dto.Page;
import com.trip.dto.Placedet;
import com.trip.dto.Review;
import com.trip.service.PlacedetService;
import com.trip.service.ReviewService;

@Controller
@RequestMapping("/trip")
public class TripController {
	
	String dir = "trip/";
	
	@Autowired
	PlacedetService pds;
	
	@Autowired
	ReviewService rs;
	
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
	public String placeDetail(Model model, int pdid, HttpSession session) throws Exception {
		
		Placedet place=pds.selectPlace(pdid);
		model.addAttribute("place", place);
		System.out.println(place);
		
//		Cust cust=(Cust) session.getAttribute("logincust");
//		String custid=cust.getCustid();
//		System.out.println(cust);
//		
//		Placedet heart=new Placedet();
//		heart = pds.findHeart(pdid, custid);
//		model.addAttribute("heart", heart);
		
		//리뷰 조회
		List<Review> review = rs.selectReviewList(pdid);
		model.addAttribute("review", review);
		
		model.addAttribute("center", dir+"placedetail");
		return "index";
	}
	
//	@RequestMapping(value="heart", method=RequestMethod.POST)
//	public @ResponseBody int pdlike(@ModelAttribute Placedet heart) throws Exception {
//		int result=pds.insertHeart(heart);
//		return result;
//	}
	
}
