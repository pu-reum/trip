package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.Criteria;
import com.admin.dto.Inquiry;
import com.admin.mapper.InquiryMapper;

@Service
public class InquiryService{

	@Autowired
	InquiryMapper im;

	//글 삭제
	public void deleteInquiry(int inquiryid) throws Exception {
		im.deleteInquiry(inquiryid);
	}

	//글 수정
	public void updeateInquiry(Inquiry inquiry) throws Exception {
		im.updateInquiry(inquiry);
	}

	//글 상세 보기
	public Inquiry selectInquiry(int inquiryid) throws Exception {
		
		return im.selectInquiry(inquiryid);
	}

	//글 목록
	public List<Inquiry> selectInquiryList(Criteria criteria) throws Exception {
		return im.selectInquiryList(criteria);
	}
	
	//페이지
	public int getTotalData() {
		return im.getTotalData();
	}
	
	// 글 목록(new)
	public List<Inquiry> iList() throws Exception{
		return im.iList();
	}

}