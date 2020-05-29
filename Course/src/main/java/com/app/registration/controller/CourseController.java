package com.app.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.model.Course;
import com.app.registration.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	private CourseService cservice;
	
	@PostMapping("/addcourse")
	@CrossOrigin(origins = "http://localhost:4200")
	public Course addCourse(@RequestBody Course course) throws Exception {
		String tempskill= course.getSkill();
		if(tempskill !=null && !"".equals(tempskill)) {
			Course courseObj= cservice.fetchCourseBySkill(tempskill);
			if(courseObj != null) {
				throw new Exception("Course with "+tempskill+" id is already exist");
			}
		}
		Course courseObj= cservice.saveCourse(course);
		return courseObj;
	}
	@GetMapping("/getcourse")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Course> getCourse() {
		//if()
		//return "hello";
		return (List<Course>) cservice.findAllCourse();
	}
}
