package com.app.registration.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.model.User;
import com.app.registration.service.RegistrationService;

@RestController
public class RegistrationController {

	/*
	 * when user submit the form this will directly function will be map 
	 */
	Logger logger=LoggerFactory.getLogger(CourseController.class);
	@Autowired
	private RegistrationService service;
	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		if(tempEmailId !=null && !"".equals(tempEmailId)) {
			User userObj=service.fetchUserByEmailId(tempEmailId);
			if(userObj != null) {
				logger.info(" registeruser path call email id exist");
				throw new Exception("User with "+tempEmailId+" id is already exist");
			}
		}
		User userObj=service.saveUser(user);
		return userObj;
	}
	
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId =user.getEmailId();
		String tempPass = user.getPassword();
		User userObj=null;
		if(tempEmailId != null && tempPass != null) {
			userObj=service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
		}
		if(userObj==null) {
			logger.info(" login path call Bad credentational");
			throw new Exception("Bad credentational");
		}
		return userObj;
	}
}
