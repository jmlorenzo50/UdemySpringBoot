package com.udemy.backendninja.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.repository.CourseJpaRepository;
import com.udemy.backendninja.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {
	
	private static final Log LOG = LogFactory.getLog(CourseService.class);
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;

	@Override
	public List<Course> listAllCourse() {
		LOG.info("call: listAllCourse");
		return courseJpaRepository.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		LOG.info("call: addCourse" + ", PARAM: " + course.toString());
		return courseJpaRepository.save(course);
	}

	@Override
	public int removeCourse(int id) {
		courseJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		return courseJpaRepository.save(course);
	}

}
