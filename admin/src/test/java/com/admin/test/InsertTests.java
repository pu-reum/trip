package com.admin.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.Admin;
import com.admin.service.AdminService;

@SpringBootTest
class InsertTests {
	
	@Autowired
	AdminService service;
	
	@Test
	void contextLoads() {
		Admin admin=new Admin("cmo0131", "11111111", "최민영", "cmo1049@naver.com", 1);
		try {
			service.register(admin);
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("fail");
			e.printStackTrace();
		}
		
	}

}
