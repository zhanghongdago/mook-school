package com.online.college.wechat.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.online.college.common.page.TailPage;
import com.online.college.common.web.SessionContext;
import com.online.college.core.course.domain.Course;
import com.online.college.core.course.domain.CourseComment;
import com.online.college.core.course.domain.CourseSection;
import com.online.college.core.course.service.ICourseCommentService;
import com.online.college.core.course.service.ICourseSectionService;
import com.online.college.core.course.service.ICourseService;
import com.online.college.core.user.domain.UserCourseSection;
import com.online.college.core.user.service.IUserCourseSectionService;
import com.online.college.wechat.business.IPortalBusiness;
import com.online.college.wechat.vo.CourseSectionVO;


@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private ICourseService courseService;
	
	@Autowired
	private IPortalBusiness portalBusiness;
	
	@Autowired
	private ICourseCommentService courseCommentService;
	
	@Autowired
	private ICourseSectionService courseSectionService;
	
	@Autowired
	private IUserCourseSectionService userCourseSectionService;
	
	/**
	 * 课程详情
	 */
	@RequestMapping("/read")
	public ModelAndView read(Long id){
		ModelAndView mv = new ModelAndView("read");
		
		//课程基本信息
		Course course = courseService.getById(id);
		if(null == course){
			return new ModelAndView("error/404"); 
		}
		mv.addObject("course", course);
		
		//课程章节
		List<CourseSectionVO> chaptSections = this.portalBusiness.queryCourseSection(id);
		mv.addObject("chaptSections", chaptSections);
		
		return mv;
	}
	
}

