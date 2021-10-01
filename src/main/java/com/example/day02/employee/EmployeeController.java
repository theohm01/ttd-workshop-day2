package com.example.day02.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee/{id}")
	public EmployeeResponse getById(@PathVariable(name = "id") String id) {
		return employeeService.get(Integer.valueOf(id));
	}
	
	@GetMapping("/employee")
	public EmployeeResponse[] getAll() {
		EmployeeResponse[] responses = new EmployeeResponse[2];
		responses[0]=new EmployeeResponse(1, "test");
		responses[1]=new EmployeeResponse(2, "test2");
		return  responses;
	}
}
