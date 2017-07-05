package com.udemy.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.converter.CourseConverter;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;
import com.udemy.backendninja.repository.CourseJpaRepository;
import com.udemy.backendninja.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {
	
	private static final Log LOG = LogFactory.getLog(CourseService.class);
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	
	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter courseConverter;	

	@Override
	public List<CourseModel> listAllCourse() {
		LOG.info("call: listAllCourse");
		List<Course> listEntity = courseJpaRepository.findAll();
		List<CourseModel> listModel = new ArrayList<CourseModel>();
		for (Course course : listEntity) {
			CourseModel courseModel = courseConverter.entity2Model(course);
			listModel.add(courseModel);
		}
		return listModel;
	}

	@Override
	public Course addCourse(CourseModel courseModel) {
		LOG.info("call: addCourse" + ", PARAMS: " + courseModel.toString());
		Course course = courseConverter.model2Entity(courseModel);
		return courseJpaRepository.save(course);
	}

	@Override
	public int removeCourse(Integer id) {
		LOG.info("call: removeCourse" + ", PARAMS: id=" + id);
		courseJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Course updateCourse(CourseModel courseModel) {
		LOG.info("call: updateCourse" + ", PARAMS: " + courseModel.toString());
		Course course = courseConverter.model2Entity(courseModel);
		return courseJpaRepository.save(course);
	}

}
