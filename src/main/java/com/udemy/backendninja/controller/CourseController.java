package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	private static final String COURSES_VIEW = "courses";
	
	private static final Log LOG = LogFactory.getLog(CourseController.class);
	
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;
	
	@GetMapping("/list")
	public ModelAndView listAllCourses() {
		LOG.info("Call: " + "listAllCourses");
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("courses", courseService.listAllCourse());
		return mav;
	}
	
	@PostMapping("/add")
	public String addCourse(@ModelAttribute("course") Course course) {
		LOG.info("Call: " + "addCourse" + ", PARAMS: " + course.toString());
		courseService.addCourse(course);
		return "redirect:/course/list";
	}
	

}