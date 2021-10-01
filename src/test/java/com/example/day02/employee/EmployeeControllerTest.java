package com.example.day02.employee;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

	@Autowired TestRestTemplate restTemplate;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@AfterEach
	public void deleteAll() {
		employeeRepository.deleteAll();
	}
	
	@Test
    public void getById() {
		Employee e = new Employee();
		e.setId(1);
		e.setName("test");
		employeeRepository.save(e);
		
        EmployeeResponse result = restTemplate.getForObject("/employee/1", EmployeeResponse.class);
        assertEquals(1,result.getId());
        assertEquals("test",result.getName());
    }
	
	@Test
	public void getAll() {
		EmployeeResponse[] results = restTemplate.getForObject("/employee", EmployeeResponse[].class);
		EmployeeResponse result = results[0];
		EmployeeResponse result2 = results[1];
		assertEquals(1,result.getId());
		assertEquals("test",result.getName());
		assertEquals(2,result2.getId());
		assertEquals("test2",result2.getName());
	}

}
