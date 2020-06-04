package com.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.app.registration.model.Course;
import com.app.registration.model.TrainingMaterial;
import com.app.registration.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
class CourseApplicationTestsITTest {

	@Autowired
	private MockMvc mockMvc;
	
	/*
	 * Integration Test for For Course
	 */
	
	@Test
	public void getAllCourseItTest() throws Exception {

		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/getcourse").accept(MediaType.APPLICATION_JSON)).andReturn();

		System.out.println(mvcResult.getResponse());
	}
	
	@Test
	public void postCourseItTest() throws Exception {
		Course mycourse = new Course();
		mycourse.setCreator("sangram");
		mycourse.setId(1);
		mycourse.setDescription("hi");
		mycourse.setFeedback("feedback");
		mycourse.setlastUpdated("20-5-2020");
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(mycourse);

		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post("/addcourse").contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andReturn();
		System.out.println(mvcResult);
	}
	
	@Test
	public void getCourseItTest() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getcourse/sangram")).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println("get course testhit " + content);
	}
	
	@Test
	public void deleteCourseItsTest() throws Exception {
		
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/deleteCourse/1")).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
	}
	
	/*
	 * Integration Test for For TrainingMatrial controller
	 */
	@Test
	public void getAllTrainingMatrialItTest() throws Exception {

		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/getmatrial").accept(MediaType.APPLICATION_JSON)).andReturn();

	}

	@Test
	public void postTrainingMatrialItTest() throws Exception {
		TrainingMaterial matrial = new TrainingMaterial();
		matrial.setCourse("java");
		matrial.setPpt("link to ppt");
		matrial.setRecording("link recording");
		matrial.setAssignment("link assignment");
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(matrial);

		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post("/addmatrial").contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Course Matrial added Successfully");
	}

	@Test
	public void getTrainingMatrialItTest() throws Exception {
		
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getmatrial/java")).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
	}

	@Test
	public void deleteTrainingMatrialItTest() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/deletematrial/Java")).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	/*
	 * Integration Test for For Registration controller
	 */
	@Test
	public void postRegisterItTest() throws Exception {
		User myuser=new User();
		User u = new User();
		myuser.setId(1);
		myuser.setEmailId("sangram@gmail.com");
		myuser.setPassword("1234");
		myuser.setUserName("sang");
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(myuser);

		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post("/registeruser").contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	@Test
	public void postLoginItTest() throws Exception {
		User myuser=new User();
		myuser.setId(1);
		myuser.setEmailId("sangram@gmail.com");
		myuser.setPassword("1234");
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(myuser);

		
		Exception exception = assertThrows(Exception.class, () -> {
			MvcResult mvcResult = mockMvc.perform(
					MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
					.andReturn();
	    });
	 
	    String expectedMessage = "Bad credentational";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	    
		System.out.println("login hit ");
	}

}
