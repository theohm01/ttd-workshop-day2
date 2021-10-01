package com.example.day02.employee;

public class EmployeeResponse {
	public int id;
	public String name;

	
	
	public EmployeeResponse() {
	}

	public EmployeeResponse(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
