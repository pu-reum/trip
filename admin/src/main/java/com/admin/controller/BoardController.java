package com.admin.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.admin.dto.Board;
import com.admin.dto.Criteria;
import com.admin.dto.Page;
import com.admin.dto.ReplyBoard;
import com.admin.service.BoardService;
import com.admin.service.ReplyBoardService;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/board")
public class BoardController {

	String dir = "board/";
	
	@Autowired
	BoardService bs;
	
	@Autowired
	ReplyBoardService rbs;
	
	//목록
	@RequestMapping("")
	public String board(Model model, Criteria criteria) throws Exception {
		
		//글 목록
		List <Board> list = bs.selectBoardList(criteria);
		model.addAttribute("list", list);
		System.out.println(list);
		model.addAttribute("pageMaker", new Page(bs.getTotalData(), 5, criteria));
		//bs.categoryEnum(board);
		model.addAttribute("center", dir+"board");
		return "index";
	}
	//글 상세보기
	@GetMapping("/boardview")
	public String boardview(Model model, int postid)throws Exception {
		
		Board board=bs.selectBoard(postid);
		model.addAttribute("board", board);
		
		//댓글 조회
		List<ReplyBoard> reply = rbs.selectCommentList(postid);
		model.addAttribute("reply", reply);
		
		System.out.println(reply);
		model.addAttribute("center", dir+"boardview");
		return "index";
	}

	//글 삭제
	@RequestMapping("/boarddelete")
	public String boarddelete(int postid) throws Exception {
		bs.deleteBoard(postid);
		return "redirect:/board";
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
