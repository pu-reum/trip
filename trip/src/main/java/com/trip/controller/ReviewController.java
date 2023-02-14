package com.trip.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.dto.Cust;
import com.trip.dto.Review;
import com.trip.service.ReviewService;

@RestController
@RequestMapping("/trip")
public class ReviewController {
	 
	@Autowired
	ReviewService rs;
	
	String dir="placedetail/";
	
	@RequestMapping("/placedetail/commentWrite")
	public String writecomment(Review review, HttpSession session, Model model) throws Exception {
		Cust cust=(Cust) session.getAttribute("logincust");
		review.setCustid(cust.getCustid());	
		
		rs.insertReview(review);
		
		model.addAttribute("center",dir+"trip/placedetail");
		String result="redirect:/trip/placedetail?pdid="+review.getPdid();
		return result;
		
	}
	
	//삭제
	@RequestMapping("/placedetail/commentDelete")
	public void deleteComment(int rid) throws Exception{
		rs.deleteComment(rid);
	}
}
