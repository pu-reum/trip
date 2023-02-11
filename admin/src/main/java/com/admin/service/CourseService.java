package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.Course;
import com.admin.frame.MyService;
import com.admin.mapper.CourseMapper;

@Service
public class CourseService implements MyService<Integer, Course>{
	
	@Autowired
	CourseMapper mapper;
	
	@Override
	public void register(Course v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(Course v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public Course get(Integer k) throws Exception {
		return mapper.select(k);
	}
	
	@Override
	public List<Course> get() throws Exception {
		return mapper.selectall();
	}
	
	
	
	
	
}
