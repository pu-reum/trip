package com.trip.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.trip.dto.Review;

@Repository
@Mapper
public interface ReviewMapper {
	
	//리뷰 등록
	void insertReview(Review review) throws Exception;
	//댓글 목록
	List<Review> selectReviewList(int pdid) throws Exception;
	//리뷰 삭제
	void deleteComment(int rid) throws Exception;
}
