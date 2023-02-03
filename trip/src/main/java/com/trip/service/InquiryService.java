package com.trip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trip.dto.Criteria;
import com.trip.dto.Inquiry;
import com.trip.mapper.InquiryMapper;

@Service
public class InquiryService{

	@Autowired
	InquiryMapper im;
	
	//글 작성
	public void insertInquiry(Inquiry inquiry) throws Exception {
		im.insertInquiry(inquiry);
	}

	//글 삭제
	public void deleteInquiry(int inquiryid,String custid) throws Exception {
		im.deleteInquiry(inquiryid,custid);
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

}