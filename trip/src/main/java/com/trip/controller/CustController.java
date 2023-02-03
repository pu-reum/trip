package com.trip.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trip.dto.Cust;
import com.trip.service.CustService;
import com.trip.service.MailService;

@Controller
public class CustController {

	String dir = "cust/";
	
	@Autowired
	CustService service;
	
	@Autowired
	MailService mservice;
	
	@RequestMapping("/regist")
	public String regist(Model model) {
		model.addAttribute("center", dir+"regist");
		return "index";
	}
	
	@RequestMapping("/registimpl")
	public String registimpl(Model model, Cust cust, HttpSession session) {
		
		 try { 
			 	service.register(cust); 
			 	session.setAttribute("logincust", cust);
			 	model.addAttribute("msg", "회원가입되었습니다.");
			 }catch (Exception e) { 
				 model.addAttribute("msg", "회원가입 실패하였습니다.");
				 e.printStackTrace(); 
				 e.getStackTrace();
			 }
		
		return "index";
	}

	@RequestMapping("/useredit")
	public String useredit(Model model, String id) {
		Cust cust=new Cust();
		try {
			cust=service.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("editcust", cust);
		model.addAttribute("center", dir+"edit");
		return "index";
	}
	
	@RequestMapping("/usereditimpl")
	public String usereidtimpl(Model model, Cust cust, HttpSession session) {
		
		 try { 
			 	service.modify(cust); 
			 	session.setAttribute("logincust", cust);
			 	model.addAttribute("msg", "회원정보수정되었습니다.");
			 }catch (Exception e) { 
				 model.addAttribute("msg", "회원정보 수정 실패하였습니다.");
				 e.printStackTrace(); 
				 e.getStackTrace();
			 }
		
		return "index";
	}
	
	@RequestMapping("/loginimpl")
	public String loginimpl(String custid, String custpwd, HttpSession session, Model model) {
		Cust cust=null;

		try {
			cust=service.login(custid, custpwd);
			if(cust!=null) {
				session.setAttribute("logincust", cust);
				return "index";
			}else {
				model.addAttribute("msg", "아이디,비밀번호 오류입니다.");
				return "index";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "아이디,비밀번호 오류입니다.");
			return "index";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(Model model, HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@RequestMapping("/remove")
	public String remove(String id) {
		try {
			service.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/serchid")
	public String searchid(String custemail, Model model) {
		Cust cust=null;
		String subject="일상에서구조 사이트의 아이디 입니다.";
		try {
			cust=service.get3(custemail);
			if(cust!=null) {
				mservice.sendMail(custemail, cust.getCustid(), subject);
				model.addAttribute("msg", "email로 아이디를 보내드렸습니다.");
			}else {
				model.addAttribute("msg", "잘못된 email 입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "잘못된 email 입니다.");
		}
		
		return "index";
	}
	
	@RequestMapping("/serchpwd")
	public String searchpwd(String custid, String custemail, Model model) {
		Cust cust=null;
		StringBuffer key=new StringBuffer();
		Random rnd=new Random();
		for(int i=0;i<10;i++) {
			key.append((rnd.nextInt(10)));
		}
		String subject="일상에서구조 사이트의 임시 비밀번호입니다.";
		try {
			cust=service.searchPwd(custid, custemail);
			if(cust!=null) {
				mservice.sendMail(custemail, key.toString(), subject);
				model.addAttribute("msg", "email로 임시비밀번호를 보내드렸습니다.");
				cust.setCustpwd(key.toString());
				service.modify(cust);
			}else {
				model.addAttribute("msg", "잘못된 id, email 입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "잘못된 id, email 입니다.");
		}
		
		return "index";
	}
	
	
	
}


























