package com.trip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trip.dto.Criteria;
import com.trip.dto.Placedet;
import com.trip.mapper.PlacedetMapper;

@Service
public class PlacedetService{
	
	@Autowired
	PlacedetMapper mapper;
	
	//여행 소개
	public List<Placedet> selectPlaceList(Criteria criteria) throws Exception{
		return mapper.selectPlaceList(criteria);
	}
	
	//여행 상세
	public Placedet selectPlace(int pdid) throws Exception{
		mapper.updateHitCount(pdid);
		
		Placedet place=mapper.selectPlace(pdid);
		return place;
	}
	
	//페이지네이션
	public int getTotalData() {
		return mapper.getTotalData();
	}
	
	//insert
	public void insertPlace(Placedet place) throws Exception{
		mapper.insertPlace(place);
	}
	
	//delete
	public void deletePlace(int pdid) throws Exception{
		mapper.deletePlace(pdid);
	}
}
