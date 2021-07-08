/*
 * StudentServiceImpl.java 2021. 07. 08
 *
 * Copyright 2021 Naver Cloud Corp. All rights Reserved.
 * Naver Business Platform PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package me.potato.simplerestwithmongodb.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.potato.simplerestwithmongodb.models.Student;
import me.potato.simplerestwithmongodb.repositories.StudentRepository;

/**
 * @author dongju.paek
 */
@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findByStudentNumber(long studentNumber) {
		return studentRepository.findByStudentNumber(studentNumber);
	}

	@Override
	public Student findByEmail(String email) {
		return studentRepository.findByEmail(email);
	}

	@Override
	public List<Student> findAllByOrderByGpaDesc() {
		return studentRepository.findAllByOrderByGpaDesc();
	}

	@Override
	public Student saveOrUpdateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(String id) {
		studentRepository.deleteById(id);
	}
}