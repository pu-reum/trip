package com.trip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.trip.dto.Msg;
import com.trip.frame.ChatBotUtil;



@Controller
public class MsgController {
	
	@Autowired
	SimpMessagingTemplate template;
	
//	@MessageMapping("/receiveall") // 모두에게 전송
//	public void receiveall(Msg msg, SimpMessageHeaderAccessor headerAccessor) {
//		System.out.println(msg);
//		template.convertAndSend("/send",msg); //send라고 받을 준비를 한 모든 사용자에게 메세지 보낸다.
//	}
	@MessageMapping("/receiveme") // 나에게만 전송 ex)Chatbot
	public void receiveme(Msg msg, SimpMessageHeaderAccessor headerAccessor) throws Exception{
		String id = msg.getCustid();
		String result = ChatBotUtil.chat(msg.getContent1());
		msg.setContent1(result);
		msg.setContent2("TR Message");
		template.convertAndSend("/send/"+id,msg); //send id01에게 메세지 보냄 id==나
	}
//	@MessageMapping("/receiveto") // 특정 Id에게 전송
//	public void receiveto(Msg msg, SimpMessageHeaderAccessor headerAccessor) {
//		String id = msg.getCustid();
//		String target = msg.getReceiveid();
//		template.convertAndSend("/send/to/"+target,msg); //send to id02에게 메시지 보냄
//	}
}
