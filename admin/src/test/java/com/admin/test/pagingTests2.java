package com.admin.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.Criteria;
import com.admin.dto.Cust;
import com.admin.service.CustService;

@SpringBootTest
class pagingTests2 {
	
	@Autowired
	CustService service;
	
	@Test
	void contextLoads() {
		Criteria criteria=new Criteria();
		criteria.setSearchKey("id");
		criteria.setSearchWord("1");
		List<Cust> list=null;
		
		try {
			list=service.getCustList(criteria);
			System.out.println(list.toString());
		
		} catch (Exception e) {
			System.out.println("fail");
			e.printStackTrace();
		}
		
	}

}
