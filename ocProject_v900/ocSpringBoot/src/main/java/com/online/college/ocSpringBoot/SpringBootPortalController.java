package com.online.college.ocSpringBoot;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.online.college.domain.Course;
import com.online.college.service.ICourseService;

@Controller
public class SpringBootPortalController {

	@Autowired
	private ICourseService courseService;
	
	@RequestMapping("/")
	public String index(Map<String,Object> model , HttpServletRequest request){
		Course queryEntity = new Course();
		queryEntity.setFree(1);
		List<Course> list = courseService.getFiveCourses(queryEntity);
		model.put("freeCourseList", list);
		return "index";
	}
	
}
