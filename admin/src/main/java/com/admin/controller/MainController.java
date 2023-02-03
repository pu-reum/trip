package com.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admin.dto.Admin;
import com.admin.dto.Cust;
import com.admin.service.AdminService;
import com.admin.service.CustService;

@Controller
public class MainController {
	
	@Autowired
	AdminService aservice;
	
	@Autowired
	CustService cservice;
	
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping("/index")
	public String main() {
		return "index";
	}
	
	@RequestMapping("/pages-register")
	public String register() {
		return "pages-register";
	}
	
	@RequestMapping("/pages-login")
	public String login() {
		return "pages-login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@RequestMapping("/profile")
	public String profile(Admin admin, HttpSession session, Model model) {
		//admin=(Admin) session.getAttribute("loginAdmin");
		//model.addAttribute("admin", admin);
		model.addAttribute("center", "profile");
		return "index";
	}
	
	@RequestMapping("/member-inf-manage")
	public String manage(Model model, Cust cust, HttpSession session) {
		List<Cust> list=null;
		if(session.getAttribute("loginAdmin")!=null) {
			try {
				list=cservice.get();
				model.addAttribute("mlist", list);
				model.addAttribute("center", "mimanage");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			model.addAttribute("center", "fail/access-limit");
		}
		
		return "index";
	}
	
	
	@RequestMapping("/registerimpl")
	public String registerimpl(Model model, Admin admin) {
		
		try {
			aservice.register(admin);
			System.out.println("Ok");
		} catch (Exception e) {
			model.addAttribute("center", "fail/registerfail");
			e.printStackTrace();
			System.out.println("fail");
		}
		
		return "index";
	}
	
	@RequestMapping("/loginimpl")
	public String loginimpl(Model model, String adid, String adpwd, HttpSession session) {
		Admin admin=null;
		try {
			admin=aservice.login(adid, adpwd);
			if(admin!=null){
				session.setAttribute("loginAdmin", admin);
			}else {
				model.addAttribute("center", "fail/loginfail");
			}
						
		} catch (Exception e) {
			model.addAttribute("center", "fail/loginfail");
			e.printStackTrace();
		}
		
		return "index";
	}
	
	@RequestMapping("/editimpl")
	public String editimpl(Model model, Admin admin, HttpSession session) {
		Admin admin2=null;
		admin2=(Admin)session.getAttribute("loginAdmin");
		admin.setAdpwd(admin2.getAdpwd());
		try {
			aservice.modify(admin);
			model.addAttribute("center", "profile");
			session.setAttribute("loginAdmin", admin);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("center", "fail/error");
		}
	
		return "index";
	}
	
	@RequestMapping("/passeditimpl")
	public String passeditimpl(Model model, Admin admin, HttpSession session) {
		Admin admin2=null;
		admin2=(Admin)session.getAttribute("loginAdmin");
		admin2.setAdpwd(admin.getAdpwd());
		
		try {
			aservice.modify(admin2);
			model.addAttribute("center", "profile");
			session.setAttribute("loginAdmin", admin2);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("center", "fail/error");
		}
		
		return "index";
	}
}









