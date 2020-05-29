package com.app.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.registration.model.Course;
import com.app.registration.model.User;
import com.app.registration.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository crepo; 
	
	public Course saveCourse(Course course) {
		//this will save course to database
		return crepo.save(course);
	}
	
	public Course fetchCourseBySkill(String skill) {
		return crepo.findBySkill(skill);
	}

	public List<Course> findAllCourse() {
		return crepo.findAll();
	}
}
