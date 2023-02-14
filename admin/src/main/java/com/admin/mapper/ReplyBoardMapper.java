package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.ReplyBoard;

@Repository
@Mapper
public interface ReplyBoardMapper {
	
	//댓글 목록
	List<ReplyBoard> selectCommentList(int postid) throws Exception;
	
	//댓글 삭제 
	void deleteComment(int replyno) throws Exception;
}
