package com.example.day02.employee;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
	
	
	public EmployeeResponse get(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		if(result.isPresent()) {
			return  new EmployeeResponse(id,result.get().getName());
		}
		throw new RuntimeException("Employee not found with id=" + id);
	}

}
