package com.trip.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trip.dto.Calendar;
import com.trip.mapper.CalendarMapper;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Transactional  //service 항상 붙이기 
@Service
public class CalendarService {
	
	private final CalendarMapper calendarMapper;
	
	public List<Calendar>getCalendarAllList(String custid){
		return calendarMapper.getCalendarAllList(custid);
	}

	
	public void insert(Calendar calendar) {
		
		calendarMapper.insert(calendar);
		
	}


	public void update(Calendar calendar) {
		
		calendarMapper.update(calendar);
		
	}

	public void deleteByPlanid(int planid) {
		calendarMapper.deleteByPlanid(planid);
	}


}
