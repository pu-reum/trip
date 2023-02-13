package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.Criteria;
import com.admin.dto.Inquiry;

@Repository
@Mapper
public interface InquiryMapper{

	//전체 글 목록
	List<Inquiry> selectInquiryList(Criteria criteria) throws Exception;
	//글 보기
	Inquiry selectInquiry(int inquiryid) throws Exception;
	//글 수정
	void updateInquiry(Inquiry inquiry) throws Exception;
	//글 삭제
	void deleteInquiry(int inquiryid) throws Exception;
	//페이지
	int getTotalData();
	
	List<Inquiry> iList() throws Exception;
}
