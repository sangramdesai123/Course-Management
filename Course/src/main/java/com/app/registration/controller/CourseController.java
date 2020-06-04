package com.app.registration.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.model.Course;
import com.app.registration.service.CourseService;

@RestController
public class CourseController {

	Logger logger = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	private CourseService cservice;

	@PostMapping("/addcourse")
	@CrossOrigin(origins = "http://localhost:4200")
	public String addCourse(@RequestBody Course course) throws Exception {
		String tempskill = course.getSkill();
		if (tempskill != null && !"".equals(tempskill)) {
			Course courseObj = cservice.fetchCourseBySkill(tempskill);
			if (courseObj != null) {
				logger.info(" addcourses path call");
				return "Course with " + tempskill + " id is already exist";
			}
		}
		cservice.saveCourse(course);
		return "Course added Successfully";
	}

	@GetMapping("/getcourse")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Course> getCourse() {
		logger.info(" getcourse path call");
		return (List<Course>) cservice.findAllCourse();

	}

//	@GetMapping("/getcourse/{id}")
//	@CrossOrigin(origins = "http://localhost:4200")
//	public Optional<Course>  getOne(@PathVariable Integer id) {
//	    try {
//	        Optional<Course> course = cservice.get(id);
//	        return course;
//	    } catch (Exception e) {
//	        return null;
//	    }      
//	}

	@GetMapping("/getcourse/{creator}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Course> getBycreator(@PathVariable String creator) {
		try {
			List<Course> course = cservice.fetchCourseByCreator(creator);
			return course;
		} catch (Exception e) {
			logger.error(" /getcourse/{creator} path call has exception" + e.getMessage());
			return null;
		}
	}

	@GetMapping("/updatecourse/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Course getById(@PathVariable Integer id) {
		Course course = cservice.get(id).orElse(null);
		return course;

	}

	@PutMapping("/updatecourse")
	@CrossOrigin(origins = "http://localhost:4200")
	public String updatecourse(@RequestBody Course course) {
		// System.out.println("update course "+course);
		try {
			cservice.updateCourse(course);
			return "Course Updated";
		} catch (Exception e) {
			logger.error(" /dupdateCourse path call has exception" + e.getMessage());
			return "Updated Failed !!";
		}

	}

	@DeleteMapping("/deleteCourse/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Course> deleteCourse(@PathVariable int id) {
		try {
			cservice.deleteCourse(id);
			return (List<Course>) cservice.findAllCourse();
		} catch (Exception e) {
			logger.error(" /deleteCourse/{id} path call has exception" + e.getMessage());
			return null;
		}

	}
}
