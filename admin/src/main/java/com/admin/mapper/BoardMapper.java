package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.Board;
import com.admin.dto.Criteria;

@Repository
@Mapper
public interface BoardMapper{

	//전체 글 목록
	List<Board> selectBoardList(Criteria criteria) throws Exception;
	//글 보기
	Board selectBoard(int postid) throws Exception;
	//조회수
	void updateHitCount(int postid) throws Exception;
	//글 삭제
	void deleteBoard(int postid) throws Exception;
	//카테고리 문자로 변환
	//String categoryEnum(Board board);
	//페이지네이션
	int getTotalData();
	
}
