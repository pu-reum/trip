package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.Admin;
import com.admin.dto.Criteria;
import com.admin.dto.Cust;
import com.admin.frame.MyMapper;

@Repository
@Mapper
public interface AdminMapper extends MyMapper<String, Admin> {
	public Admin login(String k, String t) throws Exception; 
	
	public List<Admin> getAdminList(Criteria criteria) throws Exception;
	public int getTotalData(Criteria criteria) throws Exception;
}
