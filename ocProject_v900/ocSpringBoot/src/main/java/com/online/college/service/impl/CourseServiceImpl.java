package com.online.college.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.college.dao.CourseDao;
import com.online.college.domain.Course;
import com.online.college.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService{

	@Autowired
	private CourseDao courseDao;
	
	@Override
	public List<Course> getFiveCourses(Course queryEntity){
		return courseDao.getFiveCourses(queryEntity);
	}
	
}
