package com.trip.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.trip.dto.Board;
import com.trip.dto.Criteria;


@Repository
@Mapper
public interface BoardMapper{

	//전체 글 목록
	List<Board> selectBoardList(Criteria criteria) throws Exception;
	//글 보기
	Board selectBoard(int postid) throws Exception;
	//조회수
	void updateHitCount(int postid) throws Exception;
	//글 쓰기
	void insertBoard(Board board) throws Exception;
	//글 수정
	void updateBoard(Board board) throws Exception;
	//글 삭제
	void deleteBoard(int postid, String custid) throws Exception;
	//카테고리 문자로 변환
	//String categoryEnum(Board board);
	//페이지네이션
	int getTotalData();

	
}
