package com.trip.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.trip.dto.Board;
import com.trip.dto.Cust;
import com.trip.dto.Wishlist;
import com.trip.service.WishlistService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@RequestMapping("/mypage")
public class WishlistController {

	private final WishlistService wishlistService;
	
//	@GetMapping("/wishlist")
	@GetMapping("/wishlist")
	public String wishlist(Model model, HttpSession session) throws Exception{
		
		Cust cust = (Cust) session.getAttribute("logincust");
		List <Wishlist> list = wishlistService.getWishlistAllList(cust.getCustid());
		model.addAttribute("wishlist", list);
		model.addAttribute("center", "mypage/wishlist");
		return "index";
	}
	
//	@PostMapping("/addWishlist")
	@PostMapping("/addWishlist")
	@ResponseBody
//	public int addWishlist(Model model, @SessionAttribute(required = false ,  value= "logincust") Cust cust) throws Exception{
	public int addWishlist(@RequestBody Wishlist wishlist, Model model, HttpSession session) throws Exception{
		
		
//		System.out.println(model);
		int result = 0;
		
		Cust cust = (Cust) session.getAttribute("logincust");
		System.out.println(cust);
		
		if(cust != null) {
			wishlist.setCustid(cust.getCustid());
			wishlistService.addWishlist(wishlist);
			result = 1;
		}
		
		model.addAttribute("wishlist", wishlist);
		return result;
	}
	
	@DeleteMapping("/delWishlist")
	@ResponseBody
	public void deleteByPdid(@RequestBody int pdid, @SessionAttribute(required = false ,  value= "logincust") Cust cust) {
		wishlistService.deleteByPdid(pdid);
	}
	
	
	
}
