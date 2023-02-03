package com.trip.cust;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trip.dto.Cust;
import com.trip.service.CustService;

@SpringBootTest
class SelectTests {
	
	@Autowired
	CustService service;
	
	@Test
	void contextLoads() {
		Cust cust=null;
		try {
			cust=service.get("user1");
			System.out.println("ok");
			System.out.println(cust);
		} catch (Exception e) {
			System.out.println("fail");
			e.printStackTrace();
		}
	}

}
