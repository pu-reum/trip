package com.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.Course;
import com.admin.frame.MyMapper;

@Repository
@Mapper
public interface CourseMapper extends MyMapper<Integer, Course> {
	
}
