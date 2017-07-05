package com.udemy.backendninja.service;

import java.util.List;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;

public interface CourseService {

	public abstract List<CourseModel> listAllCourse();
	
	public abstract Course addCourse(CourseModel course);
	
	public abstract int removeCourse(Integer id);
	
	public abstract Course updateCourse(CourseModel course);
	
}
