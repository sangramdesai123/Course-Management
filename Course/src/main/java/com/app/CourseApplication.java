package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApplication {
	/*
	 * My login and register user urls
	 * 
	 * http://localhost:8080/registeruser
	 * 
	 * http://localhost:8080/login
	 * 
	 * */
	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}

}
