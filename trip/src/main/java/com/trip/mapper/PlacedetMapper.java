package com.trip.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.trip.dto.Placedet;
import com.trip.frame.MyMapper;

@Repository
@Mapper
public interface PlacedetMapper extends MyMapper<Integer, Placedet> {
	
}
