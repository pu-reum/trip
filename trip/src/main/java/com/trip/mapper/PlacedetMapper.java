package com.trip.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.trip.dto.Criteria;
import com.trip.dto.Placedet;

@Repository
@Mapper
public interface PlacedetMapper{
	
	//여행 목록
	List<Placedet> selectPlaceList(Criteria criteria) throws Exception;
	
	//여행 상세
	Placedet selectPlace(int pdid) throws Exception;
	
	//조회수
	void updateHitCount(int pdid) throws Exception;
	
	//페이지네이션
	int getTotalData();
	
	//insert
	void insertPlace(Placedet place) throws Exception;
	
	//delete
	void deletePlace(int pdid) throws Exception;
}
