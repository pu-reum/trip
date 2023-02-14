package com.trip.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trip.dto.Msg;
import com.trip.frame.ChatBotUtil;

@Controller
public class ChatBotController {
	
	@Autowired
	SimpMessagingTemplate template;
	
	@RequestMapping("/chatbot")
	public String chatbot(Model model) {
		model.addAttribute("center", "chatbot");
		return "index";
	}
	
	
//	
//	@MessageMapping("/chatbotme") // 나에게만 전송 ex)Chatbot
//	public void receiveme(Msg msg, SimpMessageHeaderAccessor headerAccessor) throws IOException {
//		String id = msg.getCustid();
//		msg.setContent2("TR Message");
//		String result = ChatBotUtil.chat(msg.getContent1());
//		msg.setContent1(result);
//		template.convertAndSend("/send/"+id,msg);
//	}
}
