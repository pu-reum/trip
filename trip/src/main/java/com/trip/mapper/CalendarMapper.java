package com.trip.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.trip.dto.Calendar;


@Mapper
public interface CalendarMapper {
	
	List<Calendar> getCalendarAllList(@Param("custid") String custid);

	void insert(Calendar calendar);

	void update(Calendar calendar);

	void deleteByPlanid(Integer planid);
	
	
}