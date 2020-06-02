package com.app;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
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
import com.app.registration.repository.CourseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CourseApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() throws Exception {
	}

	/*
	 * Unit Test for For Course controller
	 */
	@MockBean
	CourseRepository crepo;

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
		System.out.println("get course testhit "+content);
		//System.out.println("byiiiii "+(crepo).findAll());
		Mockito.verify(crepo).findByCreator("sangram");
	}
	
	@Test
	public void deleteCourseTest() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/deleteCourse/1")).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println("delete course testhit "+content);
		//System.out.println("byiiiii "+(crepo).findAll());
		Mockito.verify(crepo).findAll();
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
