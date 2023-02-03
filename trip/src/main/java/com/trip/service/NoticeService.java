package com.trip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trip.dto.Criteria;
import com.trip.dto.Notice;
import com.trip.mapper.NoticeMapper;

@Service
public class NoticeService {
	
	@Autowired
	NoticeMapper nmp;
	
	//공지 리스트
	public List<Notice> selectNoticeList(Criteria criteria) throws Exception{
		return nmp.selectNoticeList(criteria);
	}
	//상세 보기
	public Notice selectNotice(int noid) throws Exception {
		return nmp.selectNotice(noid);
	}
	//페이지네이션
	public int getTotalData() {
		return nmp.getTotalData();
	}
}
