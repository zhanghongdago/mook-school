package com.online.college.service;

import java.util.List;

import com.online.college.domain.Course;

public interface ICourseService {

	List<Course> getFiveCourses(Course queryEntity);
	
}
