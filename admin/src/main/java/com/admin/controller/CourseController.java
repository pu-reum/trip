package com.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admin.dto.Admin;
import com.admin.dto.Course;
import com.admin.frame.ImgUtil;
import com.admin.service.CourseService;

@Controller
public class CourseController {
	
	@Value("${admindir}")
	String admindir;
	
	@Autowired
	CourseService service;
	
	String dir="course/";
	
	@RequestMapping("/course")
	public String course(Model model, HttpSession session) {
		List<Course> list=null;
		Admin admin=null;
		if(session.getAttribute("loginAdmin")!=null) {
			admin=(Admin)session.getAttribute("loginAdmin");
			int lev=admin.getAdlev();
			if(lev>0) {
				try {
					list=service.get();
					model.addAttribute("list", list);
					model.addAttribute("center", dir+"course");
				} catch (Exception e) {
					model.addAttribute("center", "fail/error");
					e.printStackTrace();
				}
			}else {
				model.addAttribute("center", "fail/access-limit");
			}
		}else {
			model.addAttribute("center", "fail/access-limit");
		}
		
		return "index";
	}
	
	@RequestMapping("/courseView")
	public String courseView(Model model, HttpSession session, int cid) {
		Course course=null;
		try {
			course=service.get(cid);
			System.out.println(course);
			model.addAttribute("c", course);
			model.addAttribute("center", dir+"courseview");
		} catch (Exception e) {
			model.addAttribute("center", "fail/error");
			e.printStackTrace();
		}
		
		return "index";
	}	
	
	@RequestMapping("/courseWrite")
	public String courseWrite(Model model, HttpSession session) {
		
		model.addAttribute("center", dir+"coursewrite");
		return "index";
	}
	
	@PostMapping("/courseWriteimpl")
	public String courseWriteimpl(Model model, HttpSession session, Course course) {
		String cdimg1 = course.getImg1().getOriginalFilename();
		String cdimg2 = course.getImg2().getOriginalFilename();
		String cdimg3 = course.getImg3().getOriginalFilename();
		System.out.println(cdimg1);
		
		course.setCdimg1(cdimg1);
		course.setCdimg2(cdimg2);
		course.setCdimg3(cdimg3);
		
		try {
			ImgUtil.saveFile(course.getImg1(), admindir);
			ImgUtil.saveFile(course.getImg2(), admindir);
			ImgUtil.saveFile(course.getImg3(), admindir);
			
			service.register(course);
	
			model.addAttribute("center", "course/coursewriteOk");
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/courseWrite";
		}
		
		
		return "index";
	}
	
	@RequestMapping("/courseRemove")
	public String courseRemove(Model model, HttpSession session, int cid) {
		try {
			service.remove(cid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/course";
	}
			
	

	
	
}









