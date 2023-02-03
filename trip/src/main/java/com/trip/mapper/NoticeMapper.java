package com.trip.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.trip.dto.Criteria;
import com.trip.dto.Notice;

@Repository
@Mapper
public interface NoticeMapper {

		//전체 글 목록
		List<Notice> selectNoticeList(Criteria criteria) throws Exception;
		//글 보기
		Notice selectNotice(int noid) throws Exception;
		//페이지네이션
		int getTotalData();
		//검색어 처리
}
