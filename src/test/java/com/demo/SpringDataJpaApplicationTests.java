package com.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.model.Student;
import com.demo.repository.StudentRepository;

@SpringBootTest
class SpringDataJpaApplicationTests {
	@Autowired
	public StudentRepository repository;

	@Test
	public void testCreateStudent() {
		Student student = new Student();
		student.setId(1);
		student.setName("Nanda");
		student.setScore(99);
		repository.save(student);
		Student savedStudent = repository.findById(1).get();
		assertNotNull(savedStudent);
	}

}
