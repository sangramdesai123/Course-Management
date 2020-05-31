package com.app.registration.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.model.Course;
import com.app.registration.model.TrainingMaterial;
import com.app.registration.service.TrainingMatrialService;

@RestController
public class TrainingMaterialController {
	@Autowired
	public TrainingMatrialService tservice;
	
	@GetMapping("/getmatrial")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<TrainingMaterial> getTrainingMaterial() {
		//if()
		//return "hello";
		return (List<TrainingMaterial>) tservice.findAllTrainingMaterial();
	}
	
	@PostMapping("/addmatrial")
	@CrossOrigin(origins = "http://localhost:4200")
	public String addTrainingMaterial(@RequestBody TrainingMaterial material) throws Exception {
		String tempcourse= material.getCourse();
		if(tempcourse !=null && !"".equals(tempcourse)) {
			List<TrainingMaterial> matrialObj= tservice.fetchMatrialByCourse(tempcourse);
			if(!matrialObj.isEmpty()) {
				return "Course with "+tempcourse+" is already exist";
			}
		}
		 tservice.saveTrainingMaterial(material);
		return "Course Matrial added Successfully";
	}
	
	@GetMapping("/getmatrial/{course}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<TrainingMaterial>  getBycourse(@PathVariable String course) {
	    try {
	    	List<TrainingMaterial> matrial = tservice.fetchMatrialByCourse(course);
	        return matrial;
	    } catch (Exception e) {
	        return null;
	    }      
	}
	
	@DeleteMapping("/deletematrial/{course}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<TrainingMaterial>  deleteMatrial(@PathVariable String course) {
		try {
			tservice.deleteTrainingMaterial(course);
			 return tservice.findAllTrainingMaterial();
		}catch(Exception e) {
			return null;
		}
		
	}
	
}
