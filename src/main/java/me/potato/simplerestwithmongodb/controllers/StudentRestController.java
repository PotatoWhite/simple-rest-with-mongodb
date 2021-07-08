/*
 * StudentRestController.java 2021. 07. 08
 *
 * Copyright 2021 Naver Cloud Corp. All rights Reserved.
 * Naver Business Platform PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package me.potato.simplerestwithmongodb.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.potato.simplerestwithmongodb.controllers.dtos.StudentDto;
import me.potato.simplerestwithmongodb.services.StudentService;

/**
 * @author dongju.paek
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentRestController {
	private final StudentService studentService;

	@GetMapping("/")
	public List<StudentDto> getAllStudents() {
		return studentService.findAll().stream().map(StudentDto::new).collect(Collectors.toList());
	}

	@GetMapping("/byStudentNumber/{studentNumber}")
	public StudentDto getStudentByStudentNumber(@PathVariable Long studentNumber) {
		var aStudent = studentService.findByStudentNumber(studentNumber);
		if (aStudent == null)
			return null;

		return new StudentDto(aStudent);
	}

	@GetMapping("/byEmail/{email}")
	public StudentDto getStudentByEmail(@PathVariable String email) {
		var aStudent = studentService.findByEmail(email);
		if (aStudent == null)
			return null;

		return new StudentDto(aStudent);
	}

	@GetMapping("/orderByGpa")
	public List<StudentDto> findAllbyGpaDesc() {
		return studentService.findAll().stream().map(StudentDto::new).collect(Collectors.toList());
	}

	@PostMapping("/save")
	public ResponseEntity saveOrUpdateStudent(@RequestBody StudentDto student) {
		var saved = studentService.saveOrUpdateStudent(student.toStudent());
		if (saved == null)
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	@DeleteMapping("/delete/{studentNumber}")
	public ResponseEntity delete(@PathVariable Long studentNumber) {
		var found = studentService.findByStudentNumber(studentNumber);

		if (found == null)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		studentService.deleteStudentById(found.getId());
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}