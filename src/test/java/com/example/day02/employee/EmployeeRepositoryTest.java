package com.example.day02.employee;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository em;
	
	@Test
	public void case01() {
		//arrange
		Employee e = new Employee();
		e.setName("test");
		em.save(e);
		//act
		Optional<Employee> result = em.findById(1);
		//assert
		assertTrue(result.isPresent());
		assertEquals(1, result.get().getId());
		assertEquals("test", result.get().getName());
	}
	
}
