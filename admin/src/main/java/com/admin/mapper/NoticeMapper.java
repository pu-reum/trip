package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.Criteria;
import com.admin.dto.Notice;

@Repository
@Mapper
public interface NoticeMapper {

		//전체 글 목록
		List<Notice> selectNoticeList(Criteria criteria) throws Exception;
		//글 보기
		Notice selectNotice(int noid) throws Exception;
		//조회수
		void updateHitCount(int noid) throws Exception;
		//페이지네이션
		int getTotalData();
		//검색어 처리
		
		//글 쓰기
		void insertNotice(Notice notice) throws Exception;
		//글 수정
		void updateNotice(Notice notice) throws Exception;
		//글 삭제
		void deleteNotice(int noid, String adid) throws Exception;
}
