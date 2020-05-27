package com.app.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.registration.model.User;
import com.app.registration.repository.RegistrationRepository;

@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository repo; 
	
	public User saveUser(User user) {
		//this will save data to database
		return repo.save(user);
	}
	
	//this will return user with email from database
	public User fetchUserByEmailId(String email) {
		return repo.findByEmailId(email);
	}
	
	public User fetchUserByEmailIdAndPassword(String email,String password) {
		return repo.findByEmailIdAndPassword(email, password);
	}
	
}
