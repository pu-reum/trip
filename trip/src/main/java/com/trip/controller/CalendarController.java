package com.trip.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.trip.dto.Calendar;
import com.trip.dto.Cust;
import com.trip.service.CalendarService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("/mypage")
public class CalendarController {

	private final CalendarService calendarService;


	@GetMapping("/fullcalendar")
	@ResponseBody
	public List<Calendar> getPlan(@SessionAttribute(required = false ,  value= "logincust") Cust cust) {
		return calendarService.getCalendarAllList(cust.getCustid());
	}

	@PostMapping("/fullcalendar")
	@ResponseBody
	public void addCalendar(@RequestBody Calendar calendar , @SessionAttribute(required = false ,  value= "logincust") Cust cust) {
	
		calendar.setCustid(cust.getCustid());
		calendarService.insert(calendar);
		
	}
	
	@PutMapping("/fullcalendar")
	@ResponseBody
	public void updatePlan(@RequestBody Calendar calendar, @SessionAttribute(required = false ,  value= "logincust") Cust cust){
		
		calendarService.update(calendar);
		
	}
	
	@DeleteMapping("/fullcalendar")
	@ResponseBody
	public void deletePlan(@RequestBody int planid, @SessionAttribute(required = false ,  value= "logincust") Cust cust) {
		
		calendarService.deleteByPlanid(planid);
	}

}