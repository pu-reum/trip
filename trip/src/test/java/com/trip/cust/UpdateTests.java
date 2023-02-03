package com.trip.cust;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trip.dto.Cust;
import com.trip.service.CustService;

@SpringBootTest
class UpdateTests {
	
	@Autowired
	CustService service;
	
	@Test
	void contextLoads() {
		
		Cust cust=new Cust("user3", "111111", "푸름", "J", null, "user3@naver.com", null);
		try {
			service.modify(cust);
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("fail");
			e.printStackTrace();
		}
	}

}
