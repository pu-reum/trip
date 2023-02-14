package com.trip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trip.dto.Review;
import com.trip.mapper.ReviewMapper;

@Service
public class ReviewService {
	
	@Autowired
	ReviewMapper rm;
	
	public void insertReview(Review review) throws Exception {
		rm.insertReview(review);
	}
	//리뷰 목록
	public List<Review> selectReviewList(int pdid) throws Exception{
		return rm.selectReviewList(pdid);
	}
	//리뷰 삭제
	public void deleteComment(int rid) throws Exception{
		rm.deleteComment(rid);
	}
}
