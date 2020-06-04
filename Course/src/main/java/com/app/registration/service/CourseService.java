package com.app.registration.service;

import java.util.List;
import java.util.Optional;

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
		// this will save course to database
		return crepo.save(course);
	}

	public Course fetchCourseBySkill(String skill) {
		return crepo.findBySkill(skill);
	}

	public List<Course> findAllCourse() {
		return crepo.findAll();
	}

	public Optional<Course> get(Integer id) {
		// return repo.findById(id).get();
		return crepo.findById(id);
	}

	public void deleteCourse(Integer id) {
		// repo.deleteById(id);
		crepo.deleteById(id);
	}

	public List<Course> fetchCourseByCreator(String creator) {
		return crepo.findByCreator(creator);
	}

	public Course updateCourse(Course c) {
		Course exist_course = crepo.findById(c.getId()).orElse(null);
		exist_course.setCreator(c.getCreator());
		exist_course.setDescription(c.getDescription());
		exist_course.setFeedback(c.getFeedback());
		exist_course.setlastUpdated(c.getlastUpdated());
		exist_course.setPrerequisite(c.getPrerequisite());
		exist_course.setSkill(c.getSkill());
		return crepo.save(exist_course);
	}

}
