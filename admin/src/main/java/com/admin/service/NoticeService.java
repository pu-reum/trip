package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.Criteria;
import com.admin.dto.Notice;
import com.admin.mapper.NoticeMapper;

@Service
public class NoticeService {

	@Autowired
	NoticeMapper nmp;

	// 공지 리스트
	public List<Notice> selectNoticeList(Criteria criteria) throws Exception {
		return nmp.selectNoticeList(criteria);
	}

	// 상세 보기
	public Notice selectNotice(int noid) throws Exception {
		nmp.updateHitCount(noid);
		Notice notice = nmp.selectNotice(noid);
		return notice;
	}

	// 페이지네이션
	public int getTotalData() {
		return nmp.getTotalData();
	}

	// 글 작성
	public void insertNotice(Notice notice) throws Exception {
		nmp.insertNotice(notice);
	}

	// 글 삭제
	public void deleteNotice(int noid, String adid) throws Exception {
		nmp.deleteNotice(noid, adid);
	}

	// 글 수정
	public void updateNotice(Notice notice) throws Exception {
		nmp.updateNotice(notice);
	}
}
