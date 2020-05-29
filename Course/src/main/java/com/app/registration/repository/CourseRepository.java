package com.app.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.registration.model.Course;
import com.app.registration.model.User;

public interface CourseRepository extends JpaRepository<Course,Integer> {

	public Course findBySkill(String skill);

}
