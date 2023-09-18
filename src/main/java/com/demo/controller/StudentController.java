package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Student;
import com.demo.repository.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	StudentRepository studentRepository;

	@GetMapping("/students")
	public List<Student> getStudent() {
		return studentRepository.findAll();

	}

	@Cacheable("Student-cache")
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable("id") int id) {
		System.out.println("Finding student by ID:" + id);
		return studentRepository.findById(id).get();

	}

	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);

	}

	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		return studentRepository.save(student);

	}

	@CacheEvict("Student-cache")
	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable("id") int id) {
		studentRepository.deleteById(id);

	}
}
