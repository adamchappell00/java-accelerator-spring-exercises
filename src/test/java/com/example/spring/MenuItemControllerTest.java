package com.example.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MenuItemControllerTest {


	@Autowired
	private MockMvc mockMvc;

	private ObjectMapper objectMapper = new ObjectMapper();

	// Sanity Tests - Context Loads to make sure the MVC bean is working
	@Test
	public void contextLoads() {
		assertNotNull(mockMvc);
	}

}
