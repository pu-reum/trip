package com.trip.cust;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trip.dto.Cust;
import com.trip.service.CustService;

@SpringBootTest
class SelectallTests {
	
	@Autowired
	CustService service;
	
	@Test
	void contextLoads() {
		List<Cust> objs=null;
		try {
			objs=service.get();
			for(Cust obj:objs) {
				System.out.println(obj);
			};
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("fail");
			e.printStackTrace();
		}
	}

}
