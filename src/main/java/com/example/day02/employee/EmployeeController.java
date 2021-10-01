package com.example.day02.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@GetMapping("/employee/{id}")
	public EmployeeResponse getById(@PathVariable(name = "id") int id) {
		return new EmployeeResponse(id, "test");
	}
	
	@GetMapping("/employee")
	public EmployeeResponse[] getAll() {
		EmployeeResponse[] responses = new EmployeeResponse[2];
		responses[0]=new EmployeeResponse(1, "test");
		responses[1]=new EmployeeResponse(2, "test2");
		return  responses;
	}
}
