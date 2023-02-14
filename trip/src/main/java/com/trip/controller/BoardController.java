package com.trip.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

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

import com.google.gson.JsonObject;
import com.trip.dto.Board;
import com.trip.dto.Criteria;
import com.trip.dto.Cust;
import com.trip.dto.Page;
import com.trip.dto.ReplyBoard;
import com.trip.service.BoardService;
import com.trip.service.ReplyBoardService;

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
	//글 쓰기
	@GetMapping("/boardwrite")
	public String boardwrite(Model model) throws Exception {
		model.addAttribute("center", dir+"boardwrite");
		return "index";
	}
	//글쓰기 완료
	@PostMapping("/boardwriteok")
	public String boardwriteok(Board board, Model model, HttpSession session) throws Exception {
		Cust cust = (Cust) session.getAttribute("logincust");
		board.setCustid(cust.getCustid());
		bs.insertBoard(board);
		model.addAttribute("result", board);
		return "redirect:/board";
		
	}
	//글 상세보기
	@GetMapping("/boardview")
	public String boardview(Model model, int postid) throws Exception {
		
		Board board=bs.selectBoard(postid);
		model.addAttribute("board", board);
		
		//댓글 조회
		List<ReplyBoard> reply = rbs.selectCommentList(postid);
		model.addAttribute("reply", reply);
		
		System.out.println(reply);
		model.addAttribute("center", dir+"boardview");
		return "index";
	}
	//글 수정
	@RequestMapping("/boardedit")
	public String boardedit(Model model, Board board) throws Exception {
		model.addAttribute("board", board);
		model.addAttribute("center", dir+"boardedit");
		return "index";
	}
	//글수정 완료
	@PostMapping("/boardeditok")
	public String boardeditok(Board board, Model model, HttpSession session) throws Exception {
		Cust cust = (Cust) session.getAttribute("logincust");
		board.setCustid(cust.getCustid());
		System.out.println(board);
		bs.updateBoard(board);
		model.addAttribute("result", board);
		return "redirect:/board";
			
	}
	//글 삭제
	@RequestMapping("/boarddelete")
	public String boarddelete(int postid, HttpSession session) throws Exception {
		Cust cust = (Cust) session.getAttribute("logincust");
		bs.deleteBoard(postid, cust.getCustid());
		return "redirect:/board";
	}
	
//	@ModelAttribute("categorys")
//	public List<Category> categorys(){
//		List<Category> categorys = new ArrayList<>();
//		categorys.add(new Category(1, "여행지"));
//		categorys.add(new Category(2, "맛집"));
//		categorys.add(new Category(3, "축제"));
//		categorys.add(new Category(4, "기타"));
		
//		return categorys;
//	}
	
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
