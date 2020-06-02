package com.app;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.app.registration.model.Course;
import com.app.registration.model.TrainingMaterial;
import com.app.registration.model.User;
import com.app.registration.repository.CourseRepository;
import com.app.registration.repository.RegistrationRepository;
import com.app.registration.repository.TrainingMatrialRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CourseApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	CourseRepository crepo;
	@MockBean
	RegistrationRepository rrepo;
	@MockBean
	TrainingMatrialRepository trepo;

	@Test
	void contextLoads() throws Exception {
	}

	/*
	 * Unit Test for For Course controller
	 */

	@Test
	public void getAllCourseTest() throws Exception {

		Mockito.when(crepo.findAll()).thenReturn(Collections.emptyList());

		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/getcourse").accept(MediaType.APPLICATION_JSON)).andReturn();

		System.out.println(mvcResult.getResponse());
		Mockito.verify(crepo).findAll();
	}

	@Test
	public void postCourseTest() throws Exception {
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

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Course added Successfully");
	}

	@Test
	public void getCourseTest() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getcourse/sangram")).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println("get course testhit " + content);
		// System.out.println("byiiiii "+(crepo).findAll());
		Mockito.verify(crepo).findByCreator("sangram");
	}

	@Test
	public void deleteCourseTest() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/deleteCourse/1")).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println("delete course testhit " + content);
		// System.out.println("byiiiii "+(crepo).findAll());
		Mockito.verify(crepo).findAll();
	}

	/*
	 * Unit Test for For TrainingMatrial controller
	 */
	@Test
	public void getAllTrainingMatrialTest() throws Exception {

		Mockito.when(trepo.findAll()).thenReturn(Collections.emptyList());

		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/getmatrial").accept(MediaType.APPLICATION_JSON)).andReturn();

		System.out.println("get matrial hit " + mvcResult.getResponse());
		Mockito.verify(trepo).findAll();
	}

	@Test
	public void postTrainingMatrialTest() throws Exception {
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
	public void getTrainingMatrialTest() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getmatrial/java")).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println("get Training Matrial testhit " + content);
		// System.out.println("byiiiii "+(crepo).findAll());
		Mockito.verify(trepo).findByCourse("java");
	}

	@Test
	public void deleteTrainingMatrialTest() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/deletematrial/Java")).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println("delete course testhit " + content);
		// System.out.println("byiiiii "+(crepo).findAll());
		Mockito.verify(trepo).findAll();
	}

	/*
	 * Unit Test for For Registration controller
	 */
	@Test
	public void postRegisterTest() throws Exception {
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
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println("register hit "+content);
		assertNotNull(content);
	}
	
	@Test
	public void postLoginTest() throws Exception {
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
//	@Before(value = "")
//	private void setUp() {
//		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//	}
//
//	@Test
//	public void saveCourseTest() throws Exception {
//		Course c = new Course(1, "Pankti", "RDBMS", "RDBMS", "Nothing", "29-05-2020", "This is best course on RDBMS",
//				4);
//		String jsonRequest = om.writeValueAsString(c);
//		System.out.println(jsonRequest);
//		MvcResult result = mockMvc
//				.perform(post("http://localhost:8080/addcourse").content(jsonRequest).content(MediaType.APPLICATION_JSON)).andReturn();
//		String resultContent=result.getResponse().getContentAsString();
//		assertEquals("Course added Successfully",resultContent);
//	}

}
