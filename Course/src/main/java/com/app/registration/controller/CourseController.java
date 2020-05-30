package com.app.registration.controller;

import java.util.List;
import java.util.Optional;

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
	@Autowired
	private CourseService cservice;
	
	@PostMapping("/addcourse")
	@CrossOrigin(origins = "http://localhost:4200")
	public String addCourse(@RequestBody Course course) throws Exception {
		String tempskill= course.getSkill();
		if(tempskill !=null && !"".equals(tempskill)) {
			Course courseObj= cservice.fetchCourseBySkill(tempskill);
			if(courseObj != null) {
				return "Course with "+tempskill+" id is already exist";
			}
		}
		 cservice.saveCourse(course);
		return "Course added Successfully";
	}
	@GetMapping("/getcourse")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Course> getCourse() {
		//if()
		//return "hello";
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
	public List<Course>  getBycreator(@PathVariable String creator) {
	    try {
	    	List<Course> course = cservice.fetchCourseByCreator(creator);
	        return course;
	    } catch (Exception e) {
	        return null;
	    }      
	}
//	@PutMapping("/updatecourse/{id}")
//	public Course updatecourse(@RequestBody Course course, @PathVariable Integer id) {
//	    try {
//	    	Optional<Course> existCourse =null;
//	        existCourse = cservice.get(id);
//	        existCourse.setCreator(course.getCreator());
//	        existCourse.setDescription(course.getDescription());
//	        existCourse.setSkill(course.getSkill());
//	        existCourse.setPrerequisite(course.getPrerequisite());
//	        existCourse.setFeedback(course.getFeedback());
//	        existCourse.setRatting(course.getRatting());
//	        cservice.saveCourse(existCourse);
//	        return course;
//	    } catch (Exception e) {
//	        return null;
//	    }      
//	}
	
	@DeleteMapping("/deleteCourse/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Course> deleteCourse(@PathVariable int id) {
		try {
			cservice.deleteCourse(id);
			 return (List<Course>) cservice.findAllCourse();
		}catch(Exception e) {
			return null;
		}
		
	}
}
