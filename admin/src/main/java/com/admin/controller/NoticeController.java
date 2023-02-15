package com.admin.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.admin.dto.Admin;
import com.admin.dto.Criteria;
import com.admin.dto.Notice;
import com.admin.dto.Page;
import com.admin.frame.ImgUtil;
import com.admin.service.NoticeService;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	String dir = "notice/";

	@Autowired
	NoticeService ns;
	
	@Value("${admindir}")
	String admindir;
	
	@Value("${custdir}")
	String custdir;

	// 공지 글 리스트
	@RequestMapping("")
	public String notice(Criteria criteria, Model model) throws Exception {
		// log.info("list");
		System.out.println(criteria);
		List<Notice> list = ns.selectNoticeList(criteria);
		model.addAttribute("list", list);
		System.out.println(list);
		System.out.println(new Page(ns.getTotalData(), 5, criteria));
		model.addAttribute("pageMaker", new Page(ns.getTotalData(), 5, criteria));
		model.addAttribute("center", dir + "notice");
		return "index";
	}

	// 글 상세보기
	@GetMapping("/noticeview")
	public String noticeview(int noid, Model model) throws Exception {
		Notice notice = ns.selectNotice(noid);

		model.addAttribute("notice", notice);
		model.addAttribute("center", dir + "noticeview");
		return "index";
	}

	// 글 쓰기
	@GetMapping("/noticewrite")
	public String noticewrite(Model model) throws Exception {
		model.addAttribute("center", dir + "noticewrite");
		return "index";
	}

	// 글쓰기 완료
	@PostMapping("/noticewriteok")
	public String noticewriteok(Notice notice, Model model, HttpSession session) throws Exception {
		Admin admin = (Admin) session.getAttribute("loginAdmin");
		
		
		String file = notice.getImg().getOriginalFilename();
		System.out.println(file+"-----");
		
		if(file == null || file.equals("")) {
			notice.setAdid(admin.getAdid());
			ns.insertNotice(notice);
			model.addAttribute("result", notice);
		}else {
			try {
				notice.setAdid(admin.getAdid());
				notice.setFile(file);
				ImgUtil.saveFile2(notice.getImg(), admindir, custdir);
				ns.insertNotice(notice);
				model.addAttribute("result", notice);
			}catch(Exception e) {
				e.printStackTrace();
				return "redirect:/noticewrite";
			}
		}
		return "redirect:/notice";
	
	}

	// 글 수정
	@RequestMapping("/noticeedit")
	public String boardedit(Model model, Notice notice) throws Exception {
		model.addAttribute("notice", notice);
		model.addAttribute("center", dir + "noticeedit");
		return "index";
	}

	// 글수정 완료
	@PostMapping("/noticeeditok")
	public String boardeditok(Notice notice, Model model, HttpSession session) throws Exception {
		Admin admin = (Admin) session.getAttribute("loginAdmin");
		notice.setAdid(admin.getAdid());
		ns.updateNotice(notice);
		model.addAttribute("result", notice);
		return "redirect:/notice";

	}

	// 글 삭제
	@RequestMapping("/noticedelete")
	public String noticedelete(int noid, HttpSession session) throws Exception {
		Admin admin = (Admin) session.getAttribute("loginAdmin");
		ns.deleteNotice(noid, admin.getAdid());
		return "redirect:/notice";
	}

	@PostMapping(value="/uploadSummernoteImageFile", produces="application/json")
	@ResponseBody
	public JsonObject uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile) {
		System.out.println("122");
		JsonObject jsonObject = new JsonObject();
		
		String fileRoot ="C:\\summernote_Image\\"; //저장될 외부 파일 경로
		
		/*
		 * 내부
		 * String contextRoot =
		 * request.getSession().getServletContext().getRealPath("/"); String
		 * fileRoot=contextRoot+"resources/fileupload/";
		 */
		//String contextRoot = 
		
		String originalFileName=multipartFile.getOriginalFilename(); //오리지널 파일명
		String extension = originalFileName.substring(originalFileName.lastIndexOf(".")); //파일 확장자
		
		String savedFileName = UUID.randomUUID() +extension; //저장될 파일명
		
		File targetFile = new File(fileRoot + savedFileName);
		
		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile); //파일저장
			jsonObject.addProperty("url", "/summernoteImage/"+savedFileName);
			jsonObject.addProperty("responseCode", "success");
		}catch(IOException e) {
			FileUtils.deleteQuietly(targetFile); //저장된 파일 삭제
			jsonObject.addProperty("responseCode","error");
			e.printStackTrace();
		}
		//String result = jsonObject.toString();
		return jsonObject;
	}
}
