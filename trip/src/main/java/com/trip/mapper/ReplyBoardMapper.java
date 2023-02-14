package com.trip.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.trip.dto.ReplyBoard;

@Repository
@Mapper
public interface ReplyBoardMapper {
	//댓글 작성
	void insertComment(ReplyBoard rBoard) throws Exception;
	//댓글 목록
	List<ReplyBoard> selectCommentList(int postid) throws Exception;
	//댓글 수정
	//void updateComment(ReplyBoard rBoard) throws Exception;
	//댓글 삭제 
	void deleteComment(int replyno) throws Exception;
}
