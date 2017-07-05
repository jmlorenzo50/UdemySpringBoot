package com.udemy.backendninja.converter;

import org.springframework.stereotype.Component;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;

@Component("courseConverter")
public class CourseConverter {
	
	public CourseModel entity2Model (Course course) {
		CourseModel salida = new CourseModel();
		salida.setId(course.getId());
		salida.setName(course.getName());
		salida.setDescription(course.getDescription());
		salida.setPrice(course.getPrice());
		salida.setHours(course.getHours());
		return salida;
	}

	public Course model2Entity (CourseModel course) {
		Course salida = new Course();
		if (course.getId() != null) {
			salida.setId(course.getId().intValue());
		}
		salida.setName(course.getName());
		salida.setDescription(course.getDescription());
		salida.setPrice(course.getPrice());
		salida.setHours(course.getHours());
		return salida;
	}

}
