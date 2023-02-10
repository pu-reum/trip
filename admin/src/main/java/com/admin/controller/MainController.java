package com.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admin.dto.Admin;
import com.admin.dto.Criteria;
import com.admin.dto.Cust;
import com.admin.dto.Page;
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
	
	@RequestMapping("/mremove")
	public String mremove(String custid) {
		try {
			cservice.remove(custid);
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("fail");
		}
		return "redirect:/member-inf-manage";
	}
	
	@RequestMapping("/profile")
	public String profile(Admin admin, HttpSession session, Model model) {
		//admin=(Admin) session.getAttribute("loginAdmin");
		//model.addAttribute("admin", admin);
		model.addAttribute("center", "profile");
		return "index";
	}
	
	@RequestMapping("/member-inf-manage")
	public String cmanage(Model model, Criteria criteria, HttpSession session) {
		if(session.getAttribute("loginAdmin")!=null) {
			//System.out.println(criteria.toString());
			try {
				
				List<Cust> list=cservice.getCustList(criteria);
				model.addAttribute("list", list);
				System.out.println(list.toString());
				model.addAttribute("pageMaker", new Page(cservice.getTotalData(criteria), 5, criteria));
				//Page maker=new Page(cservice.getTotalData(criteria), 5, criteria);
				//System.out.println(maker.toString());
				model.addAttribute("center", "mimanage");
			}catch(Exception e) {
				e.getStackTrace();
				e.getMessage();
				model.addAttribute("center", "fail/error");
			}
		}else {
			model.addAttribute("center", "fail/access-limit");
		}
		
		return "index";
	}
	
	@RequestMapping("/admin-inf-manage")
	public String amanage(Model model, HttpSession session, Criteria criteria) {
		Admin admin=null;
		if(session.getAttribute("loginAdmin")!=null) {
			admin=(Admin)session.getAttribute("loginAdmin");

			int lev=admin.getAdlev();
			if(lev==3) {
				try {
					List<Admin> list=aservice.getAdminList(criteria);
					model.addAttribute("list", list);
					model.addAttribute("pageMaker", new Page(cservice.getTotalData(criteria), 5, criteria));
					model.addAttribute("center", "aimanage");
				} catch (Exception e) {
					model.addAttribute("center", "fail/error");
					System.out.println("fail1");
					e.printStackTrace();
				}
			}else {
				System.out.println("fail2");
				model.addAttribute("center", "fail/access-limit");
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
	
	@RequestMapping("/clev")
	public String clev(Model model, Admin admin, int lev, String adid, HttpSession session, Criteria criteria) {
		try {
			admin=aservice.get(adid);
			admin.setAdlev(lev);
			System.out.println(admin.toString());
			aservice.modify(admin);
			model.addAttribute("admin", admin);
			model.addAttribute("center", "success/clev");
		} catch (Exception e) {
			model.addAttribute("center", "fail/error");
			e.printStackTrace();
		}
		
		return "index";
		
		
	}
	
	
	
	
	
	
	
	
	
}









