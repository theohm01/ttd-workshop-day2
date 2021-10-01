package com.example.day02.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(EmployeeController.class)
public class EmployeeControllerWebMvcTest {

	@Autowired
	private MockMvc mvc;
	
	
	@Test
	public void getById() throws Exception {
		MvcResult result = mvc.perform(get("/employee/1")).andExpect(status().isOk()).andReturn();
		ObjectMapper mapper = new ObjectMapper();
		EmployeeResponse resp = mapper.readValue(result.getResponse().getContentAsByteArray(), EmployeeResponse.class);
		assertEquals(1,resp.getId());
		assertEquals("test",resp.getName());
		
	}
}
