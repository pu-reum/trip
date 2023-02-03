package com.trip.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.dto.Cust;
import com.trip.service.CustService;
import com.trip.service.MailService;

@RestController
public class AController {
	
	@Autowired
	CustService service;
	
	@Autowired
	MailService mservice;
	
	
	@RequestMapping("/checkid")
	public Object checkid(String cid) {
		int result=0;
		Cust cust=null;
		try {
			cust=service.get(cid);
			if(cust!=null) {
				result=1;
			}else {
				result=0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/checknick")
	public Object checknick(String cnick) {
		int result=0;
		Cust cust=null;
		try {
			cust=service.get2(cnick);
			System.out.println(cust);
			if(cust!=null) {
				result=1;
			}else {
				result=0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/checkemail")
	public Object checkemail(String email) {
		Cust cust=null;
		String code;
		String subject="일상에서구조 사이트의 회원가입 인증 번호 입니다.";
		StringBuffer key=new StringBuffer();
		Random rnd=new Random();
		for(int i=0;i<6;i++) {
			key.append((rnd.nextInt(10)));
		}
		try {
			cust=service.get3(email);
			if(cust==null) {
				mservice.sendMail(email, key.toString(), subject);
				code=key.toString();
				return code;
			}else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	@RequestMapping("/checkanumber")
	public Object checkanumber(String anumber, String number) {
		if(anumber==number) {
			return 1;
		}else {
			return 0;
		}
	}
	

	
	
	
}


























