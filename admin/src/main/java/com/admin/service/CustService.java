package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.Criteria;
import com.admin.dto.Cust;
import com.admin.frame.MyService;
import com.admin.mapper.CustMapper;

@Service
public class CustService implements MyService<String, Cust>{
	
	@Autowired
	CustMapper mapper;
	
	@Override
	public void register(Cust v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(String k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(Cust v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public Cust get(String k) throws Exception {
		return mapper.select(k);
	}
	
	public Cust get2(String k) throws Exception {
		return mapper.select2(k);
	}

	@Override
	public List<Cust> get() throws Exception {
		return mapper.selectall();
	}
	
	
	public Cust get3(String k) throws Exception {
		return mapper.select3(k);
	}

	public Cust login(String k, String j) throws Exception {
		return mapper.login(k,j);
	}
	
	public Cust searchPwd(String k, String j) throws Exception {
		return mapper.searchPwd(k,j);
	}
	
	public List<Cust> getCustList(Criteria criteria) throws Exception{
		return mapper.getCustList(criteria);
	}
	
	public int getTotalData(Criteria criteria) throws Exception{
		return mapper.getTotalData(criteria);
	}
	
	public int countCust() throws Exception{
		return mapper.countCust();
	}
	
	public int todayCountCust() throws Exception{
		return mapper.todayCountCust();
	}
	
	
}
