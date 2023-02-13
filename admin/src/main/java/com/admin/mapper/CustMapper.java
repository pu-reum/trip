package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.Criteria;
import com.admin.dto.Cust;
import com.admin.frame.MyMapper;

@Repository
@Mapper
public interface CustMapper extends MyMapper<String, Cust> {
	public Cust select2(String k) throws Exception;
	public Cust select3(String k) throws Exception;
	public Cust login(String k, String j) throws Exception;
	public Cust searchPwd(String k, String j) throws Exception;
	
	public List<Cust> getCustList(Criteria criteria) throws Exception;
	public int getTotalData(Criteria criteria) throws Exception;
	
	public int countCust() throws Exception;
	public int todayCountCust() throws Exception;
}
