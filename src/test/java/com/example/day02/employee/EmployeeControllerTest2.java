package com.example.day02.employee;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest2 {

	@Autowired TestRestTemplate restTemplate;
	
	@MockBean
	EmployeeRepository employeeRepository;
	
//	@AfterEach
//	public void deleteAll() {
//		employeeRepository.deleteAll();
//	}
	
	@Test
    public void getById2() {
		Employee e = new Employee();
		e.setId(100);
		e.setName("test");
//		employeeRepository.save(e);
		when(employeeRepository.findById(100)).thenReturn(Optional.of(e));
		
        EmployeeResponse result = restTemplate.getForObject("/employee/100", EmployeeResponse.class);
        assertEquals(100,result.getId());
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
