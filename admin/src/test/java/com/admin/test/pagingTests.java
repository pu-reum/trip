package com.admin.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.Admin;
import com.admin.dto.Criteria;
import com.admin.service.AdminService;
import com.admin.service.CustService;

@SpringBootTest
class pagingTests {
	
	@Autowired
	CustService service;
	
	@Test
	void contextLoads() {
		Criteria criteria=new Criteria();
		criteria.setSearchKey("id");
		criteria.setSearchWord("1");
		try {
			int n=service.getTotalData(criteria);
			System.out.println(n);
		} catch (Exception e) {
			System.out.println("fail");
			e.printStackTrace();
		}
		
	}

}
