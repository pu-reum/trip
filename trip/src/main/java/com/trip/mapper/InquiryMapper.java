package com.trip.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.trip.dto.Criteria;
import com.trip.dto.Inquiry;

@Repository
@Mapper
public interface InquiryMapper{

	//전체 글 목록
	List<Inquiry> selectInquiryList(Criteria criteria) throws Exception;
	//글 보기
	Inquiry selectInquiry(int inquiryid) throws Exception;
	//글 쓰기
	void insertInquiry(Inquiry inquiry) throws Exception;
	//글 수정
	void updateInquiry(Inquiry inquiry) throws Exception;
	//글 삭제
	void deleteInquiry(int inquiryid, String custid) throws Exception;
	//페이지
	int getTotalData();
}
