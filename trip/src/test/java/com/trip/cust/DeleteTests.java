package com.trip.cust;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trip.dto.Cust;
import com.trip.service.CustService;

@SpringBootTest
class DeleteTests {
	
	@Autowired
	CustService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove("user3");
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("fail");
			e.printStackTrace();
		}
	}

}
