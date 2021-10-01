package com.example.day02.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@WebMvcTest(EmployeeController.class)
public class EmployeeControllerWebMvcTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private EmployeeService service;
	
	@Test
	public void getById() throws Exception {
		//arrange
		EmployeeResponse data = new EmployeeResponse(1,"XYZ");
		when(service.get(1)).thenReturn(data);
		//act
		
		MvcResult result = mvc.perform(get("/employee/1")).andExpect(status().isOk()).andReturn();
		ObjectMapper mapper = new ObjectMapper();
		EmployeeResponse resp = mapper.readValue(result.getResponse().getContentAsByteArray(), EmployeeResponse.class);
		//assert
		assertEquals(1,resp.getId());
		assertEquals("XYZ",resp.getName());
		
	}
}
