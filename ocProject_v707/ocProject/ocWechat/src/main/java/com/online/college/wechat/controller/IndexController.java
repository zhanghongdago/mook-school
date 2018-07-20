package com.online.college.wechat.controller;

import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.online.college.common.page.TailPage;
import com.online.college.core.consts.CourseEnum;
import com.online.college.core.course.domain.Course;
import com.online.college.core.course.service.ICourseService;

/**
 * M站
 */
@Controller
@RequestMapping()
public class IndexController {

	@Autowired
	private ICourseService courseService;
	
	//memcache客户端
	@Autowired
	MemcachedClient memcachedClient;
	
	/**
	 * 首页
	 */
	@RequestMapping("/index")
	public ModelAndView index(TailPage<Course> page){
		ModelAndView mv = new ModelAndView("index");
		
		//测试memcache start
		try {
			String key = "test_memecache";
			memcachedClient.add(key, 3600, "测试memcache");
			String result = memcachedClient.get(key);
			System.out.println("测试result = " + result);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
		//测试memcache end
		
		//只展示第一页的课程
		Course queryEntity = new Course();
		queryEntity.setOnsale(CourseEnum.ONSALE.value());
		
		page.descSortField("weight");
		
		page = this.courseService.queryPage(queryEntity, page);
		mv.addObject("page", page);
		return mv;
	}
	
}
