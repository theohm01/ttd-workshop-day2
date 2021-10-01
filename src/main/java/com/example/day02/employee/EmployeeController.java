package com.example.day02.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@GetMapping("/employee/{id}")
	public EmployeeResponse getById(@PathVariable(name = "id") int id) {
		return new EmployeeResponse(id, "test");
	}
}
