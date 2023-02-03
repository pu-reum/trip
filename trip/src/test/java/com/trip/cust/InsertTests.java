package com.trip.cust;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trip.dto.Cust;
import com.trip.service.CustService;

@SpringBootTest
class InsertTests {
	
	@Autowired
	CustService service;
	
	@Test
	void contextLoads() {
		
		Cust cust=new Cust("user4", "111111", "지은", "J", null, "user3@naver.com", null);
		try {
			service.register(cust);
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("fail");
			e.printStackTrace();
		}
	}

}
