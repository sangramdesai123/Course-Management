package com.app;




import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.web.context.WebApplicationContext;


import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
class CourseApplicationTests {

	@Test
	void contextLoads() {
	}

	/*
	 * for Course Service User testing
	 */
	ObjectMapper om = new ObjectMapper();
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;

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
