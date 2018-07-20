package com.online.college.service;

import junit.framework.TestCase;

import com.online.college.common.web.SpringBeanFactory;
import com.online.college.core.consts.domain.ConstsSiteCarousel;
import com.online.college.core.consts.service.IConstsSiteCarouselService;

public class AppTest extends TestCase {
	
	public void testApp() {
         IConstsSiteCarouselService constsSiteCarouselService = (IConstsSiteCarouselService) SpringBeanFactory.getBean("constsSiteCarouselServiceImpl");
         constsSiteCarouselService.createSelectivity(new ConstsSiteCarousel());
	}
	
}
